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
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.capstone.data.entity.CustomerEntity;
import local.example.capstone.data.service.CustomerService;
import local.example.capstone.view.MainView;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Route(value = "customer-detail/:customerID?/:action?(edit)", layout = MainView.class)
@PageTitle("Customer Detail")
@Tag("customer-detail-view")
@JsModule("./views/details/customer-detail-view.ts")
public class CustomerDetailView
        extends LitTemplate
        implements HasStyle, BeforeEnterObserver {

    private final String CUSTOMER_ID = "customerID";
    private final String CUSTOMER_EDIT_ROUTE_TEMPLATE = "customer-detail/%d/edit";

    private CustomerEntity customerEntity;

    private final CustomerService customerService;

    private final BeanValidationBinder<CustomerEntity> customerEntityBeanValidationBinder;

    @Id("grid")
    private Grid<CustomerEntity> customerEntityGrid;

    @Id("customerName")
    private TextField name;

    @Id("sticker")
    private TextField sticker;

    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    public CustomerDetailView(@Autowired CustomerService customerService) {
        this.addClassNames("customer-detail-view", "flex", "flex-col", "h-full");

        this.customerService = customerService;

        this.customerEntityGrid.addColumn(CustomerEntity::getName).setHeader("Name").setAutoWidth(true);
        this.customerEntityGrid.addColumn(CustomerEntity::getSticker).setHeader("Sticker").setAutoWidth(true);

        this.customerEntityGrid.setItems(this.customerService.readAll());

        this.customerEntityGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        this.customerEntityGrid.setHeightFull();

        this.customerEntityGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        this.customerEntityGrid.asSingleSelect().addValueChangeListener(valueChangeEvent -> {
            if (valueChangeEvent.getValue() != null) {
                UI.getCurrent().navigate(String.format(
                        CUSTOMER_EDIT_ROUTE_TEMPLATE,
                        valueChangeEvent.getValue().getId()
                ));
            } else {
                this.clearForm();
                UI.getCurrent().navigate(CustomerDetailView.class);
            }
        });

        this.customerEntityBeanValidationBinder = new BeanValidationBinder<>(CustomerEntity.class);
        this.customerEntityBeanValidationBinder.bindInstanceFields(this);

        this.cancel.addClickListener(cancelButtonClickEvent -> {
            this.clearForm();
            this.refreshGrid();
        });

        this.save.addClickListener(saveButtonClickEvent -> {
            try {
                if (this.customerEntity == null) {
                    this.customerEntity = new CustomerEntity();
                }
                this.customerEntityBeanValidationBinder.writeBean(this.customerEntity);
                this.customerService.update(this.customerEntity);
                this.clearForm();
                this.refreshGrid();
                Notification.show(
                        "customer details stored",
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                UI.getCurrent().navigate(CustomerDetailView.class);
            } catch (ValidationException validationException) {
                Notification.show(
                        "an exception happened while trying to store the customer details",
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
            }
        });
    }

    private void refreshGrid() {
        this.customerEntityGrid.select(null);
        this.customerEntityGrid.getLazyDataView().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
        this.customerEntityBeanValidationBinder.readBean(this.customerEntity);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        Optional<Long> customerId = beforeEnterEvent.getRouteParameters().getLong(CUSTOMER_ID);
        if (customerId.isPresent()) {
            Optional<CustomerEntity> optionalCustomerEntity = customerService.read(customerId.get());
            if (optionalCustomerEntity.isPresent()) {
                this.populateForm(optionalCustomerEntity.get());
            } else {
                Notification.show(
                        String.format("The requested customer was not found, ID = %d", customerId.get()),
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                this.refreshGrid();
                beforeEnterEvent.forwardTo(CustomerDetailView.class);
            }
        }
    }
}
