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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.router.PageTitle;

import local.example.capstone.view.detail.AddressDetailView;
import local.example.capstone.view.form.*;
import local.example.capstone.view.helper.HorizontalMenuItemHelper;

public class MainView
        extends AppLayout {

    private final Tabs horizontalMenuTabs;
    private final Tabs verticalMenuTabs;
    private H1 appTitle;

    public MainView() {
        this.setPrimarySection(Section.DRAWER);
        this.horizontalMenuTabs = this.createHorizontalMenu();
        this.addToNavbar(
                true,
                this.createTopNavbar(
                        (HorizontalLayout) this.createHeaderContent(),
                        this.createHorizontalMenu()
                )
        );
        this.verticalMenuTabs = this.createVerticalMenu();
        this.addToDrawer(
                this.createDrawerContent(verticalMenuTabs)
        );
    }

    private VerticalLayout createTopNavbar(HorizontalLayout headerContent, Tabs horizontalMenu) {
        VerticalLayout topNavbarVerticalLayout = new VerticalLayout();
        topNavbarVerticalLayout.getThemeList().add("dark");
        topNavbarVerticalLayout.setWidthFull();
        topNavbarVerticalLayout.setSpacing(false);
        topNavbarVerticalLayout.setPadding(false);
        topNavbarVerticalLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        topNavbarVerticalLayout.add(headerContent, horizontalMenu);
        return topNavbarVerticalLayout;
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

    private Tabs createHorizontalMenu() {
        final Tabs horizontalMenuTabs = new Tabs();
        horizontalMenuTabs.getStyle().set("max-width", "100%");
        for (Tab horizontalMenuTab : createHorizontalMenuItems()) {
            horizontalMenuTabs.add(horizontalMenuTab);
        }
        return horizontalMenuTabs;
    }

    private List<Tab> createHorizontalMenuItems() {
        final HorizontalMenuItemHelper[] horizontalMenuItems = new HorizontalMenuItemHelper[]{
                new HorizontalMenuItemHelper("Address Detail", "la la-users-cog", AddressDetailView.class),
        };
        List<Tab> tabs = new ArrayList<>();
        for (HorizontalMenuItemHelper horizontalMenuItemHelper : horizontalMenuItems) {
            tabs.add(this.createHorizontalTab(horizontalMenuItemHelper));
        }
        return tabs;
    }

    private Tab createHorizontalTab(HorizontalMenuItemHelper horizontalMenuItemHelper) {
        Tab tab = new Tab();
        RouterLink routerLink = new RouterLink();
        routerLink.setRoute(horizontalMenuItemHelper.getView());
        Span iconSpanElement = new Span();
        iconSpanElement.addClassNames("text-l", "pr-s");
        if (!horizontalMenuItemHelper.getIconClass().isEmpty())
            iconSpanElement.addClassNames(horizontalMenuItemHelper.getIconClass());
        routerLink.add(iconSpanElement, new Text(horizontalMenuItemHelper.getLabel()));
        tab.add(routerLink);
        ComponentUtil.setData(tab, Class.class, horizontalMenuItemHelper.getView());
        return tab;
    }

    private Tabs createVerticalMenu() {
        final Tabs menuTabs = new Tabs();
        menuTabs.setOrientation(Tabs.Orientation.VERTICAL);
        menuTabs.addThemeVariants(TabsVariant.LUMO_MINIMAL);
        menuTabs.setId("tabs");
        menuTabs.add(createMenuItems());
        return menuTabs;
    }

    private Component[] createMenuItems() {
        return new Tab[] {
                createVerticalTab("Search", SearchView.class),
                createVerticalTab("Address Form", AddressFormView.class),
                createVerticalTab("Capacity Form", CapacityFormView.class),
                createVerticalTab("Carrier Form", CarrierFormView.class),
                createVerticalTab("Component Form", ComponentFormView.class),
                createVerticalTab("Contact Form", ContactFormView.class),
                createVerticalTab("Crew Form", CrewFormView.class),
                createVerticalTab("Customer Form", CustomerFormView.class),
                createVerticalTab("Invoice Form", InvoiceFormView.class),
                createVerticalTab("Lot Form", LotFormView.class),
                createVerticalTab("Machine Form", MachineFormView.class),
                createVerticalTab("Operator Form", OperatorFormView.class),
                createVerticalTab("Position Form", PositionFormView.class),
                createVerticalTab("Product Form", ProductFormView.class),
                createVerticalTab("Supplier Form", SupplierFormView.class),
                createVerticalTab("Help", HelpView.class),
                createVerticalTab("About", AboutView.class)
        };
    }

    private static Tab createVerticalTab(
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
        return this.verticalMenuTabs.getChildren()
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
                this.verticalMenuTabs::setSelectedTab
        );
        this.appTitle.setText(
                this.getCurrentPageTitle()
        );
    }
}
