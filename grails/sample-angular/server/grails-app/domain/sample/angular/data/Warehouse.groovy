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


import grails.rest.*

@Resource(
        readOnly = false,
        formats = ['json', 'xml'],
        uri = '/api/warehouse'
)
class Warehouse {

    String code
    String name

    Address address

    static hasOne = [address: Address]
    static belongsTo = [employee: Employee]

    static constraints = {
        code size: 8..32, blank: false, unique: true
        name size: 2..32, blank: false
        address unique: true, nullable: true
    }

    String toString() {
        code
    }
}
