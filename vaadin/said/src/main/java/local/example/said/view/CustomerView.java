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
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import local.example.said.data.model.Customer;
import local.example.said.data.repository.CustomerRepository;
import local.example.said.view.component.PhoneNumberComponent;
import local.example.said.view.layout.MainLayout;

@PageTitle("Customer")
@Theme(variant = Lumo.DARK)
@CssImport(value = "styles.css")
@Route(value = "customer", layout = MainLayout.class)
public class CustomerView
        extends Div {

    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private EmailField email = new EmailField("Email address");
    private DatePicker dateOfBirth = new DatePicker("Birthday");
    private PhoneNumberComponent phone = new PhoneNumberComponent("Phone number");
    private TextField occupation = new TextField("Occupation");

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private Binder<Customer> binder = new Binder(Customer.class);

    public CustomerView(CustomerRepository customerRepository) {
        this.addClassName("customer-form-view");
        // TODO
    }

    private void clearForm() {
        // TODO
    }

    private Component createTitle() {
        //TODO
        return null;
    }

    private Component createFormLayout() {
        // TODO
        return null;
    }

    private Component createButtonLayout() {
        // TODO
        return null;
    }
}
