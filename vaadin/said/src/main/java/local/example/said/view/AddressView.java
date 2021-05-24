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

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import local.example.said.data.model.Address;
import local.example.said.data.repository.AddressRepository;
import local.example.said.view.layout.MainLayout;

@PageTitle("Address")
@Theme(variant = Lumo.DARK)
@CssImport(value = "styles.css")
@Route(value = "address", layout = MainLayout.class)
public class AddressView
        extends Div {

    private TextField street = new TextField("Street address");
    private TextField postalCode = new TextField("Postal code");
    private TextField city = new TextField("City");
    private ComboBox<String> state = new ComboBox<>("State");
    private ComboBox<String> country = new ComboBox<>("Country");
    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private Binder<Address> binder = new Binder<>(Address.class);

    public AddressView(AddressRepository addressRepository) {
        this.addClassName("address-form-view");
        // TODO
    }

    private Component createTitle() {
        return new H1("Address");
    }

    private Component createFormLayout() {
        // TODO
        return null;
    }

    private Component createButtonLayout() {
        // TODO
        return null;
    }

    private void clearForm() {
        // TODO
    }
}
