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

package sample.vue.data

class Supplier {

    String code
    String name
    String compartment

    static hasManyItems = [items: Item]
    static hasManyInvoices = [invoices: Invoice]
    static hasManyAddresses = [addresses: Address]

    static constraints = {
        code size: 8..32, blank: false, unique: true
        name size: 2..32, blank: false
        compartment size: 2..32, nullable: true
    }

    String toString() {
        code
    }
}
