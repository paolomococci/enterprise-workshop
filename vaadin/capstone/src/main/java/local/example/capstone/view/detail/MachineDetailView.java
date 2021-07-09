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
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.capstone.data.entity.MachineEntity;
import local.example.capstone.data.service.MachineService;
import local.example.capstone.view.MainView;

import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "machine-detail/:contactID?/:action?(edit)", layout = MainView.class)
@PageTitle("Machine Detail")
@Tag("machine-detail-view")
@JsModule("./views/details/machine-detail-view.ts")
public class MachineDetailView
        extends LitTemplate
        implements HasStyle, BeforeEnterObserver {

    private final String MACHINE_EDIT_ROUTE_TEMPLATE = "machine-detail/%d/edit";

    @Autowired
    MachineEntity machineEntity;

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

        this.machineEntityGrid.addColumn((String) null).setHeader((String) null).setAutoWidth(true);
        this.machineEntityGrid.addColumn((String) null).setHeader((String) null).setAutoWidth(true);

        this.machineEntityBeanValidationBinder = new BeanValidationBinder<>(MachineEntity.class);

        this.cancel.addClickListener(cancelButtonClickEvent -> {
            // TODO
        });

        this.save.addClickListener(saveButtonClickEvent -> {
            // TODO
        });
    }

    private void refreshGrid() {
        // TODO
    }

    private void clearForm() {
        // TODO
    }

    private void populateForm(MachineEntity machineEntity) {
        // TODO

    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        // TODO
    }
}
