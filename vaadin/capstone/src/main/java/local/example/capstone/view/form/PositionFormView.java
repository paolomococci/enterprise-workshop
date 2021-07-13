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

package local.example.capstone.view.form;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.capstone.data.entity.PositionEntity;
import local.example.capstone.data.service.PositionService;
import local.example.capstone.view.MainView;

@Route(value = "position-form", layout = MainView.class)
@PageTitle("Position Form")
@Tag("position-form-view")
@JsModule("./views/forms/position-form-view.ts")
public class PositionFormView
        extends LitTemplate {

    @Id("positionLabel")
    private TextField label;

    @Id("capacity")
    private IntegerField capacity;

    @Id("consumptionProduct")
    private Checkbox consumptionProduct;

    @Id("detergent")
    private Checkbox detergent;

    @Id("sanitizing")
    private Checkbox sanitizing;

    @Id("equipment")
    private Checkbox equipment;

    @Id("clothing")
    private Checkbox clothing;

    @Id("protectionDevice")
    private Checkbox protectionDevice;

    @Id("primaryPackaging")
    private Checkbox primaryPackaging;

    @Id("secondaryPackaging")
    private Checkbox secondaryPackaging;

    @Id("complementForShipping")
    private Checkbox complementForShipping;

    @Id("rowMaterial")
    private Checkbox rowMaterial;

    @Id("containingAllergens")
    private Checkbox containingAllergens;

    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    private Binder<PositionEntity> positionEntityBinder = new BeanValidationBinder<>(PositionEntity.class);

    public PositionFormView(PositionService positionService) {
        this.positionEntityBinder.bindInstanceFields(this);
        this.clearForm();
        this.cancel.addClickListener(buttonClickEvent -> this.clearForm());
        this.save.addClickListener(buttonClickEvent -> {
            positionService.create(this.positionEntityBinder.getBean());
            Notification.show("added an item " + this.positionEntityBinder.getBean().getClass().getSimpleName());
            this.clearForm();
        });
    }

    private void clearForm() {
        this.positionEntityBinder.setBean(new PositionEntity());
    }
}
