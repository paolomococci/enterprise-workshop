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

package local.example.groupware.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.html.Anchor;
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
import com.vaadin.flow.server.auth.AccessAnnotationChecker;
import local.example.groupware.data.entity.User;
import local.example.groupware.data.security.auth.UserAuth;
import local.example.groupware.view.helper.MenuHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@PageTitle("Main")
public class MainView
        extends AppLayout {

    private final Tabs menuTabs;

    private UserAuth userAuth;
    private AccessAnnotationChecker accessAnnotationChecker;

    public MainView(UserAuth userAuth, AccessAnnotationChecker accessAnnotationChecker) {
        this.userAuth = userAuth;
        this.accessAnnotationChecker = accessAnnotationChecker;

        HorizontalLayout horizontalLayoutHeader = createHeader();
        this.menuTabs = createMenuTabs();
        addToNavbar(createTopBar(horizontalLayoutHeader, this.menuTabs));
    }

    private VerticalLayout createTopBar(
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

    private HorizontalLayout createHeader() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setClassName("topmenu-header");
        horizontalLayout.setPadding(false);
        horizontalLayout.setSpacing(false);
        horizontalLayout.setWidthFull();
        horizontalLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        Image groupwareLogo = new Image("images/logo.png", "groupware logo");
        groupwareLogo.setId("logo");
        horizontalLayout.add(groupwareLogo);
        horizontalLayout.add(new H1("Groupware"));

        Optional<User> optionalUser = userAuth.get();

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Avatar avatar = new Avatar(user.getName(), user.getProfileImageUrl());
            avatar.addClassNames("ms-auto", "me-m");
            ContextMenu userMenu = new ContextMenu(avatar);
            userMenu.setOpenOnClick(true);
            userMenu.addItem("Logout", menuItemClickEvent -> {
                userAuth.logout();
            });
            // TODO
            //horizontalLayout.add(avatar);
        } else {
            Anchor loginAnchor = new Anchor("login", "Login");
            loginAnchor.addClassNames("ms-auto", "me-m");
            // TODO
            //horizontalLayout.add(loginAnchor);
        }

        return horizontalLayout;
    }

    private Tabs createMenuTabs() {
        final Tabs menuTabs = new Tabs();
        menuTabs.getStyle().set("max-width", "100%");
        for (Tab menuTab : createMenuItems()) {
            menuTabs.add(menuTab);
        }
        return menuTabs;
    }

    private List<Tab> createMenuItems() {
        MenuHelper[] menuItems = new MenuHelper[] {
                new MenuHelper("Empty", "la la-file", SampleView.class),
                new MenuHelper("Hello", "la la-globe", HelloView.class),
                new MenuHelper("Users", "la la-users-cog", UserView.class),
        };
        List<Tab> tabs = new ArrayList<>();
        for (MenuHelper menuHelper : menuItems) {
            if (accessAnnotationChecker.hasAccess(menuHelper.getView())) {
                tabs.add(createMenuTab(menuHelper));
            }

        }
        return tabs;
    }

    private Tab createMenuTab(MenuHelper menuHelper) {
        Tab menuTab = new Tab();
        RouterLink link = new RouterLink();
        link.setRoute(menuHelper.getView());
        Span iconElement = new Span();
        iconElement.addClassNames("text-l", "pr-s");
        if (!menuHelper.getIconClass().isEmpty()) {
            iconElement.addClassNames(menuHelper.getIconClass());
        }
        link.add(iconElement, new Text(menuHelper.getText()));
        menuTab.add(link);
        ComponentUtil.setData(menuTab, Class.class, menuHelper.getView());

        return menuTab;
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
