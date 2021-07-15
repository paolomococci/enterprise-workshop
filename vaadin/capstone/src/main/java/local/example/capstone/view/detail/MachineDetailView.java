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
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.capstone.data.entity.MachineEntity;
import local.example.capstone.data.service.MachineService;
import local.example.capstone.view.MainView;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Route(value = "machine-detail/:machineID?/:action?(edit)", layout = MainView.class)
@PageTitle("Machine Detail")
@Tag("machine-detail-view")
@JsModule("./views/details/machine-detail-view.ts")
public class MachineDetailView
        extends LitTemplate
        implements HasStyle, BeforeEnterObserver {

    private final String MACHINE_ID = "machineID";
    private final String MACHINE_EDIT_ROUTE_TEMPLATE = "machine-detail/%d/edit";

    private MachineEntity machineEntity;

    private final MachineService machineService;

    private final BeanValidationBinder<MachineEntity> machineEntityBeanValidationBinder;

    @Id("grid")
    private Grid<MachineEntity> machineEntityGrid;

    @Id("machineLabel")
    private TextField label;

    @Id("capacity")
    private IntegerField capacity;

    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    public MachineDetailView(@Autowired MachineService machineService) {
        this.addClassNames("machine-detail-view", "flex", "flex-col", "h-full");

        this.machineService = machineService;

        this.machineEntityGrid.addColumn(MachineEntity::getLabel).setHeader("Label").setAutoWidth(true);
        this.machineEntityGrid.addColumn(MachineEntity::getCapacity).setHeader("Capacity").setAutoWidth(true);

        this.machineEntityGrid.setItems(this.machineService.readAll());

        this.machineEntityGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        this.machineEntityGrid.setHeightFull();

        this.machineEntityGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        this.machineEntityGrid.asSingleSelect().addValueChangeListener(valueChangeEvent -> {
            if (valueChangeEvent.getValue() != null) {
                UI.getCurrent().navigate(String.format(
                        MACHINE_EDIT_ROUTE_TEMPLATE,
                        valueChangeEvent.getValue().getId()
                ));
            } else {
                this.clearForm();
                UI.getCurrent().navigate(MachineDetailView.class);
            }
        });

        this.machineEntityBeanValidationBinder = new BeanValidationBinder<>(MachineEntity.class);
        this.machineEntityBeanValidationBinder.bindInstanceFields(this);

        this.cancel.addClickListener(cancelButtonClickEvent -> {
            this.clearForm();
            this.refreshGrid();
        });

        this.save.addClickListener(saveButtonClickEvent -> {
            try {
                if (this.machineEntity == null) {
                    this.machineEntity = new MachineEntity();
                }
                this.machineEntityBeanValidationBinder.writeBean(this.machineEntity);
                this.machineService.update(this.machineEntity);
                this.clearForm();
                this.refreshGrid();
                Notification.show(
                        "machine details stored",
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                UI.getCurrent().navigate(MachineDetailView.class);
            } catch (ValidationException validationException) {
                Notification.show(
                        "an exception happened while trying to store the machine details",
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
            }
        });
    }

    private void refreshGrid() {
        this.machineEntityGrid.select(null);
        this.machineEntityGrid.getLazyDataView().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(MachineEntity machineEntity) {
        this.machineEntity = machineEntity;
        this.machineEntityBeanValidationBinder.readBean(this.machineEntity);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        Optional<Long> machineID = beforeEnterEvent.getRouteParameters().getLong(MACHINE_ID);
        if (machineID.isPresent()) {
            Optional<MachineEntity> optionalMachineEntity = machineService.read(MACHINE_ID);
            if (optionalMachineEntity.isPresent()) {
                this.populateForm(optionalMachineEntity.get());
            } else {
                Notification.show(
                        String.format("The requested machine was not found, ID = %d", machineID.get()),
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                this.refreshGrid();
                beforeEnterEvent.forwardTo(MachineDetailView.class);
            }
        }
    }
}
