/**
 *
 * Copyright 2021 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.user.view;

import java.util.Optional;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;

import elemental.json.Json;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import local.example.user.data.entity.User;
import local.example.user.data.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.util.UriUtils;

@PageTitle("Users")
@Route(value = "users/:userID?/:action?(edit)", layout = MainView.class)
public class UserView
        extends Div
        implements BeforeEnterObserver {

    private final String USER_ID = "userID";
    private final String USER_EDIT_ROUTE_TEMPLATE = "users/%d/edit";
    private final String SPAN = "<span style='border-radius: 50%; overflow: hidden; display: flex; align-items: center; justify-content: center; width: 64px; height: 64px'><img style='max-width: 100%' src='[[item.profileImageUrl]]' /></span>";

    private final Grid<User> userGrid = new Grid<>(User.class, false);

    private TextField username;
    private TextField name;
    private TextField hashedPassword;
    private TextField roles;
    private Upload profileImageUrl;
    private Image profileImageUrlPreview;

    private final Button cancel = new Button("Cancel");
    private final Button save = new Button("Save");

    private final BeanValidationBinder<User> userBeanValidationBinder;

    private User user;

    private final UserService userService;

    public UserView(@Autowired UserService userService) {
        this.userService = userService;
        this.addClassNames("users-view", "flex", "flex-col", "h-full");

        SplitLayout splitLayout = new SplitLayout();
        splitLayout.setSizeFull();

        createGridLayout(splitLayout);
        createEditorLayout(splitLayout);

        this.add(splitLayout);

        this.userGrid.addColumn("username").setAutoWidth(true);
        this.userGrid.addColumn("name").setAutoWidth(true);
        this.userGrid.addColumn("hashedPassword").setAutoWidth(true);
        this.userGrid.addColumn("roles").setAutoWidth(true);

        TemplateRenderer<User> profileImageUrlRenderer;
        profileImageUrlRenderer = TemplateRenderer
                .<User>of(
                       SPAN
                )
                .withProperty("profileImageUrl", User::getProfileImageUrl);

        this.userGrid.addColumn(profileImageUrlRenderer).setHeader("Profile Image Url").setWidth("96px").setFlexGrow(0);

        this.userGrid.setItems(query -> this.userService
                .readAllPageable(
                PageRequest.of(
                        query.getPage(),
                        query.getPageSize(),
                        VaadinSpringDataHelpers.toSpringDataSort(query))
                )
                .stream());
        this.userGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        this.userGrid.setHeightFull();

        this.userGrid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() != null) {
                UI.getCurrent().navigate(String.format(USER_EDIT_ROUTE_TEMPLATE, event.getValue().getId()));
            } else {
                clearForm();
                UI.getCurrent().navigate(UserView.class);
            }
        });

        this.userBeanValidationBinder = new BeanValidationBinder<>(User.class);

        this.userBeanValidationBinder.bindInstanceFields(this);

        attachImageUpload(this.profileImageUrl, this.profileImageUrlPreview);

        this.cancel.addClickListener(buttonClickEvent -> {
            clearForm();
            refreshGrid();
        });

        this.save.addClickListener(buttonClickEvent -> {
            try {
                if (this.user == null) {
                    this.user = new User();
                }
                this.userBeanValidationBinder.writeBean(this.user);
                this.user.setProfileImageUrl(profileImageUrlPreview.getSrc());

                this.userService.update(this.user);
                clearForm();
                refreshGrid();
                Notification.show("user fields stored");
                UI.getCurrent().navigate(UserView.class);
            } catch (ValidationException validationException) {
                Notification.show("an exception happened while trying to store the user fields");
            }
        });

    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        Optional<Long> userId = event.getRouteParameters().getLong(USER_ID);
        if (userId.isPresent()) {
            Optional<User> userFromBackend = this.userService.get(userId.get());
            if (userFromBackend.isPresent()) {
                populateForm(userFromBackend.get());
            } else {
                Notification.show(String.format("user not found, ID = %d", userId.get()), 2500,
                        Notification.Position.BOTTOM_START);
                refreshGrid();
                event.forwardTo(UserView.class);
            }
        }
    }

    private void createEditorLayout(SplitLayout splitLayout) {
        Div editorLayoutDiv = new Div();
        editorLayoutDiv.setClassName("flex flex-col");
        editorLayoutDiv.setWidth("400px");

        Div editorDiv = new Div();
        editorDiv.setClassName("p-l flex-grow");
        editorLayoutDiv.add(editorDiv);

        FormLayout formLayout = new FormLayout();
        this.username = new TextField("Username");
        this.name = new TextField("Name");
        this.hashedPassword = new TextField("Hashed Password");
        this.roles = new TextField("Roles");
        Label profileImageUrlLabel = new Label("Profile Picture Url");
        this.profileImageUrlPreview = new Image();
        this.profileImageUrlPreview.setWidth("100%");
        this.profileImageUrl = new Upload();
        this.profileImageUrl.getStyle().set("box-sizing", "border-box");
        this.profileImageUrl.getElement().appendChild(profileImageUrlPreview.getElement());

        Component[] fields;
        fields = new Component[] {
                this.username,
                this.name,
                this.hashedPassword,
                this.roles,
                profileImageUrlLabel,
                this.profileImageUrl
        };

        for (Component field : fields) {
            ((HasStyle) field).addClassName("full-width");
        }
        formLayout.add(fields);
        editorDiv.add(formLayout);
        createButtonLayout(editorLayoutDiv);

        splitLayout.addToSecondary(editorLayoutDiv);
    }

    private void createButtonLayout(Div editorLayoutDiv) {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setClassName("w-full flex-wrap bg-contrast-5 py-s px-l");
        buttonLayout.setSpacing(true);
        this.cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        this.save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(this.save, this.cancel);
        editorLayoutDiv.add(buttonLayout);
    }

    private void createGridLayout(SplitLayout splitLayout) {
        Div wrapper = new Div();
        wrapper.setId("grid-wrapper");
        wrapper.setWidthFull();
        splitLayout.addToPrimary(wrapper);
        wrapper.add(userGrid);
    }

    private void attachImageUpload(Upload upload, Image preview) {
        ByteArrayOutputStream uploadBuffer = new ByteArrayOutputStream();
        upload.setAcceptedFileTypes("image/*");
        upload.setReceiver((fileName, mimeType) -> {
            return uploadBuffer;
        });
        upload.addSucceededListener(succeededEvent -> {
            String mimeType = succeededEvent.getMIMEType();
            String base64ImageData = Base64.getEncoder().encodeToString(uploadBuffer.toByteArray());
            String dataUrl = "data:" + mimeType + ";base64,"
                    + UriUtils.encodeQuery(base64ImageData, StandardCharsets.UTF_8);
            upload.getElement().setPropertyJson("files", Json.createArray());
            preview.setSrc(dataUrl);
            uploadBuffer.reset();
        });
        preview.setVisible(false);
    }

    private void refreshGrid() {
        this.userGrid.select(null);
        this.userGrid.getLazyDataView().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(User value) {
        this.user = value;
        this.userBeanValidationBinder.readBean(this.user);
        this.profileImageUrlPreview.setVisible(value != null);
        if (value == null) {
            this.profileImageUrlPreview.setSrc("");
        } else {
            this.profileImageUrlPreview.setSrc(value.getProfileImageUrl());
        }
    }
}
