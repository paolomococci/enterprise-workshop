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
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.capstone.data.entity.ContactEntity;
import local.example.capstone.data.service.ContactService;
import local.example.capstone.view.MainView;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Route(value = "contact-detail/:contactID?/:action?(edit)", layout = MainView.class)
@PageTitle("Contact Detail")
@Tag("contact-detail-view")
@JsModule("./views/details/contact-detail-view.ts")
public class ContactDetailView
        extends LitTemplate
        implements HasStyle, BeforeEnterObserver {

    private final String CONTACT_ID = "contactID";
    private final String CONTACT_EDIT_ROUTE_TEMPLATE = "contact-detail/%d/edit";

    private ContactEntity contactEntity;

    private final ContactService contactService;

    private final BeanValidationBinder<ContactEntity> contactEntityBeanValidationBinder;

    @Id("grid")
    private Grid<ContactEntity> contactEntityGrid;

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

    public ContactDetailView(@Autowired ContactService contactService) {
        this.addClassNames("contact-detail-view", "flex", "flex-col", "h-full");

        this.contactService = contactService;

        this.contactEntityGrid.addColumn(ContactEntity::getName).setHeader("Name").setAutoWidth(true);
        this.contactEntityGrid.addColumn(ContactEntity::getSurname).setHeader("Surname").setAutoWidth(true);
        this.contactEntityGrid.addColumn(ContactEntity::getDateOfBirth).setHeader("Birthday").setAutoWidth(true);
        this.contactEntityGrid.addColumn(ContactEntity::getPhoneMobileNumber).setHeader("Phone").setAutoWidth(true);
        this.contactEntityGrid.addColumn(ContactEntity::getContributoryIdentifier).setHeader("Contributory Identifier").setAutoWidth(true);
        this.contactEntityGrid.addColumn(ContactEntity::getEmail).setHeader("Email").setAutoWidth(true);
        this.contactEntityGrid.addColumn(ContactEntity::getProfession).setHeader("Profession").setAutoWidth(true);
        this.contactEntityGrid.addColumn(ContactEntity::getRole).setHeader("Role").setAutoWidth(true);

        this.contactEntityGrid.setItems(this.contactService.readAll());

        this.contactEntityGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        this.contactEntityGrid.setHeightFull();

        this.contactEntityGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        this.contactEntityGrid.asSingleSelect().addValueChangeListener(valueChangeEvent -> {
            if (valueChangeEvent.getValue() != null) {
                UI.getCurrent().navigate(String.format(
                        CONTACT_EDIT_ROUTE_TEMPLATE,
                        valueChangeEvent.getValue().getId()
                ));
            } else {
                this.clearForm();
                UI.getCurrent().navigate(ContactDetailView.class);
            }
        });

        this.contactEntityBeanValidationBinder = new BeanValidationBinder<>(ContactEntity.class);
        this.contactEntityBeanValidationBinder.bindInstanceFields(this);

        this.cancel.addClickListener(cancelButtonClickEvent -> {
            this.clearForm();
            this.refreshGrid();
        });

        this.save.addClickListener(saveButtonClickEvent -> {
            try {
                if (this.contactEntity == null) {
                    this.contactEntity = new ContactEntity();
                }
                this.contactEntityBeanValidationBinder.writeBean(this.contactEntity);
                this.contactService.update(this.contactEntity);
                this.clearForm();
                this.refreshGrid();
                Notification.show(
                        "contact details stored",
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                UI.getCurrent().navigate(ContactDetailView.class);
            } catch (ValidationException validationException) {
                Notification.show(
                        "an exception happened while trying to store the contact details",
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
            }
        });
    }

    private void refreshGrid() {
        this.contactEntityGrid.select(null);
        this.contactEntityGrid.getLazyDataView().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(ContactEntity contactEntity) {
        this.contactEntity = contactEntity;
        this.contactEntityBeanValidationBinder.readBean(this.contactEntity);

    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        Optional<Long> contactId = beforeEnterEvent.getRouteParameters().getLong(CONTACT_ID);
        if (contactId.isPresent()) {
            Optional<ContactEntity> optionalContactEntity = contactService.read(String.valueOf(contactId.get()));
            if (optionalContactEntity.isPresent()) {
                this.populateForm(optionalContactEntity.get());
            } else {
                Notification.show(
                        String.format("The requested contact was not found, ID = %d", contactId.get()),
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                this.refreshGrid();
                beforeEnterEvent.forwardTo(ContactDetailView.class);
            }
        }
    }
}
