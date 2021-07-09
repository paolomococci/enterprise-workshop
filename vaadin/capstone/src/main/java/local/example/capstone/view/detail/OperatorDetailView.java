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
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.capstone.data.entity.OperatorEntity;
import local.example.capstone.data.service.OperatorService;
import local.example.capstone.view.MainView;

import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "operator-detail/:contactID?/:action?(edit)", layout = MainView.class)
@PageTitle("Operator Detail")
@Tag("operator-detail-view")
@JsModule("./views/details/operator-detail-view.ts")
public class OperatorDetailView
        extends LitTemplate
        implements HasStyle, BeforeEnterObserver {

    private final String OPERATOR_EDIT_ROUTE_TEMPLATE = "operator-detail/%d/edit";

    @Autowired
    OperatorEntity operatorEntity;

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

        this.operatorEntityBeanValidationBinder = new BeanValidationBinder<>(OperatorEntity.class);

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

    private void populateForm(OperatorEntity operatorEntity) {
        // TODO

    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        // TODO
    }
}
