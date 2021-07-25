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

package local.example.groupware.view;

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
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import elemental.json.Json;

import local.example.groupware.data.entity.User;

import local.example.groupware.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriUtils;

import javax.annotation.security.RolesAllowed;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

@PageTitle("Users")
@RolesAllowed("admin")
//@AnonymousAllowed
@Route(value = "users/:userID?/:action?(edit)", layout = MainView.class)
public class UserView
        extends Div
        implements BeforeEnterObserver {

    private final String USER_ID = "userID";
    private final String USER_EDIT_ROUTE_TEMPLATE = "users/%d/edit";

    private Grid<User> userGrid = new Grid<>(User.class, false);

    private TextField username;
    private TextField name;
    private TextField hashedPassword;
    private TextField roles;
    private Upload profileImageUrl;
    private Image profileImageUrlPreview;

    private Button save = new Button("Save");
    private Button cancel = new Button("Cancel");

    private BeanValidationBinder<User> userBeanValidationBinder;

    private User user;

    private UserService userService;

    public UserView(@Autowired UserService userService) {
        this.userService = userService;
        addClassNames("users-view", "flex", "flex-col", "h-full");

        SplitLayout splitLayout = new SplitLayout();
        splitLayout.setSizeFull();

        createGridLayout(splitLayout);
        createEditorLayout(splitLayout);

        add(splitLayout);

        this.userGrid.addColumn("username").setAutoWidth(true);
        this.userGrid.addColumn("name").setAutoWidth(true);
        this.userGrid.addColumn("hashedPassword").setAutoWidth(true);
        this.userGrid.addColumn("roles").setAutoWidth(true);

        TemplateRenderer<User> profilePictureUrlRenderer;
        profilePictureUrlRenderer = TemplateRenderer
                .<User>of(
                    "<span style='border-radius: 50%; overflow: hidden; display: flex; align-items: center; justify-content: center; width: 64px; height: 64px'><img style='max-width: 100%' src='[[item.profilePictureUrl]]' /></span>")
                .withProperty("profilePictureUrl", User::getProfileImageUrl);

        this.userGrid.addColumn(profilePictureUrlRenderer)
                .setHeader("Profile Picture Url")
                .setWidth("96px")
                .setFlexGrow(0);

        this.userGrid.setItems(query -> userService.readAll().stream());
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

        attachImageUpload(profileImageUrl, profileImageUrlPreview);

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
                this.user.setProfileImageUrl(this.profileImageUrlPreview.getSrc());

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
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        Optional<Long> userId = beforeEnterEvent.getRouteParameters().getLong(USER_ID);
        if (userId.isPresent()) {
            Optional<User> userFromBackend = this.userService.get(userId.get());
            if (userFromBackend.isPresent()) {
                populateForm(userFromBackend.get());
            } else {
                Notification.show(String.format("user not found, ID = %d", userId.get()), 3000,
                        Notification.Position.BOTTOM_START);
                refreshGrid();
                beforeEnterEvent.forwardTo(UserView.class);
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
        Component[] fields = new Component[] {
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
        wrapper.add(this.userGrid);
    }

    private void attachImageUpload(Upload upload, Image preview) {
        ByteArrayOutputStream uploadBuffer = new ByteArrayOutputStream();
        upload.setAcceptedFileTypes("image/*");
        upload.setReceiver((fileName, mimeType) -> {
            return uploadBuffer;
        });
        upload.addSucceededListener(e -> {
            String mimeType = e.getMIMEType();
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
