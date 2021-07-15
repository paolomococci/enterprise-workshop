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

package local.example.capstone.view.helper;

import com.vaadin.flow.component.Component;

public class HorizontalMenuItemHelper {

    private String label;
    private String icon;
    private Class<? extends Component> view;

    public HorizontalMenuItemHelper(
            String label,
            String icon,
            Class<? extends Component> view
    ) {
        this.label = label;
        this.icon = icon;
        this.view = view;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Class<? extends Component> getView() {
        return view;
    }

    public void setView(Class<? extends Component> view) {
        this.view = view;
    }
}
