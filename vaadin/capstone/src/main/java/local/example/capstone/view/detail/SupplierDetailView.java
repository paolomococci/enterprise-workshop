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

import local.example.capstone.data.entity.SupplierEntity;
import local.example.capstone.data.service.SupplierService;
import local.example.capstone.view.MainView;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Route(value = "supplier-detail/:supplierID?/:action?(edit)", layout = MainView.class)
@PageTitle("Supplier Detail")
@Tag("supplier-detail-view")
@JsModule("./views/details/supplier-detail-view.ts")
public class SupplierDetailView
        extends LitTemplate
        implements HasStyle, BeforeEnterObserver {

    private final String SUPPLIER_ID = "supplierID";
    private final String SUPPLIER_EDIT_ROUTE_TEMPLATE = "supplier-detail/%d/edit";

    private SupplierEntity supplierEntity;

    private final SupplierService supplierService;

    private final BeanValidationBinder<SupplierEntity> supplierEntityBeanValidationBinder;

    @Id("grid")
    private Grid<SupplierEntity> supplierEntityGrid;

    @Id("supplierName")
    private TextField name;

    @Id("sticker")
    private TextField sticker;

    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    public SupplierDetailView(@Autowired SupplierService supplierService) {
        this.addClassNames("supplier-detail-view", "flex", "flex-col", "h-full");

        this.supplierService = supplierService;

        this.supplierEntityGrid.addColumn(SupplierEntity::getName).setHeader("Name").setAutoWidth(true);
        this.supplierEntityGrid.addColumn(SupplierEntity::getSticker).setHeader("Sticker").setAutoWidth(true);

        this.supplierEntityGrid.setItems(this.supplierService.readAll());

        this.supplierEntityGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        this.supplierEntityGrid.setHeightFull();

        this.supplierEntityGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        this.supplierEntityGrid.asSingleSelect().addValueChangeListener(valueChangeEvent -> {
            if (valueChangeEvent.getValue() != null) {
                UI.getCurrent().navigate(String.format(
                        SUPPLIER_EDIT_ROUTE_TEMPLATE,
                        valueChangeEvent.getValue().getId()
                ));
            } else {
                this.clearForm();
                UI.getCurrent().navigate(SupplierDetailView.class);
            }
        });

        this.supplierEntityBeanValidationBinder = new BeanValidationBinder<>(SupplierEntity.class);
        this.supplierEntityBeanValidationBinder.bindInstanceFields(this);

        this.cancel.addClickListener(cancelButtonClickEvent -> {
            this.clearForm();
            this.refreshGrid();
        });

        this.save.addClickListener(saveButtonClickEvent -> {
            try {
                if (this.supplierEntity == null) {
                    this.supplierEntity = new SupplierEntity();
                }
                this.supplierEntityBeanValidationBinder.writeBean(this.supplierEntity);
                this.supplierService.update(this.supplierEntity);
                this.clearForm();
                this.refreshGrid();
                Notification.show(
                        "supplier details stored",
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                UI.getCurrent().navigate(SupplierDetailView.class);
            } catch (ValidationException validationException) {
                Notification.show(
                        "an exception happened while trying to store the supplier details",
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
            }
        });
    }

    private void refreshGrid() {
        this.supplierEntityGrid.select(null);
        this.supplierEntityGrid.getLazyDataView().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(SupplierEntity supplierEntity) {
        this.supplierEntity = supplierEntity;
        this.supplierEntityBeanValidationBinder.readBean(this.supplierEntity);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        Optional<Long> supplierID = beforeEnterEvent.getRouteParameters().getLong(SUPPLIER_ID);
        if (supplierID.isPresent()) {
            Optional<SupplierEntity> optionalSupplierEntity = supplierService.read(SUPPLIER_ID);
            if (optionalSupplierEntity.isPresent()) {
                this.populateForm(optionalSupplierEntity.get());
            } else {
                Notification.show(
                        String.format("The requested supplier was not found, ID = %d", supplierID.get()),
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                this.refreshGrid();
                beforeEnterEvent.forwardTo(SupplierDetailView.class);
            }
        }
    }
}
