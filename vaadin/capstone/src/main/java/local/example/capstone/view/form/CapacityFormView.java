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

import local.example.capstone.data.entity.CapacityEntity;
import local.example.capstone.data.service.CapacityService;
import local.example.capstone.view.MainView;

@Route(value = "capacity-form", layout = MainView.class)
@PageTitle("Capacity Form")
@Tag("capacity-form-view")
@JsModule("./views/forms/capacity-form-view.ts")
public class CapacityFormView
        extends LitTemplate {

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

    private Binder<CapacityEntity> capacityEntityBinder = new BeanValidationBinder<>(CapacityEntity.class);

    public CapacityFormView(CapacityService capacityService) {
        this.capacityEntityBinder.bindInstanceFields(this);
        this.clearForm();
        this.cancel.addClickListener(buttonClickEvent -> this.clearForm());
        this.save.addClickListener(buttonClickEvent -> {
            capacityService.create(this.capacityEntityBinder.getBean());
            Notification.show("added an item " + this.capacityEntityBinder.getBean().getClass().getSimpleName());
            this.clearForm();
        });
    }

    private void clearForm() {
        this.capacityEntityBinder.setBean(new CapacityEntity());
    }
}
