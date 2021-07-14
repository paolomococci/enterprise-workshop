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
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;

import local.example.capstone.data.entity.CapacityEntity;
import local.example.capstone.data.service.CapacityService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@PageTitle("Capacity Detail")
@Tag("capacity-detail-view")
@JsModule("./views/details/capacity-detail-view.ts")
public class CapacityDetailView
        extends LitTemplate
        implements HasStyle, BeforeEnterObserver {

    private final String CAPACITY_EDIT_ROUTE_TEMPLATE = "capacity-detail/%d/edit";

    private CapacityEntity capacityEntity;

    private final CapacityService capacityService;

    private final BeanValidationBinder<CapacityEntity> capacityEntityBeanValidationBinder;

    @Id("grid")
    private Grid<CapacityEntity> capacityEntityGrid;

    @Id("capacityCode")
    private TextField code;

    @Id("usefulWeight")
    private IntegerField usefulWeight;

    @Id("usefulVolume")
    private IntegerField usefulVolume;

    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    public CapacityDetailView(@Autowired CapacityService capacityService) {
        this.addClassNames("capacity-detail-view", "flex", "flex-col", "h-full");

        this.capacityService = capacityService;

        this.capacityEntityGrid.addColumn(CapacityEntity::getCode).setHeader("Code").setAutoWidth(true);
        this.capacityEntityGrid.addColumn(CapacityEntity::getUsefulWeight).setHeader("Useful Weight").setAutoWidth(true);
        this.capacityEntityGrid.addColumn(CapacityEntity::getUsefulVolume).setHeader("Useful Volume").setAutoWidth(true);

        this.capacityEntityGrid.setItems(this.capacityService.readAll());

        this.capacityEntityGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        this.capacityEntityGrid.setHeightFull();

        this.capacityEntityGrid.asSingleSelect().addValueChangeListener(valueChangeEvent -> {
            if (valueChangeEvent.getValue() != null) {
                UI.getCurrent().navigate(String.format(
                        CAPACITY_EDIT_ROUTE_TEMPLATE,
                        valueChangeEvent.getValue().getId()
                ));
            } else {
                this.clearForm();
                UI.getCurrent().navigate(CapacityDetailView.class);
            }
        });

        this.capacityEntityBeanValidationBinder = new BeanValidationBinder<>(CapacityEntity.class);
        this.capacityEntityBeanValidationBinder.bindInstanceFields(this);

        this.cancel.addClickListener(cancelButtonClickEvent -> {
            this.clearForm();
            this.refreshGrid();
        });

        this.save.addClickListener(saveButtonClickEvent -> {

        });
    }

    private void refreshGrid() {
        this.capacityEntityGrid.select(null);
        this.capacityEntityGrid.getLazyDataView().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(CapacityEntity capacityEntity) {
        this.capacityEntity = capacityEntity;
        this.capacityEntityBeanValidationBinder.readBean(this.capacityEntity);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        String CAPACITY_ID = "capacityID";
        Optional<Long> capacityID = beforeEnterEvent.getRouteParameters().getLong(CAPACITY_ID);
        if (capacityID.isPresent()) {
            Optional<CapacityEntity> optionalCapacityEntity = capacityService.read(CAPACITY_ID);
            if (optionalCapacityEntity.isPresent()) {
                this.populateForm(optionalCapacityEntity.get());
            } else {
                Notification.show(
                        String.format("The requested capacity was not found, ID = %d", capacityID.get()),
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                this.refreshGrid();
                beforeEnterEvent.forwardTo(CapacityDetailView.class);
            }
        }
    }
}
