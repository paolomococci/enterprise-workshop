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

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.*;

import local.example.bookstore.data.entity.AuthorEntity;

@PageTitle("Author")
@Route(value = "author/:authorID?/:action?(edit)", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
public class AuthorView
        extends Div
        implements BeforeEnterObserver {

    private final String AUTHOR_ID = "authorID";
    private final String AUTHOR_EDIT_ROUTE = "author/%d/edit";

    private Grid<AuthorEntity> authorEntityGrid = new Grid<>(AuthorEntity.class, false);

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {

    }
}
