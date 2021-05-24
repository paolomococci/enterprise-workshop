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

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import local.example.said.data.model.Customer;
import local.example.said.data.repository.CustomerRepository;
import local.example.said.view.layout.MainLayout;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Customer-Detail")
@Theme(variant = Lumo.DARK)
@CssImport(value = "styles.css")
@Route(value = "customer-detail/:customerID?/:action?(edit)", layout = MainLayout.class)
public class CustomerDetailView
        extends Div
        implements BeforeEnterObserver {

    private final String CUSTOMER_ID = "customerID";
    private final String CUSTOMER_EDIT_ROUTE_TEMPLATE = "customer-detail/%d/edit";

    private Grid<Customer> grid = new Grid<>(Customer.class, false);

    private TextField firstName;
    private TextField lastName;
    private TextField email;
    private TextField phone;
    private DatePicker dateOfBirth;
    private TextField occupation;
    private Checkbox important;

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private BeanValidationBinder<Customer> binder;

    private Customer customer;
    private CustomerRepository customerRepository;

    public CustomerDetailView(
            @Autowired
            CustomerRepository customerRepository
    ) {
        this.addClassNames("master-detail-view", "flex", "flex-col", "h-full");
        this.customerRepository = customerRepository;
        // TODO
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {

    }
}
