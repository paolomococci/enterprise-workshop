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

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;

@PageTitle("Hello")
@Route(value = "hello", layout = MainView.class)
public class HelloView 
        extends HorizontalLayout {

    private TextField nameField;
    private Button helloButton;

    public HelloView() {
        addClassName("hello-view");
        this.nameField = new TextField("Name");
        this.helloButton = new Button("Hello");
        this.add(this.nameField, this.helloButton);
        this.setVerticalComponentAlignment(
                Alignment.END,
                this.nameField,
                this.helloButton
        );
        this.helloButton.addClickListener(buttonClickEvent -> {
            Notification.show("Hello " + this.nameField.getValue());
        });
    }
}
