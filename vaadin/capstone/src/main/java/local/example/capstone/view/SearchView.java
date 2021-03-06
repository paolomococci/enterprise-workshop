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

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "search", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Search")
@Tag("search-view")
@JsModule("./views/search-view.ts")
public class SearchView
        extends LitTemplate {

    @Id("textToSearchFor")
    private TextField text;

    @Id("quest")
    private Button quest;
    @Id("cancel")
    private Button cancel;

    public SearchView() {
        this.clearForm();
        this.cancel.addClickListener(buttonClickEvent -> this.clearForm());
        this.quest.addClickListener(buttonClickEvent -> {
            Notification.show("text to search for: " + this.text.getValue());
            // TODO
        });
    }

    private void clearForm() {
        this.text.clear();
        this.text.setPlaceholder("you can only type letters and numbers");
    }
}
