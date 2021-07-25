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

package local.example.groupware.view.helper;

import com.vaadin.flow.component.Component;

public class MenuHelper {

    private String text;
    private String iconClass;
    private Class<? extends Component> view;

    public MenuHelper(
            String text,
            String iconClass,
            Class<? extends Component> view
    ) {
        this.text = text;
        this.iconClass = iconClass;
        this.view = view;
    }

    public String getText() {
        return this.text;
    }

    public String getIconClass() {
        return this.iconClass;
    }

    public Class<? extends Component> getView() {
        return this.view;
    }

}
