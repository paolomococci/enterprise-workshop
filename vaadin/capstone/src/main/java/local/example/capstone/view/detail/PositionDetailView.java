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
import com.vaadin.flow.router.Route;

import local.example.capstone.data.entity.PositionEntity;
import local.example.capstone.data.service.PositionService;
import local.example.capstone.view.MainView;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Route(value = "position-detail/:positionID?/:action?(edit)", layout = MainView.class)
@PageTitle("Position Detail")
@Tag("position-detail-view")
@JsModule("./views/details/position-detail-view.ts")
public class PositionDetailView
        extends LitTemplate
        implements HasStyle, BeforeEnterObserver {

    private final String POSITION_EDIT_ROUTE_TEMPLATE = "position-detail/%d/edit";

    @Autowired
    PositionEntity positionEntity;

    private final PositionService positionService;

    private final BeanValidationBinder<PositionEntity> positionEntityBeanValidationBinder;

    @Id("grid")
    private Grid<PositionEntity> positionEntityGrid;

    @Id("positionLabel")
    private TextField label;

    @Id("capacity")
    private IntegerField capacity;

    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    public PositionDetailView(@Autowired PositionService positionService) {
        this.addClassNames("position-detail-view", "flex", "flex-col", "h-full");

        this.positionService = positionService;

        this.positionEntityGrid.addColumn((String) null).setHeader((String) null).setAutoWidth(true);
        this.positionEntityGrid.addColumn((String) null).setHeader((String) null).setAutoWidth(true);

        this.positionEntityGrid.setItems(this.positionService.readAll());

        this.positionEntityGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        this.positionEntityGrid.setHeightFull();

        this.positionEntityGrid.asSingleSelect().addValueChangeListener(valueChangeEvent -> {
            if (valueChangeEvent.getValue() != null) {
                UI.getCurrent().navigate(String.format(
                        POSITION_EDIT_ROUTE_TEMPLATE,
                        valueChangeEvent.getValue().getId()
                ));
            } else {
                this.clearForm();
                UI.getCurrent().navigate(ContactDetailView.class);
            }
        });

        this.positionEntityBeanValidationBinder = new BeanValidationBinder<>(PositionEntity.class);
        this.positionEntityBeanValidationBinder.bindInstanceFields(this);

        this.cancel.addClickListener(cancelButtonClickEvent -> {
            this.clearForm();
            this.refreshGrid();
        });

        this.save.addClickListener(saveButtonClickEvent -> {
            // TODO
        });
    }

    private void refreshGrid() {
        this.positionEntityGrid.select(null);
        this.positionEntityGrid.getLazyDataView().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(PositionEntity positionEntity) {
        this.positionEntity = positionEntity;
        this.positionEntityBeanValidationBinder.readBean(this.positionEntity);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        String POSITION_ID = "positionID";
        Optional<Long> positionID = beforeEnterEvent.getRouteParameters().getLong(POSITION_ID);
        if (positionID.isPresent()) {
            Optional<PositionEntity> optionalPositionEntity = positionService.read(POSITION_ID);
            if (optionalPositionEntity.isPresent()) {
                this.populateForm(optionalPositionEntity.get());
            } else {
                Notification.show(
                        String.format("The requested position was not found, ID = %d", positionID.get()),
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                this.refreshGrid();
                beforeEnterEvent.forwardTo(PositionDetailView.class);
            }
        }
    }
}
