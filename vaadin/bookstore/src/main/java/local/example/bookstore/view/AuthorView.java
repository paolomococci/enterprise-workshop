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

package local.example.bookstore.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.*;

import local.example.bookstore.data.entity.AuthorEntity;
import local.example.bookstore.data.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@PageTitle("Author")
@Route(value = "author/:authorID?/:action?(edit)", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
public class AuthorView
        extends Div
        implements BeforeEnterObserver {

    private final String AUTHOR_ID = "authorID";
    private final String TEMPLATE_AUTHOR_EDIT_ROUTE = "author/%d/edit";
    private final String TEMPLATE_RENDER_ACTIVE = "<iron-icon hidden='[[!item.active]]' icon='vaadin:check' style='width: var(--lumo-icon-size-s); height: var(--lumo-icon-size-s); color: var(--lumo-primary-text-color);'></iron-icon><iron-icon hidden='[[item.active]]' icon='vaadin:minus' style='width: var(--lumo-icon-size-s); height: var(--lumo-icon-size-s); color: var(--lumo-disabled-text-color);'></iron-icon>";

    private Grid<AuthorEntity> authorEntityGrid = new Grid<>(AuthorEntity.class, false);

    private TextField name;
    private TextField surname;
    private TextField alias;
    private TextField email;
    private DatePicker birthday;
    private Checkbox active;
    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private BeanValidationBinder<AuthorEntity> authorEntityBeanValidationBinder;

    private AuthorEntity authorEntity;
    private AuthorService authorService;

    public AuthorView(
            @Autowired AuthorService authorService
    ) {
        this.addClassNames("author-view", "flex", "flex-col", "h-full");
        this.authorService = authorService;

        SplitLayout splitLayout = new SplitLayout();
        splitLayout.setSizeFull();

        this.createGridLayout(splitLayout);
        this.createEditorLayout(splitLayout);
        this.add(splitLayout);

        TemplateRenderer<AuthorEntity> authorActiveTemplateRenderer;
        authorActiveTemplateRenderer = TemplateRenderer.<AuthorEntity>of(TEMPLATE_RENDER_ACTIVE)
                .withProperty("active", AuthorEntity::getActive);

        this.authorEntityGrid.addColumn(AuthorEntity::getName).setHeader("Name").setAutoWidth(true);
        this.authorEntityGrid.addColumn(AuthorEntity::getSurname).setHeader("Surname").setAutoWidth(true);
        this.authorEntityGrid.addColumn(AuthorEntity::getAlias).setHeader("Alias").setAutoWidth(true);
        this.authorEntityGrid.addColumn(AuthorEntity::getEmail).setHeader("Email").setAutoWidth(true);
        this.authorEntityGrid.addColumn(AuthorEntity::getBirthday).setHeader("Birthday").setAutoWidth(true);
        this.authorEntityGrid.addColumn(authorActiveTemplateRenderer).setHeader("Active").setAutoWidth(true);

        this.authorEntityGrid.setDataProvider(
                DataProvider.fromCallbacks(
                        query -> this.authorService.readAll().stream(),
                        query -> this.authorService.count()
                )
        );

        this.authorEntityGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        this.authorEntityGrid.setHeightFull();

        this.authorEntityGrid.asSingleSelect().addValueChangeListener(
                valueChangeEvent -> {
                    if (valueChangeEvent.getValue() != null) {
                        UI.getCurrent()
                                .navigate(
                                        String.format(
                                                TEMPLATE_AUTHOR_EDIT_ROUTE,
                                                valueChangeEvent.getValue().getId()
                                        )
                                );
                    } else {
                        this.clearForm();
                        UI.getCurrent().navigate(AuthorView.class);
                    }
                }
        );

        this.authorEntityBeanValidationBinder = new BeanValidationBinder<>(AuthorEntity.class);

        this.cancel.addClickListener(cancelClickEvent -> {
            this.clearForm();
            this.refreshGrid();
        });

        this.save.addClickListener(saveClickEvent -> {
            try {
                if (this.authorEntity == null) {
                    this.authorEntity = new AuthorEntity();
                }
                this.authorEntityBeanValidationBinder.writeBean(this.authorEntity);
                this.authorService.update(this.authorEntity);
                Notification.show("author fields saved");
                UI.getCurrent().navigate(AuthorView.class);
            } catch (ValidationException validationException) {
                Notification.show("an exception happened while trying to save the author fields");
            }
        });
    }

    private void createEditorLayout(SplitLayout editorSplitLayout) {
        Div editorLayoutDiv = new Div();
        editorLayoutDiv.setClassName("flex flex-col");
        editorLayoutDiv.setWidth("400px");
        Div editorDiv = new Div();
        editorDiv.setClassName("p-l flex-grow");
        editorLayoutDiv.add(editorDiv);
        FormLayout formLayout = new FormLayout();
        this.name = new TextField("Name");
        this.surname = new TextField("Surname");
        this.alias = new TextField("Alias");
        this.email = new TextField("Email");
        this.birthday = new DatePicker("Birthday");
        this.active = new Checkbox("Active");
        this.active.getStyle().set("padding-top", "var(--lumo-space-m)");
        Component[] componentFields = new Component[]{
                this.name,
                this.surname,
                this.alias,
                this.email,
                this.birthday,
                this.active
        };
        for (Component componentField : componentFields) {
            ((HasStyle) componentField).addClassName("full-width");
        }
        formLayout.add(componentFields);
        editorDiv.add(formLayout);
        this.createButtonLayout(editorLayoutDiv);
        editorSplitLayout.addToSecondary(editorLayoutDiv);
    }

    private void createButtonLayout(Div buttonsLayoutDiv) {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setClassName("w-full flex-wrap bg-contrast-5 py-s px-l");
        buttonLayout.setSpacing(true);
        this.cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        this.save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(this.save, this.cancel);
        buttonsLayoutDiv.add(buttonLayout);
    }

    private void createGridLayout(SplitLayout splitLayout) {
        Div gridWrapperDiv = new Div();
        gridWrapperDiv.setId("grid-wrapper");
        gridWrapperDiv.setWidthFull();
        splitLayout.addToPrimary(gridWrapperDiv);
        gridWrapperDiv.add(this.authorEntityGrid);
    }

    private void refreshGrid() {
        this.authorEntityGrid.select(null);
        this.authorEntityGrid.getDataProvider().refreshAll();
    }

    private void clearForm() {
        this.populateForm(null);
    }

    private void populateForm(AuthorEntity authorEntity) {
        this.authorEntity = authorEntity;
        this.authorEntityBeanValidationBinder.readBean(this.authorEntity);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        Optional<Long> authorId = beforeEnterEvent.getRouteParameters().getLong(AUTHOR_ID);
        if (authorId.isPresent()) {
            Optional<AuthorEntity> authorFromBackend = this.authorService.read(authorId.get());
            if (authorFromBackend.isPresent()) {
                this.populateForm(authorFromBackend.get());
            } else {
                Notification.show(
                        String.format(
                                "Sorry, author defined by ID: %d could not be found!",
                                authorId.get()
                        ),
                        2500,
                        Notification.Position.BOTTOM_START
                );
                this.refreshGrid();
                beforeEnterEvent.forwardTo(AuthorView.class);
            }
        }
    }
}
