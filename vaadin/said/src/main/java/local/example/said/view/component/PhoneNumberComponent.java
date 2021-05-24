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

package local.example.said.view.component;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.textfield.TextField;

public class PhoneNumberComponent
        extends CustomField<String> {

    private ComboBox<String> countryCode = new ComboBox<>();
    private TextField number = new TextField();

    public PhoneNumberComponent(String label) {
        this.setLabel(label);
        // TODO
    }

    @Override
    protected String generateModelValue() {
        // TODO
        return null;
    }

    @Override
    protected void setPresentationValue(String newPresentationValue) {
        // TODO
    }
}
