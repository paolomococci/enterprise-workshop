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

package local.example.said.view;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import local.example.said.data.model.Customer;
import local.example.said.view.layout.MainLayout;

@PageTitle("Card List")
@Theme(variant = Lumo.DARK)
@CssImport(value = "styles.css")
@Route(value = "card-list", layout = MainLayout.class)
public class CardListView
        extends Div
        implements AfterNavigationObserver {

    Grid<Customer> grid = new Grid<>();

    public CardListView() {
        this.addClassName("card-list-view");
        setSizeFull();
        // TODO
    }

    private HorizontalLayout createCard(Customer customer) {
        // TODO
        return null;
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        // TODO
    }
}
