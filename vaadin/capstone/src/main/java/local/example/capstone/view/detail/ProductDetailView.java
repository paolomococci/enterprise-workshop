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
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import local.example.capstone.data.entity.ProductEntity;
import local.example.capstone.data.service.ProductService;
import local.example.capstone.view.MainView;

import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "product-detail/:contactID?/:action?(edit)", layout = MainView.class)
@PageTitle("Product Detail")
@Tag("product-detail-view")
@JsModule("./views/details/product-detail-view.ts")
public class ProductDetailView
        extends LitTemplate
        implements HasStyle, BeforeEnterObserver {

    private final String PRODUCT_EDIT_ROUTE_TEMPLATE = "product-detail/%d/edit";

    @Autowired
    ProductEntity productEntity;

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

        this.productEntityGrid.addColumn((String) null).setHeader((String) null).setAutoWidth(true);
        this.productEntityGrid.addColumn((String) null).setHeader((String) null).setAutoWidth(true);

        this.productEntityGrid.setItems(this.productService.readAll());

        this.productEntityGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        this.productEntityGrid.setHeightFull();

        this.productEntityGrid.asSingleSelect().addValueChangeListener(valueChangeEvent -> {
            // TODO
        });

        this.productEntityBeanValidationBinder = new BeanValidationBinder<>(ProductEntity.class);

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

    private void populateForm(ProductEntity productEntity) {
        // TODO

    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        // TODO
    }
}
