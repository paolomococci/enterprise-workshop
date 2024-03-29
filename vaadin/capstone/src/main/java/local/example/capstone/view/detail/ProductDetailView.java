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

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;

import local.example.capstone.data.entity.ProductEntity;
import local.example.capstone.data.service.ProductService;
import local.example.capstone.view.MainView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

@Route(value = "product-detail/:productID?/:action?(edit)", layout = MainView.class)
@PageTitle("Product Detail")
@Tag("product-detail-view")
@JsModule("./views/details/product-detail-view.ts")
public class ProductDetailView
        extends LitTemplate
        implements BeforeEnterObserver {

    private final String PRODUCT_ID = "productID";
    private final String PRODUCT_EDIT_ROUTE_TEMPLATE = "product-detail/%d/edit";

    private ProductEntity productEntity;

    private final ProductService productService;

    private final BeanValidationBinder<ProductEntity> productEntityBeanValidationBinder;

    @Id("grid")
    private Grid<ProductEntity> productEntityGrid;

    @Id("productCode")
    private TextField code;

    @Id("amount")
    private IntegerField amount;

    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    public ProductDetailView(@Autowired ProductService productService) {
        this.addClassNames("product-detail-view", "flex", "flex-col", "h-full");

        this.productService = productService;

        this.productEntityGrid.addColumn(ProductEntity::getCode).setHeader("Code").setAutoWidth(true);
        this.productEntityGrid.addColumn(ProductEntity::getAmount).setHeader("Amount").setAutoWidth(true);

        this.productEntityGrid.setItems(
                productEntityVoidQuery -> this.productService.readAll(
                        PageRequest.of(
                                productEntityVoidQuery.getPage(),
                                productEntityVoidQuery.getPageSize(),
                                VaadinSpringDataHelpers.toSpringDataSort(productEntityVoidQuery)
                        )
                ).stream()
        );

        this.productEntityGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        this.productEntityGrid.setHeightFull();

        this.productEntityGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        this.productEntityGrid.asSingleSelect().addValueChangeListener(valueChangeEvent -> {
            if (valueChangeEvent.getValue() != null) {
                UI.getCurrent().navigate(String.format(
                        PRODUCT_EDIT_ROUTE_TEMPLATE,
                        valueChangeEvent.getValue().getId()
                ));
            } else {
                this.clearForm();
                UI.getCurrent().navigate(ProductDetailView.class);
            }
        });

        this.productEntityBeanValidationBinder = new BeanValidationBinder<>(ProductEntity.class);
        this.productEntityBeanValidationBinder.bindInstanceFields(this);

        this.cancel.addClickListener(cancelButtonClickEvent -> {
            this.clearForm();
            this.refreshGrid();
        });

        this.save.addClickListener(saveButtonClickEvent -> {
            try {
                if (this.productEntity == null) {
                    this.productEntity = new ProductEntity();
                }
                this.productEntityBeanValidationBinder.writeBean(this.productEntity);
                this.productService.update(this.productEntity);
                this.clearForm();
                this.refreshGrid();
                Notification.show(
                        "product details stored",
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                UI.getCurrent().navigate(ProductDetailView.class);
            } catch (ValidationException validationException) {
                Notification.show(
                        "an exception happened while trying to store the product details",
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
            }
        });
    }

    private void refreshGrid() {
        this.productEntityGrid.select(null);
        this.productEntityGrid.getLazyDataView().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(ProductEntity productEntity) {
        this.productEntity = productEntity;
        this.productEntityBeanValidationBinder.readBean(this.productEntity);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        Optional<Long> productId = beforeEnterEvent.getRouteParameters().getLong(PRODUCT_ID);
        if (productId.isPresent()) {
            Optional<ProductEntity> optionalProductEntity = productService.read(productId.get());
            if (optionalProductEntity.isPresent()) {
                this.populateForm(optionalProductEntity.get());
            } else {
                Notification.show(
                        String.format("The requested product was not found, ID = %d", productId.get()),
                        2500,
                        Notification.Position.BOTTOM_CENTER
                );
                this.refreshGrid();
                beforeEnterEvent.forwardTo(ProductDetailView.class);
            }
        }
    }
}
