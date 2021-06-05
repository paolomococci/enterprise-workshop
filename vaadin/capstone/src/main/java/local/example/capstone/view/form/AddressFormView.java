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
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.capstone.data.entity.AddressEntity;
import local.example.capstone.data.service.AddressService;
import local.example.capstone.view.MainView;

@Route(value = "address-form", layout = MainView.class)
@PageTitle("Address Form")
@Tag("address-form-view")
@JsModule("./views/forms/address-form-view.ts")
public class AddressFormView
        extends LitTemplate {

    @Id("streetAddress")
    private TextField street;
    @Id("postalCode")
    private TextField postalCode;
    @Id("city")
    private TextField city;
    @Id("state")
    private TextField state;
    @Id("country")
    private TextField country;

    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    private Binder<AddressEntity> addressEntityBinder = new Binder<>(AddressEntity.class);

    public AddressFormView(AddressService addressService) {
        this.addressEntityBinder.bindInstanceFields(this);
        this.clearForm();
        this.cancel.addClickListener(e -> this.clearForm());
        this.save.addClickListener(event -> {
            addressService.create(this.addressEntityBinder.getBean());
            Notification.show(this.addressEntityBinder.getBean().getClass().getSimpleName() + " item created");
            this.clearForm();
        });
    }

    private void clearForm() {
        this.addressEntityBinder.setBean(new AddressEntity());
    }
}
