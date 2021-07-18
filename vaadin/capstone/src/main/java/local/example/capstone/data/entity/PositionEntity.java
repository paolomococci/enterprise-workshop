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

package local.example.capstone.data.entity;

import local.example.capstone.data.AbstractNode;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "positions")
public class PositionEntity
        extends AbstractNode {

    @Getter
    @Setter
    private Boolean consumptionProduct;

    @Getter
    @Setter
    private Boolean detergent;

    @Getter
    @Setter
    private Boolean sanitizing;

    @Getter
    @Setter
    private Boolean equipment;

    @Getter
    @Setter
    private Boolean clothing;

    @Getter
    @Setter
    private Boolean protectionDevice;

    @Getter
    @Setter
    private Boolean primaryPackaging;

    @Getter
    @Setter
    private Boolean secondaryPackaging;

    @Getter
    @Setter
    private Boolean complementForShipping;

    @Getter
    @Setter
    private Boolean rowMaterial;

    @Getter
    @Setter
    private Boolean containingAllergens;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "machine_fk")
    private MachineEntity machine;
}
