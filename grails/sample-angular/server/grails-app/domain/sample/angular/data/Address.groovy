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

package sample.angular.data

class Address {

    String code
    String country
    String location
    String street
    String civic

    static belongsTo = [
            customer: Customer,
            supplier: Supplier,
            warehouse: Warehouse
    ]

    static constraints = {
        code size: 8..32, blank: false, unique: true
        country size: 2..32, nullable: true
        location size: 2..32, nullable: true
        street size: 2..32, nullable: true
        civic size: 1..8, nullable: true
    }

    String toString() {
        code
    }
}
