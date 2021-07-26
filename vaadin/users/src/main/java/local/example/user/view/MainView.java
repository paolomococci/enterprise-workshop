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

package local.example.user.view;

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
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.router.PageTitle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import local.example.user.view.helper.MenuItemHelper;

@PageTitle("Main")
public class MainView
        extends AppLayout {

    private final Tabs menuTabs;

    public MainView() {
        HorizontalLayout headerFromHorizontalLayout = createHeaderFromHorizontalLayout();
        this.menuTabs = createMenuTabs();
        addToNavbar(createTopBarFromVerticalLayout(headerFromHorizontalLayout, this.menuTabs));
    }

    private VerticalLayout createTopBarFromVerticalLayout(
            HorizontalLayout horizontalLayoutHeader,
            Tabs menuTabs
    ) {
        VerticalLayout layout = new VerticalLayout();
        layout.getThemeList().add("dark");
        layout.setWidthFull();
        layout.setSpacing(false);
        layout.setPadding(false);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.add(horizontalLayoutHeader, menuTabs);
        return layout;
    }

    private HorizontalLayout createHeaderFromHorizontalLayout() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setClassName("topmenu-header");
        layout.setPadding(false);
        layout.setSpacing(false);
        layout.setWidthFull();
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        Image logo = new Image("images/logo.png", "users logo");
        logo.setId("logo");
        layout.add(logo);
        layout.add(new H1("users"));
        Avatar avatar = new Avatar();
        avatar.addClassNames("ms-auto", "me-m");
        layout.add(avatar);
        return layout;
    }

    private Tabs createMenuTabs() {
        final Tabs tabs = new Tabs();
        tabs.getStyle().set("max-width", "100%");
        for (Tab menuTab : createMenuItems()) {
            tabs.add(menuTab);
        }
        return tabs;
    }

    private List<Tab> createMenuItems() {
        MenuItemHelper[] menuItems = new MenuItemHelper[] {
                new MenuItemHelper("Sample", "la la-file", SampleView.class),
                new MenuItemHelper("Hello", "la la-globe", HelloView.class),
                new MenuItemHelper("Users", "la la-users-cog", UserView.class),
        };
        List<Tab> tabs = new ArrayList<>();
        for (MenuItemHelper menuItemInfo : menuItems) {
            tabs.add(createTab(menuItemInfo));
        }
        return tabs;
    }

    private Tab createTab(MenuItemHelper menuItemInfo) {
        Tab tab = new Tab();
        RouterLink link = new RouterLink();
        link.setRoute(menuItemInfo.getView());
        Span iconElement = new Span();
        iconElement.addClassNames("text-l", "pr-s");
        if (!menuItemInfo.getIconClass().isEmpty()) {
            iconElement.addClassNames(menuItemInfo.getIconClass());
        }
        link.add(iconElement, new Text(menuItemInfo.getText()));
        tab.add(link);
        ComponentUtil.setData(tab, Class.class, menuItemInfo.getView());
        return tab;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        getTabForComponent(getContent()).ifPresent(this.menuTabs::setSelectedTab);
    }

    private Optional<Tab> getTabForComponent(Component component) {
        return this.menuTabs
                .getChildren()
                .filter(
                        tab -> {
                            return ComponentUtil
                                    .getData(tab, Class.class)
                                    .equals(component.getClass());
                        }
                )
                .findFirst()
                .map(Tab.class::cast);
    }
}
