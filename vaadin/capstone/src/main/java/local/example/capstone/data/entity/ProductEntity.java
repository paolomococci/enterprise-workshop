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

import local.example.capstone.data.AbstractItem;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductEntity
        extends AbstractItem {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_machine_fk")
    private MachineEntity productMachine;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_invoice_fk")
    private InvoiceEntity productInvoice;

    @OneToMany(mappedBy = "lotProduct", fetch = FetchType.LAZY)
    private List<LotEntity> lots = new LinkedList<>();

    @OneToMany(mappedBy = "componentProduct", fetch = FetchType.LAZY)
    private List<ComponentEntity> components = new LinkedList<>();
}
