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

package local.example.bookstore.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;

import local.example.bookstore.view.helper.MenuItemHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@PageTitle("Main")
@Theme(themeFolder = "bookstore")
@PWA(name = "bookstore", shortName = "bookstore", enableInstallPrompt = false)
public class MainView
        extends AppLayout {

    private final Tabs menuTabs;

    public MainView() {
        menuTabs = new Tabs();
    }

    private VerticalLayout createTopBar(
            HorizontalLayout headerHorizontalLayout,
            Tabs menuTabs
    ) {
        VerticalLayout topBarVerticalLayout = new VerticalLayout();
        topBarVerticalLayout.getThemeList().add("dark");
        topBarVerticalLayout.setWidthFull();
        topBarVerticalLayout.setSpacing(false);
        topBarVerticalLayout.setPadding(false);
        topBarVerticalLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        topBarVerticalLayout.add(headerHorizontalLayout, menuTabs);
        return null;
    }

    private HorizontalLayout createHeader() {
        HorizontalLayout headerHorizontalLayout = new HorizontalLayout();
        headerHorizontalLayout.setClassName("topmenu-header");
        headerHorizontalLayout.setPadding(false);
        headerHorizontalLayout.setSpacing(false);
        headerHorizontalLayout.setWidthFull();
        headerHorizontalLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        Image logo = new Image("images/logo.png", "bookstore logo");
        logo.setId("logo");
        headerHorizontalLayout.add(logo);
        headerHorizontalLayout.add(new H1("bookstore"));
        Avatar avatar = new Avatar();
        avatar.addClassNames("ms-auto", "me-m");
        headerHorizontalLayout.add(avatar);
        return headerHorizontalLayout;
    }

    private Tabs createMenuTabs() {
        final Tabs menuTabs = new Tabs();
        menuTabs.getStyle().set("max-width", "100%");
        for (Tab menuTab : this.createMenuItems()) {
            menuTabs.add(menuTab);
        }
        return menuTabs;
    }

    private List<Tab> createMenuItems() {
        MenuItemHelper[] menuItemHelpers = new MenuItemHelper[] {
                // TODO
        };
        List<Tab> menuTabs = new ArrayList<>();
        for (MenuItemHelper menuItemHelper : menuItemHelpers) {
            menuTabs.add(createTab(menuItemHelper));

        }
        return menuTabs;
    }

    private Tab createTab(MenuItemHelper menuItemHelper) {
        Tab menuTab = new Tab();
        RouterLink routerLink = new RouterLink();
        routerLink.setRoute(menuItemHelper.getTabView());
        Span iconElementSpan = new Span();
        iconElementSpan.addClassNames("text-l", "pr-s");
        if (!menuItemHelper.getIconClass().isEmpty()) {
            iconElementSpan.addClassNames(menuItemHelper.getIconClass());
        }
        routerLink.add(iconElementSpan, new Text(menuItemHelper.getLabel()));
        menuTab.add(routerLink);
        ComponentUtil.setData(
                menuTab,
                Class.class,
                menuItemHelper.getTabView()
        );
        return menuTab;
    }

    private Optional<Tab> getTabForComponent(Component component) {
        return menuTabs
                .getChildren()
                .filter(tab -> ComponentUtil.getData(tab, Class.class).equals(component.getClass()))
                .findFirst()
                .map(Tab.class::cast);
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        getTabForComponent(getContent()).ifPresent(menuTabs::setSelectedTab);
    }
}
