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

package local.example.said.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import java.util.Optional;

@Theme(variant = Lumo.DARK)
@CssImport(value = "themes/said/styles.css")
@PWA(name = "the customer said, feedback from customers", shortName = "said")
public class MainView
        extends AppLayout {

    private final Tabs tabs;
    private H1 headTitle;

    public MainView() {
        this.setPrimarySection(Section.DRAWER);
        this.addToNavbar(true, this.createHeaderContent());
        this.tabs = null;
    }

    private Component createHeaderContent() {
        HorizontalLayout layout = new HorizontalLayout();
        // TODO
        return layout;
    }

    private Component createDrawerContent(Tabs tabs) {
        // TODO
        return null;
    }

    private Tabs createMenuTabs() {
        // TODO
        return null;
    }

    private Component[] createMenuItems() {
        // TODO
        return null;
    }

    private static Tab createTab(String text, Class<? extends Component> navigationTarget) {
        //TODO
        return null;
    }

    @Override
    protected void afterNavigation() {
        // TODO
    }

    private Optional<Tab> getTabForComponent(Component component) {
        // TODO
        return null;
    }

    private String getCurrentPageTitle() {
        // TODO
        return null;
    }
}
