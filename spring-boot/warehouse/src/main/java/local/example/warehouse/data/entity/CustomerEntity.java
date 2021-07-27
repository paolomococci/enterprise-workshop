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

import local.example.warehause.data.AbstractCompany;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "customers")
public class CustomerEntity
        extends AbstractCompany {

    @OneToMany(mappedBy = "productCustomer", fetch = FetchType.LAZY)
    private List<ProductEntity> products = new LinkedList<>();

    @ManyToMany(mappedBy = "invoicesCustomers")
    private List<InvoiceEntity> invoices = new LinkedList<>();

    @ManyToMany(mappedBy = "contactsCustomers")
    private List<ContactEntity> contacts = new LinkedList<>();

    @ManyToMany(mappedBy = "addressesCustomers")
    private List<AddressEntity> addresses = new LinkedList<>();
}
