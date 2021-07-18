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
import com.vaadin.flow.component.datepicker.DatePicker;
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
import local.example.capstone.data.entity.LotEntity;
import local.example.capstone.data.service.LotService;
import local.example.capstone.view.MainView;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Route(value = "lot-detail/:lotID?/:action?(edit)", layout = MainView.class)
@PageTitle("Lot Detail")
@Tag("lot-detail-view")
@JsModule("./views/details/lot-detail-view.ts")
public class LotDetailView
        extends LitTemplate
        implements HasStyle, BeforeEnterObserver {

    private final String LOT_ID = "lotID";
    private final String LOT_EDIT_ROUTE_TEMPLATE = "lot-detail/%d/edit";

    private LotEntity lotEntity;

    private final LotService lotService;

    private BeanValidationBinder<LotEntity> lotEntityBeanValidationBinder;

    @Id("grid")
    private Grid<LotEntity> lotEntityGrid;

    @Id("lotCode")
    private TextField code;

    @Id("amount")
    private IntegerField amount;

    @Id("deadline")
    private DatePicker deadline;

    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    public LotDetailView(@Autowired LotService lotService) {
        this.addClassNames("lot-detail-view", "flex", "flex-col", "h-full");

        this.lotService = lotService;

        this.lotEntityGrid.addColumn(LotEntity::getCode).setHeader("Code").setAutoWidth(true);
        this.lotEntityGrid.addColumn(LotEntity::getAmount).setHeader("Amount").setAutoWidth(true);
        this.lotEntityGrid.addColumn(LotEntity::getDeadline).setHeader("Dead Line").setAutoWidth(true);

        this.lotEntityGrid.setItems(this.lotService.readAll());

        this.lotEntityGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        this.lotEntityGrid.setHeightFull();

        this.lotEntityGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        this.lotEntityGrid.asSingleSelect().addValueChangeListener(valueChangeEvent -> {
            if (valueChangeEvent.getValue() != null) {
                UI.getCurrent().navigate(String.format(
                        LOT_EDIT_ROUTE_TEMPLATE,
                        valueChangeEvent.getValue().getId()
                ));
            } else {
                this.clearForm();
                UI.getCurrent().navigate(LotDetailView.class);
            }
        });

        this.lotEntityBeanValidationBinder = new BeanValidationBinder<>(LotEntity.class);
        this.lotEntityBeanValidationBinder.bindInstanceFields(this);

        this.cancel.addClickListener(cancelButtonClickEvent -> {
            this.clearForm();
            this.refreshGrid();
        });

        this.save.addClickListener(saveButtonClickEvent -> {
            try {
                if (this.lotEntity == null) {
                    this.lotEntity = new LotEntity();
                }
                this.lotEntityBeanValidationBinder.writeBean(this.lotEntity);
                this.lotService.update(this.lotEntity);
                this.clearForm();
                this.refreshGrid();
                Notification.show(
                        "lot details stored",
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                UI.getCurrent().navigate(AddressDetailView.class);
            } catch (ValidationException validationException) {
                Notification.show(
                        "an exception happened while trying to store the lot details",
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
            }
        });
    }

    private void refreshGrid() {
        this.lotEntityGrid.select(null);
        this.lotEntityGrid.getLazyDataView().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(LotEntity lotEntity) {
        this.lotEntity = lotEntity;
        this.lotEntityBeanValidationBinder.readBean(this.lotEntity);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        Optional<Long> lotId = beforeEnterEvent.getRouteParameters().getLong(LOT_ID);
        if (lotId.isPresent()) {
            Optional<LotEntity> optionalLotEntity = lotService.read(lotId.get());
            if (optionalLotEntity.isPresent()) {
                this.populateForm(optionalLotEntity.get());
            } else {
                Notification.show(
                        String.format("The requested lot was not found, ID = %d", lotId.get()),
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                this.refreshGrid();
                beforeEnterEvent.forwardTo(CapacityDetailView.class);
            }
        }
    }
}
