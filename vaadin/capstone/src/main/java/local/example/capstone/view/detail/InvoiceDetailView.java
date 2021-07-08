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
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.capstone.data.entity.InvoiceEntity;
import local.example.capstone.data.service.InvoiceService;
import local.example.capstone.view.MainView;

import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "invoice-detail/:contactID?/:action?(edit)", layout = MainView.class)
@PageTitle("Invoice Detail")
@Tag("invoice-detail-view")
@JsModule("./views/details/invoice-detail-view.ts")
public class InvoiceDetailView
        extends LitTemplate
        implements HasStyle, BeforeEnterObserver {

    private final String INVOICE_EDIT_ROUTE_TEMPLATE = "invoice-detail/%d/edit";

    @Autowired
    InvoiceEntity invoiceEntity;

    private final InvoiceService invoiceService;

    private final BeanValidationBinder<InvoiceEntity> invoiceEntityBeanValidationBinder;

    @Id("grid")
    private Grid<InvoiceEntity> invoiceEntityGrid;

    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    public InvoiceDetailView(@Autowired InvoiceService invoiceService) {

        this.invoiceService = invoiceService;

        this.invoiceEntityBeanValidationBinder = new BeanValidationBinder<>(InvoiceEntity.class);

        this.cancel.addClickListener(e -> {
            // TODO
        });

        this.save.addClickListener(e -> {
            // TODO
        });
    }

    private void refreshGrid() {
        // TODO
    }

    private void clearForm() {
        // TODO
    }

    private void populateForm(InvoiceEntity invoiceEntity) {
        // TODO

    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        // TODO
    }
}
