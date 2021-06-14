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

package local.example.capstone.view;

import java.util.Optional;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.router.PageTitle;

import local.example.capstone.view.form.*;

public class MainView
        extends AppLayout {

    private final Tabs menuTabs;
    private H1 appTitle;

    public MainView() {
        this.setPrimarySection(Section.DRAWER);
        this.addToNavbar(true, createHeaderContent());
        this.menuTabs = createMenu();
        this.addToDrawer(
                this.createDrawerContent(menuTabs)
        );
    }

    private Component createHeaderContent() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setId("header");
        horizontalLayout.getThemeList().set("dark", true);
        horizontalLayout.setWidthFull();
        horizontalLayout.setSpacing(false);
        horizontalLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        horizontalLayout.add(new DrawerToggle());
        this.appTitle = new H1();
        horizontalLayout.add(appTitle);
        horizontalLayout.add(new Avatar());
        return horizontalLayout;
    }

    private Component createDrawerContent(Tabs tabs) {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSizeFull();
        verticalLayout.setPadding(false);
        verticalLayout.setSpacing(false);
        verticalLayout.getThemeList().set("spacing-s", true);
        verticalLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
        HorizontalLayout logoLayout = new HorizontalLayout();
        logoLayout.setId("logo");
        logoLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        logoLayout.add(new Image("images/logo.svg", "capstone logo"));
        logoLayout.add(new H1("capstone"));
        verticalLayout.add(logoLayout, tabs);
        return verticalLayout;
    }

    private Tabs createMenu() {
        final Tabs menuTabs = new Tabs();
        menuTabs.setOrientation(Tabs.Orientation.VERTICAL);
        menuTabs.addThemeVariants(TabsVariant.LUMO_MINIMAL);
        menuTabs.setId("tabs");
        menuTabs.add(createMenuItems());
        return menuTabs;
    }

    private Component[] createMenuItems() {
        return new Tab[] {
                createTab("Search", SearchView.class),
                createTab("Address Form", AddressFormView.class),
                createTab("Carrier Form", CarrierFormView.class),
                createTab("Component Form", ComponentFormView.class),
                createTab("Contact Form", ContactFormView.class),
                createTab("Crew Form", CrewFormView.class),
                createTab("Customer Form", CustomerFormView.class),
                createTab("Invoice Form", InvoiceFormView.class),
                createTab("Machine Form", MachineFormView.class),
                createTab("Operator Form", OperatorFormView.class),
                createTab("Position Form", PositionFormView.class),
                createTab("Product Form", ProductFormView.class),
                createTab("Supplier Form", SupplierFormView.class),
                createTab("Help", HelpView.class),
                createTab("About", AboutView.class)/*,
                createTab("Card List", CardListView.class),
                createTab("Detail", DetailView.class)*/
        };
    }

    private static Tab createTab(
            String text,
            Class<? extends Component> navigationTarget
    ) {
        final Tab navigationTab = new Tab();
        navigationTab.add(new RouterLink(text, navigationTarget));
        ComponentUtil.setData(
                navigationTab,
                Class.class,
                navigationTarget
        );
        return navigationTab;
    }

    private Optional<Tab> getTabForComponent(Component component) {
        return this.menuTabs.getChildren()
                .filter(
                    tab -> ComponentUtil.
                            getData(tab, Class.class)
                            .equals(component.getClass())
                ).findFirst()
                .map(Tab.class::cast);
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        this.getTabForComponent(
                this.getContent()
        ).ifPresent(
                this.menuTabs::setSelectedTab
        );
        this.appTitle.setText(
                this.getCurrentPageTitle()
        );
    }
}
