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

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@Table(name = "addresses")
@EqualsAndHashCode(callSuper=false)
public class AddressEntity
        extends AbstractEntity {

    private String street;
    private String postalCode;
    private String city;
    private String state;
    private String country;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "address_carrier",
            joinColumns = { @JoinColumn(name = "address_id") },
            inverseJoinColumns = { @JoinColumn(name = "carrier_id") }
    )
    private List<CarrierEntity> addressesCarriers = new LinkedList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "address_supplier",
            joinColumns = { @JoinColumn(name = "address_id") },
            inverseJoinColumns = { @JoinColumn(name = "supplier_id") }
    )
    private List<SupplierEntity> addressesSuppliers = new LinkedList<>();
}
