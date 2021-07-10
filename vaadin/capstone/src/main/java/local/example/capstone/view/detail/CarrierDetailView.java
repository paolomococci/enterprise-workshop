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
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.capstone.data.entity.CarrierEntity;
import local.example.capstone.data.service.CarrierService;
import local.example.capstone.view.MainView;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Route(value = "carrier-detail/:carrierID?/:action?(edit)", layout = MainView.class)
@PageTitle("Carrier Detail")
@Tag("carrier-detail-view")
@JsModule("./views/details/carrier-detail-view.ts")
public class CarrierDetailView
        extends LitTemplate
        implements HasStyle, BeforeEnterObserver {

    private final String CARRIER_EDIT_ROUTE_TEMPLATE = "carrier-detail/%d/edit";

    @Autowired
    CarrierEntity carrierEntity;

    private final CarrierService carrierService;

    private final BeanValidationBinder<CarrierEntity> carrierEntityBeanValidationBinder;

    @Id("grid")
    private Grid<CarrierEntity> carrierEntityGrid;

    @Id("carrierName")
    private TextField name;

    @Id("sticker")
    private TextField sticker;

    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    public CarrierDetailView(@Autowired CarrierService carrierService) {
        this.addClassNames("carrier-detail-view", "flex", "flex-col", "h-full");

        this.carrierService = carrierService;

        this.carrierEntityGrid.addColumn((String) null).setHeader((String) null).setAutoWidth(true);
        this.carrierEntityGrid.addColumn((String) null).setHeader((String) null).setAutoWidth(true);

        this.carrierEntityGrid.setItems(this.carrierService.readAll());

        this.carrierEntityGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        this.carrierEntityGrid.setHeightFull();

        this.carrierEntityGrid.asSingleSelect().addValueChangeListener(valueChangeEvent -> {
            if (valueChangeEvent.getValue() != null) {
                UI.getCurrent().navigate(String.format(
                        CARRIER_EDIT_ROUTE_TEMPLATE,
                        valueChangeEvent.getValue().getId()
                ));
            } else {
                this.clearForm();
                UI.getCurrent().navigate(CarrierDetailView.class);
            }
        });

        this.carrierEntityBeanValidationBinder = new BeanValidationBinder<>(CarrierEntity.class);
        this.carrierEntityBeanValidationBinder.bindInstanceFields(this);

        this.cancel.addClickListener(cancelButtonClickEvent -> {
            this.clearForm();
            this.refreshGrid();
        });

        this.save.addClickListener(saveButtonClickEvent -> {
            // TODO
        });
    }

    private void refreshGrid() {
        this.carrierEntityGrid.select(null);
        this.carrierEntityGrid.getLazyDataView().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(CarrierEntity carrierEntity) {
        this.carrierEntity = carrierEntity;
        this.carrierEntityBeanValidationBinder.readBean(this.carrierEntity);

    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        String CARRIER_ID = "carrierID";
        Optional<Long> carrierID = beforeEnterEvent.getRouteParameters().getLong(CARRIER_ID);
        if (carrierID.isPresent()) {
            Optional<CarrierEntity> optionalCarrierEntity = carrierService.read(CARRIER_ID);
            if (optionalCarrierEntity.isPresent()) {
                this.populateForm(optionalCarrierEntity.get());
            } else {
                Notification.show(
                        String.format("The requested carrier was not found, ID = %d", carrierID.get()),
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                this.refreshGrid();
                beforeEnterEvent.forwardTo(CarrierDetailView.class);
            }
        }
    }
}
