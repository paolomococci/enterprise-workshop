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

import local.example.capstone.data.entity.ComponentEntity;
import local.example.capstone.data.service.ComponentService;
import local.example.capstone.view.MainView;

import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "component-detail/:contactID?/:action?(edit)", layout = MainView.class)
@PageTitle("Component Detail")
@Tag("component-detail-view")
@JsModule("./views/details/component-detail-view.ts")
public class ComponentDetailView
        extends LitTemplate
        implements HasStyle, BeforeEnterObserver {

    private final String COMPONENT_EDIT_ROUTE_TEMPLATE = "component-detail/%d/edit";

    @Autowired
    ComponentEntity componentEntity;

    private final ComponentService componentService;

    private final BeanValidationBinder<ComponentEntity> componentEntityBeanValidationBinder;

    @Id("grid")
    private Grid<ComponentEntity> componentEntityGrid;

    @Id("componentCode")
    private TextField code;

    @Id("amount")
    private IntegerField amount;

    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    public ComponentDetailView(@Autowired ComponentService componentService) {
        this.addClassNames("component-detail-view", "flex", "flex-col", "h-full");

        this.componentService = componentService;

        this.componentEntityGrid.addColumn((String) null).setHeader((String) null).setAutoWidth(true);
        this.componentEntityGrid.addColumn((String) null).setHeader((String) null).setAutoWidth(true);

        this.componentEntityGrid.setItems(this.componentService.readAll());

        this.componentEntityGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        this.componentEntityGrid.setHeightFull();

        this.componentEntityGrid.asSingleSelect().addValueChangeListener(valueChangeEvent -> {
            // TODO
        });

        this.componentEntityBeanValidationBinder = new BeanValidationBinder<>(ComponentEntity.class);
        this.componentEntityBeanValidationBinder.bindInstanceFields(this);

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

    private void populateForm(ComponentEntity componentEntity) {
        // TODO

    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        // TODO
    }
}
