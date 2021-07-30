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
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;

import local.example.bookstore.view.helper.MenuItemHelper;

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

    private VerticalLayout createTopBar() {
        // TODO
        return null;
    }

    private HorizontalLayout createHeader() {
        // TODO
        return null;
    }

    private Tabs createMenuTabs() {
        // TODO
        return null;
    }

    private List<Tab> createMenuItems() {
        // TODO
        return null;
    }

    private Tab createTab(MenuItemHelper menuItemHelper) {
        // TODO
        return null;
    }

    private Optional<Tab> getTabForComponent(Component component) {
        // TODO
        return null;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        getTabForComponent(getContent()).ifPresent(menuTabs::setSelectedTab);
    }
}
