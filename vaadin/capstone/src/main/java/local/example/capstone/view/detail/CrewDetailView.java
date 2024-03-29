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

import local.example.capstone.data.entity.CrewEntity;
import local.example.capstone.data.service.CrewService;
import local.example.capstone.view.MainView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

@Route(value = "crew-detail/:crewID?/:action?(edit)", layout = MainView.class)
@PageTitle("Crew Detail")
@Tag("crew-detail-view")
@JsModule("./views/details/crew-detail-view.ts")
public class CrewDetailView
        extends LitTemplate
        implements BeforeEnterObserver {

    private final String CREW_ID = "crewID";
    private final String CREW_EDIT_ROUTE_TEMPLATE = "crew-detail/%d/edit";

    private CrewEntity crewEntity;

    private final CrewService crewService;

    private final BeanValidationBinder<CrewEntity> crewEntityBeanValidationBinder;

    @Id("grid")
    private Grid<CrewEntity> crewEntityGrid;

    @Id("crewCode")
    private TextField code;

    @Id("crewName")
    private TextField name;

    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    public CrewDetailView(@Autowired CrewService crewService) {
        this.addClassNames("crew-detail-view", "flex", "flex-col", "h-full");

        this.crewService = crewService;

        this.crewEntityGrid.addColumn(CrewEntity::getCode).setHeader("Code").setAutoWidth(true);
        this.crewEntityGrid.addColumn(CrewEntity::getName).setHeader("Name").setAutoWidth(true);

        this.crewEntityGrid.setItems(
                crewEntityVoidQuery -> this.crewService.readAll(
                        PageRequest.of(
                                crewEntityVoidQuery.getPage(),
                                crewEntityVoidQuery.getPageSize(),
                                VaadinSpringDataHelpers.toSpringDataSort(crewEntityVoidQuery)
                        )
                ).stream()
        );

        this.crewEntityGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        this.crewEntityGrid.setHeightFull();

        this.crewEntityGrid.asSingleSelect().addValueChangeListener(valueChangeEvent -> {
            if (valueChangeEvent.getValue() != null) {
                UI.getCurrent().navigate(String.format(
                        CREW_EDIT_ROUTE_TEMPLATE,
                        valueChangeEvent.getValue().getId()
                ));
            } else {
                this.clearForm();
                UI.getCurrent().navigate(CrewDetailView.class);
            }
        });

        this.crewEntityGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        this.crewEntityBeanValidationBinder = new BeanValidationBinder<>(CrewEntity.class);
        this.crewEntityBeanValidationBinder.bindInstanceFields(this);

        this.cancel.addClickListener(cancelButtonClickEvent -> {
            this.clearForm();
            this.refreshGrid();
        });

        this.save.addClickListener(saveButtonClickEvent -> {
            try {
                if (this.crewEntity == null) {
                    this.crewEntity = new CrewEntity();
                }
                this.crewEntityBeanValidationBinder.writeBean(this.crewEntity);
                this.crewService.update(this.crewEntity);
                this.clearForm();
                this.refreshGrid();
                Notification.show(
                        "crew details stored",
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                UI.getCurrent().navigate(CrewDetailView.class);
            } catch (ValidationException validationException) {
                Notification.show(
                        "an exception happened while trying to store the crew details",
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
            }
        });
    }

    private void refreshGrid() {
        this.crewEntityGrid.select(null);
        this.crewEntityGrid.getLazyDataView().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(CrewEntity crewEntity) {
        this.crewEntity = crewEntity;
        this.crewEntityBeanValidationBinder.readBean(this.crewEntity);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        Optional<Long> crewId = beforeEnterEvent.getRouteParameters().getLong(CREW_ID);
        if (crewId.isPresent()) {
            Optional<CrewEntity> optionalCrewEntity = crewService.read(crewId.get());
            if (optionalCrewEntity.isPresent()) {
                this.populateForm(optionalCrewEntity.get());
            } else {
                Notification.show(
                        String.format("The requested crew was not found, ID = %d", crewId.get()),
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                this.refreshGrid();
                beforeEnterEvent.forwardTo(CrewDetailView.class);
            }
        }
    }
}
