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

package local.example.capstone.view.detail;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;

import local.example.capstone.data.entity.PositionEntity;
import local.example.capstone.data.service.PositionService;

import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Position Detail")
@Tag("position-detail-view")
@JsModule("./views/details/position-detail-view.ts")
public class PositionDetailView
        extends LitTemplate
        implements HasStyle, BeforeEnterObserver {

    @Id("grid")
    private Grid<PositionEntity> positionEntityGrid;

    @Id("save")
    private Button save;
    @Id("cancel")
    private Button cancel;

    public PositionDetailView(@Autowired PositionService positionService) {

        this.cancel.addClickListener(e -> {
            // TODO
        });

        this.save.addClickListener(e -> {
            // TODO
        });
    }

    private void refreshGrid() {
        // TODO
    }

    private void clearForm() {
        // TODO
    }

    private void populateForm(PositionEntity positionEntity) {
        // TODO

    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        // TODO
    }
}
