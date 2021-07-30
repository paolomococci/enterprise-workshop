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

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.bookstore.data.entity.BookEntity;
import local.example.bookstore.data.service.BookService;

import java.util.Optional;

@PageTitle("Book")
@Route(value = "book/:bookID?/:action?(edit)", layout = MainView.class)
public class BookView
        extends Div
        implements BeforeEnterObserver {

    private final String BOOK_ID = "bookID";
    private final String BOOK_EDIT_ROUTE = "book/%d/edit";

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

    public BookView() {
        // TODO
    }

    private void createEditorLayout(SplitLayout splitLayout) {
        // TODO
    }

    private void createButtonLayout(Div editorLayoutDiv) {
        // TODO
    }

    private void createGridLayout(SplitLayout splitLayout) {
        // TODO
    }

    private void refreshGrid() {
        // TODO
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
        // TODO
    }
}
