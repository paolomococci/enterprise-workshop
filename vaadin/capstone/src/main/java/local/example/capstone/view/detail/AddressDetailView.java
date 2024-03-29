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
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;

import local.example.capstone.data.entity.AddressEntity;
import local.example.capstone.data.service.AddressService;
import local.example.capstone.view.MainView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

@Route(value = "address-detail/:addressID?/:action?(edit)", layout = MainView.class)
@PageTitle("Address Detail")
@Tag("address-detail-view")
@JsModule("./views/details/address-detail-view.ts")
public class AddressDetailView
        extends LitTemplate
        implements BeforeEnterObserver {

    private final String ADDRESS_ID = "addressID";
    private final String ADDRESS_EDIT_ROUTE_TEMPLATE = "address-detail/%d/edit";

    private AddressEntity addressEntity;

    private final AddressService addressService;

    private BeanValidationBinder<AddressEntity> addressEntityBeanValidationBinder;

    @Id("grid")
    private Grid<AddressEntity> addressEntityGrid;

    @Id("streetAddress")
    private TextField street;

    @Id("postalCode")
    private TextField postalCode;

    @Id("city")
    private TextField city;

    @Id("state")
    private TextField state;

    @Id("country")
    private TextField country;

    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    public AddressDetailView(@Autowired AddressService addressService) {
        this.addClassNames("address-detail-view", "flex", "flex-col", "h-full");

        this.addressService = addressService;

        this.addressEntityGrid.addColumn(AddressEntity::getStreet).setHeader("Street").setAutoWidth(true);
        this.addressEntityGrid.addColumn(AddressEntity::getPostalCode).setHeader("Postal Code").setAutoWidth(true);
        this.addressEntityGrid.addColumn(AddressEntity::getCity).setHeader("City").setAutoWidth(true);
        this.addressEntityGrid.addColumn(AddressEntity::getState).setHeader("State").setAutoWidth(true);
        this.addressEntityGrid.addColumn(AddressEntity::getCountry).setHeader("Country").setAutoWidth(true);

        this.addressEntityGrid.setItems(
                addressEntityVoidQuery -> this.addressService.readAll(
                        PageRequest.of(
                                addressEntityVoidQuery.getPage(),
                                addressEntityVoidQuery.getPageSize(),
                                VaadinSpringDataHelpers.toSpringDataSort(addressEntityVoidQuery)
                        )
                ).stream()
        );

        this.addressEntityGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        this.addressEntityGrid.setHeightFull();

        this.addressEntityGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        this.addressEntityGrid.asSingleSelect().addValueChangeListener(valueChangeEvent -> {
            if (valueChangeEvent.getValue() != null) {
                UI.getCurrent().navigate(String.format(
                        ADDRESS_EDIT_ROUTE_TEMPLATE,
                        valueChangeEvent.getValue().getId()
                ));
            } else {
                this.clearForm();
                UI.getCurrent().navigate(AddressDetailView.class);
            }
        });

        this.addressEntityBeanValidationBinder = new BeanValidationBinder<>(AddressEntity.class);
        this.addressEntityBeanValidationBinder.bindInstanceFields(this);


        this.cancel.addClickListener(cancelButtonClickEvent -> {
            this.clearForm();
            this.refreshGrid();
        });

        this.save.addClickListener(saveButtonClickEvent -> {
            try {
                if (this.addressEntity == null) {
                    this.addressEntity = new AddressEntity();
                }
                this.addressEntityBeanValidationBinder.writeBean(this.addressEntity);
                this.addressService.update(this.addressEntity);
                this.clearForm();
                this.refreshGrid();
                Notification.show(
                        "address details stored",
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                UI.getCurrent().navigate(AddressDetailView.class);
            } catch (ValidationException validationException) {
                Notification.show(
                        "an exception happened while trying to store the address details",
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
            }
        });
    }

    private void refreshGrid() {
        this.addressEntityGrid.select(null);
        this.addressEntityGrid.getLazyDataView().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
        this.addressEntityBeanValidationBinder.readBean(this.addressEntity);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        Optional<Long> addressId = beforeEnterEvent.getRouteParameters().getLong(ADDRESS_ID);
        if (addressId.isPresent()) {
            Optional<AddressEntity> optionalAddressEntity = addressService.read(addressId.get());
            if (optionalAddressEntity.isPresent()) {
                this.populateForm(optionalAddressEntity.get());
            } else {
                Notification.show(
                        String.format("The requested address was not found, ID = %d", addressId.get()),
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                this.refreshGrid();
                beforeEnterEvent.forwardTo(AddressDetailView.class);
            }
        }
    }
}
