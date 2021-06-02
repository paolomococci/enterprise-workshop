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
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.applayout.AppLayout;

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
        HorizontalLayout layout = new HorizontalLayout();
        layout.setId("header");
        layout.getThemeList().set("dark", true);
        layout.setWidthFull();
        layout.setSpacing(false);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.add(new DrawerToggle());
        appTitle = new H1();
        layout.add(appTitle);
        layout.add(new Avatar());
        return layout;
    }

    private Component createDrawerContent(Tabs menu) {
    }

    private Tabs createMenu() {
    }

    private Component[] createMenuItems() {
    }

    private static Tab createTab() {
    }

    private Optional<Tab> getTabForComponent(Component component) {
    }

    private String getCurrentPageTitle() {
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
