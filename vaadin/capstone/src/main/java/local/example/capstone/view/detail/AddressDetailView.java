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

package local.example.capstone.view.detail;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.capstone.data.entity.AddressEntity;
import local.example.capstone.data.service.AddressService;
import local.example.capstone.view.MainView;

import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "address-detail/:contactID?/:action?(edit)", layout = MainView.class)
@PageTitle("Address Detail")
@Tag("address-detail-view")
@JsModule("./views/details/address-detail-view.ts")
public class AddressDetailView
        extends LitTemplate
        implements HasStyle, BeforeEnterObserver {

    private final String ADDRESS_EDIT_ROUTE_TEMPLATE = "address-detail/%d/edit";

    @Id("grid")
    private Grid<AddressEntity> addressEntityGrid;

    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    public AddressDetailView(@Autowired AddressService addressService) {

        this.cancel.addClickListener(e -> {
            // TODO
        });

        this.save.addClickListener(e -> {
            // TODO
        });
    }

    private void refreshGrid() {
        // TODO
    }

    private void clearForm() {
        // TODO
    }

    private void populateForm(AddressEntity addressEntity) {
        // TODO

    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        // TODO
    }
}
