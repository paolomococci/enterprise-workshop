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
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.capstone.data.entity.ComponentEntity;
import local.example.capstone.data.service.ComponentService;
import local.example.capstone.view.MainView;

@Route(value = "component-form", layout = MainView.class)
@PageTitle("Component Form")
@Tag("component-form-view")
@JsModule("./views/forms/component-form-view.ts")
public class ComponentFormView
        extends LitTemplate {

    @Id("componentCode")
    private TextField code;
    
    @Id("amount")
    private IntegerField amount;

    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    private Binder<ComponentEntity> componentEntityBinder = new Binder<>(ComponentEntity.class);

    public ComponentFormView(ComponentService componentService) {
        this.componentEntityBinder.bindInstanceFields(this);
        this.clearForm();
        this.cancel.addClickListener(buttonClickEvent -> this.clearForm());
        this.save.addClickListener(buttonClickEvent -> {
            componentService.create(this.componentEntityBinder.getBean());
            Notification.show("added an item " + this.componentEntityBinder.getBean().getClass().getSimpleName());
            this.clearForm();
        });
    }

    private void clearForm() {
        this.componentEntityBinder.setBean(new ComponentEntity());
    }
}
