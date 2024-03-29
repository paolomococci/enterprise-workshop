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
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;

import local.example.capstone.data.entity.OperatorEntity;
import local.example.capstone.data.service.OperatorService;
import local.example.capstone.view.MainView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

@Route(value = "operator-detail/:operatorID?/:action?(edit)", layout = MainView.class)
@PageTitle("Operator Detail")
@Tag("operator-detail-view")
@JsModule("./views/details/operator-detail-view.ts")
public class OperatorDetailView
        extends LitTemplate
        implements BeforeEnterObserver {

    private final String OPERATOR_ID = "operatorID";
    private final String OPERATOR_EDIT_ROUTE_TEMPLATE = "operator-detail/%d/edit";

    private OperatorEntity operatorEntity;

    private final OperatorService operatorService;

    private final BeanValidationBinder<OperatorEntity> operatorEntityBeanValidationBinder;

    @Id("grid")
    private Grid<OperatorEntity> operatorEntityGrid;

    @Id("name")
    private TextField name;

    @Id("surname")
    private TextField surname;

    @Id("dateOfBirth")
    private DatePicker dateOfBirth;

    @Id("phoneNumber")
    private TextField phoneNumber;

    @Id("contributoryIdentifier")
    private TextField contributoryIdentifier;

    @Id("email")
    private EmailField email;

    @Id("role")
    private TextField role;

    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    public OperatorDetailView(@Autowired OperatorService operatorService) {
        this.addClassNames("operator-detail-view", "flex", "flex-col", "h-full");

        this.operatorService = operatorService;

        this.operatorEntityGrid.addColumn(OperatorEntity::getName).setHeader("Name").setAutoWidth(true);
        this.operatorEntityGrid.addColumn(OperatorEntity::getSurname).setHeader("Surname").setAutoWidth(true);
        this.operatorEntityGrid.addColumn(OperatorEntity::getDateOfBirth).setHeader("Birthday").setAutoWidth(true);
        this.operatorEntityGrid.addColumn(OperatorEntity::getPhoneNumber).setHeader("Phone Number").setAutoWidth(true);
        this.operatorEntityGrid.addColumn(OperatorEntity::getContributoryIdentifier).setHeader("Contributory Identifier").setAutoWidth(true);
        this.operatorEntityGrid.addColumn(OperatorEntity::getEmail).setHeader("Email").setAutoWidth(true);
        this.operatorEntityGrid.addColumn(OperatorEntity::getRole).setHeader("Role").setAutoWidth(true);

        this.operatorEntityGrid.setItems(
                operatorEntityVoidQuery -> this.operatorService.readAll(
                        PageRequest.of(
                                operatorEntityVoidQuery.getPage(),
                                operatorEntityVoidQuery.getPageSize(),
                                VaadinSpringDataHelpers.toSpringDataSort(operatorEntityVoidQuery)
                        )
                ).stream()
        );

        this.operatorEntityGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        this.operatorEntityGrid.setHeightFull();

        this.operatorEntityGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        this.operatorEntityGrid.asSingleSelect().addValueChangeListener(valueChangeEvent -> {
            if (valueChangeEvent.getValue() != null) {
                UI.getCurrent().navigate(String.format(
                        OPERATOR_EDIT_ROUTE_TEMPLATE,
                        valueChangeEvent.getValue().getId()
                ));
            } else {
                this.clearForm();
                UI.getCurrent().navigate(OperatorDetailView.class);
            }
        });

        this.operatorEntityBeanValidationBinder = new BeanValidationBinder<>(OperatorEntity.class);
        this.operatorEntityBeanValidationBinder.bindInstanceFields(this);

        this.cancel.addClickListener(cancelButtonClickEvent -> {
            this.clearForm();
            this.refreshGrid();
        });

        this.save.addClickListener(saveButtonClickEvent -> {
            try {
                if (this.operatorEntity == null) {
                    this.operatorEntity = new OperatorEntity();
                }
                this.operatorEntityBeanValidationBinder.writeBean(this.operatorEntity);
                this.operatorService.update(this.operatorEntity);
                this.clearForm();
                this.refreshGrid();
                Notification.show(
                        "operator details stored",
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                UI.getCurrent().navigate(OperatorDetailView.class);
            } catch (ValidationException validationException) {
                Notification.show(
                        "an exception happened while trying to store the operator details",
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
            }
        });
    }

    private void refreshGrid() {
        this.operatorEntityGrid.select(null);
        this.operatorEntityGrid.getLazyDataView().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(OperatorEntity operatorEntity) {
        this.operatorEntity = operatorEntity;
        this.operatorEntityBeanValidationBinder.readBean(this.operatorEntity);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        Optional<Long> operatorId = beforeEnterEvent.getRouteParameters().getLong(OPERATOR_ID);
        if (operatorId.isPresent()) {
            Optional<OperatorEntity> optionalOperatorEntity = operatorService.read(operatorId.get());
            if (optionalOperatorEntity.isPresent()) {
                this.populateForm(optionalOperatorEntity.get());
            } else {
                Notification.show(
                        String.format("The requested operator was not found, ID = %d", operatorId.get()),
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                this.refreshGrid();
                beforeEnterEvent.forwardTo(OperatorDetailView.class);
            }
        }
    }
}
