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
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.capstone.data.entity.ContactEntity;
import local.example.capstone.data.service.ContactService;
import local.example.capstone.view.MainView;

@Route(value = "contact-form", layout = MainView.class)
@PageTitle("Contact Form")
@Tag("contact-form-view")
@JsModule("./views/forms/contact-form-view.ts")
public class ContactFormView
        extends LitTemplate {

    @Id("name")
    private TextField name;

    @Id("surname")
    private TextField surname;

    @Id("dateOfBirth")
    private DatePicker dateOfBirth;

    @Id("phoneMobileNumber")
    private TextField phoneMobileNumber;

    @Id("contributoryIdentifier")
    private TextField contributoryIdentifier;

    @Id("email")
    private EmailField email;

    @Id("profession")
    private TextField profession;

    @Id("role")
    private TextField role;

    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    private Binder<ContactEntity> contactEntityBinder = new Binder(ContactEntity.class);

    public ContactFormView(ContactService contactService) {
        this.contactEntityBinder.bindInstanceFields(this);
        this.clearForm();
        this.cancel.addClickListener(buttonClickEvent -> this.clearForm());
        this.save.addClickListener(buttonClickEvent -> {
            contactService.create(this.contactEntityBinder.getBean());
            Notification.show("added an item " + this.contactEntityBinder.getBean().getClass().getSimpleName());
            this.clearForm();
        });
    }

    private void clearForm() {
        contactEntityBinder.setBean(new ContactEntity());
    }
}
