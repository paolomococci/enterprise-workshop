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

package local.example.warehause.data.entity;

import local.example.warehause.data.AbstractNode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "machines")
public class MachineEntity
        extends AbstractNode {

    @OneToMany(mappedBy = "positionMachine", fetch = FetchType.LAZY)
    private List<PositionEntity> positions = new LinkedList<>();

    @OneToMany(mappedBy = "crewMachine", fetch = FetchType.LAZY)
    private List<CrewEntity> crews = new LinkedList<>();

    @OneToMany(mappedBy = "productMachine", fetch = FetchType.LAZY)
    private List<ProductEntity> products = new LinkedList<>();
}
