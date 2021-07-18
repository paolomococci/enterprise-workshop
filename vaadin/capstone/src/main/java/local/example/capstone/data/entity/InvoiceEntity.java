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

import local.example.capstone.data.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@Table(name = "invoices")
@EqualsAndHashCode(callSuper=false)
public class InvoiceEntity
        extends AbstractEntity {

    private String code;
    private Double total;

    @OneToMany(mappedBy = "productInvoice", fetch = FetchType.LAZY)
    private List<ProductEntity> products = new LinkedList<>();

    @OneToMany(mappedBy = "componentInvoice", fetch = FetchType.LAZY)
    private List<ComponentEntity> components = new LinkedList<>();
}
