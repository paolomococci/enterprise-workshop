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
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.capstone.data.entity.InvoiceEntity;
import local.example.capstone.data.service.InvoiceService;
import local.example.capstone.view.MainView;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Route(value = "invoice-detail/:invoiceID?/:action?(edit)", layout = MainView.class)
@PageTitle("Invoice Detail")
@Tag("invoice-detail-view")
@JsModule("./views/details/invoice-detail-view.ts")
public class InvoiceDetailView
        extends LitTemplate
        implements HasStyle, BeforeEnterObserver {

    private final String INVOICE_ID = "invoiceID";
    private final String INVOICE_EDIT_ROUTE_TEMPLATE = "invoice-detail/%d/edit";

    private InvoiceEntity invoiceEntity;

    private final InvoiceService invoiceService;

    private BeanValidationBinder<InvoiceEntity> invoiceEntityBeanValidationBinder;

    @Id("grid")
    private Grid<InvoiceEntity> invoiceEntityGrid;

    @Id("invoiceCode")
    private TextField code;

    @Id("total")
    private NumberField total;

    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    public InvoiceDetailView(@Autowired InvoiceService invoiceService) {
        this.addClassNames("invoice-detail-view", "flex", "flex-col", "h-full");

        this.invoiceService = invoiceService;

        this.invoiceEntityGrid.addColumn(InvoiceEntity::getCode).setHeader("Code").setAutoWidth(true);
        this.invoiceEntityGrid.addColumn(InvoiceEntity::getTotal).setHeader("Total").setAutoWidth(true);

        this.invoiceEntityGrid.setItems(this.invoiceService.readAll());

        this.invoiceEntityGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        this.invoiceEntityGrid.setHeightFull();

        this.invoiceEntityGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        this.invoiceEntityGrid.asSingleSelect().addValueChangeListener(valueChangeEvent -> {
            if (valueChangeEvent.getValue() != null) {
                UI.getCurrent().navigate(String.format(
                        INVOICE_EDIT_ROUTE_TEMPLATE,
                        valueChangeEvent.getValue().getId()
                ));
            } else {
                this.clearForm();
                UI.getCurrent().navigate(InvoiceDetailView.class);
            }
        });

        this.invoiceEntityBeanValidationBinder = new BeanValidationBinder<>(InvoiceEntity.class);
        this.invoiceEntityBeanValidationBinder.bindInstanceFields(this);

        this.cancel.addClickListener(cancelButtonClickEvent -> {
            this.clearForm();
            this.refreshGrid();
        });

        this.save.addClickListener(saveButtonClickEvent -> {
            try {
                if (this.invoiceEntity == null) {
                    this.invoiceEntity = new InvoiceEntity();
                }
                this.invoiceEntityBeanValidationBinder.writeBean(this.invoiceEntity);
                this.invoiceService.update(this.invoiceEntity);
                this.clearForm();
                this.refreshGrid();
                Notification.show(
                        "invoice details stored",
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                UI.getCurrent().navigate(InvoiceDetailView.class);
            } catch (ValidationException validationException) {
                Notification.show(
                        "an exception happened while trying to store the invoice details",
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
            }
        });
    }

    private void refreshGrid() {
        this.invoiceEntityGrid.select(null);
        this.invoiceEntityGrid.getLazyDataView().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(InvoiceEntity invoiceEntity) {
        this.invoiceEntity = invoiceEntity;
        this.invoiceEntityBeanValidationBinder.readBean(this.invoiceEntity);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        Optional<Long> invoiceId = beforeEnterEvent.getRouteParameters().getLong(INVOICE_ID);
        if (invoiceId.isPresent()) {
            Optional<InvoiceEntity> optionalInvoiceEntity = invoiceService.read(invoiceId.get());
            if (optionalInvoiceEntity.isPresent()) {
                this.populateForm(optionalInvoiceEntity.get());
            } else {
                Notification.show(
                        String.format("The requested invoice was not found, ID = %d", invoiceId.get()),
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                this.refreshGrid();
                beforeEnterEvent.forwardTo(InvoiceDetailView.class);
            }
        }
    }
}
