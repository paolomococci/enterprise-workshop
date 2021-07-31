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
import com.vaadin.flow.component.datepicker.DatePicker;
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

import local.example.bookstore.data.entity.BookEntity;
import local.example.bookstore.data.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@PageTitle("Book")
@Route(value = "book/:bookID?/:action?(edit)", layout = MainView.class)
public class BookView
        extends Div
        implements BeforeEnterObserver {

    private final String BOOK_ID = "bookID";
    private final String BOOK_EDIT_ROUTE = "book/%d/edit";
    private final String TEMPLATE_RENDER_BOOK_IMAGE = "<img style='height: 64px' src='[[item.uriImage]]' />";

    private Grid<BookEntity> bookEntityGrid = new Grid<>(BookEntity.class, false);

    private TextField title;
    private TextField subtitle;
    private TextField isbn;
    private TextField pages;
    private DatePicker publication;
    private Upload uriImageUpload;
    private Image imagePreview;
    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private BeanValidationBinder<BookEntity> bookEntityBeanValidationBinder;

    private BookEntity bookEntity;
    private BookService bookService;

    public BookView(
            @Autowired BookService bookService
    ) {
        this.addClassNames("book-view", "flex", "flex-col", "h-full");
        this.bookService = bookService;

        SplitLayout splitLayout = new SplitLayout();
        splitLayout.setSizeFull();

        this.createGridLayout(splitLayout);
        this.createEditorLayout(splitLayout);
        this.add(splitLayout);

        TemplateRenderer<BookEntity> bookUriImageTemplateRenderer;
        bookUriImageTemplateRenderer = TemplateRenderer.<BookEntity>of(TEMPLATE_RENDER_BOOK_IMAGE)
                .withProperty("uriImage", BookEntity::getUriImage);

        this.bookEntityGrid.addColumn(BookEntity::getTitle).setHeader("Title").setAutoWidth(true);
        this.bookEntityGrid.addColumn(BookEntity::getSubtitle).setHeader("Subtitle").setAutoWidth(true);
        this.bookEntityGrid.addColumn(BookEntity::getIsbn).setHeader("ISBN").setAutoWidth(true);
        this.bookEntityGrid.addColumn(BookEntity::getPages).setHeader("Pages").setAutoWidth(true);
        this.bookEntityGrid.addColumn(BookEntity::getPublication).setHeader("Publication").setAutoWidth(true);
        this.bookEntityGrid.addColumn(bookUriImageTemplateRenderer).setHeader("Image").setAutoWidth(true);

        // TODO CRUD service
        this.bookEntityGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        this.bookEntityGrid.setHeightFull();

        this.bookEntityGrid.asSingleSelect().addValueChangeListener(
                valueChangeEvent -> {

                }
        );

        this.bookEntityBeanValidationBinder = new BeanValidationBinder<>(BookEntity.class);

        this.cancel.addClickListener(cancelClickEvent -> {
            // TODO
        });

        this.save.addClickListener(saveClickEvent -> {
            try {
                if (this.bookEntity == null) {
                    this.bookEntity = new BookEntity();
                }
                this.bookEntityBeanValidationBinder.writeBean(this.bookEntity);
                this.bookService.update(this.bookEntity);
                Notification.show("book fields saved");
                UI.getCurrent().navigate(BookView.class);
            } catch (ValidationException validationException) {
                Notification.show("an exception happened while trying to save the book fields");
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
        this.title = new TextField("Title");
        this.subtitle = new TextField("Subtitle");
        this.isbn = new TextField("ISBN");
        this.pages = new TextField("Pages");
        this.publication = new DatePicker("Publication");
        Label imageLabel = new Label("Image");
        this.imagePreview = new Image();
        this.imagePreview.setWidth("100%");
        this.uriImageUpload = new Upload();
        this.uriImageUpload.getStyle().set("box-sizing", "border-box");
        this.uriImageUpload.getElement().appendChild(this.imagePreview.getElement());
        Component[] componentFields = new Component[]{
                this.title,
                this.subtitle,
                this.isbn,
                this.pages,
                this.publication,
                imageLabel, this.uriImageUpload
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
        gridWrapperDiv.add(this.bookEntityGrid);
    }

    private void refreshGrid() {
        this.bookEntityGrid.select(null);
        this.bookEntityGrid.getDataProvider().refreshAll();
    }

    private void clearForm() {
        this.populateForm(null);
    }

    private void populateForm(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
        this.bookEntityBeanValidationBinder.readBean(this.bookEntity);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        Optional<Long> bookId = beforeEnterEvent.getRouteParameters().getLong(BOOK_ID);
        if (bookId.isPresent()) {
            Optional<BookEntity> bookFromBackend = this.bookService.read(bookId.get());
            if (bookFromBackend.isPresent()) {
                this.populateForm(bookFromBackend.get());
            } else {
                Notification.show(
                        String.format("Sorry, book defined by ID: %d could not be found!", bookId.get()),
                        2500,
                        Notification.Position.BOTTOM_START
                );
                this.refreshGrid();
                beforeEnterEvent.forwardTo(BookView.class);
            }
        }
    }
}
