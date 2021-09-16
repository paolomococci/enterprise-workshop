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

import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class CarrierController {

    CarrierService carrierService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond carrierService.list(params), model:[carrierCount: carrierService.count()]
    }

    def show(Long id) {
        respond carrierService.get(id)
    }

    @Transactional
    def save(Carrier carrier) {
        if (carrier == null) {
            render status: NOT_FOUND
            return
        }
        if (carrier.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond carrier.errors
            return
        }

        try {
            carrierService.save(carrier)
        } catch (ValidationException e) {
            respond carrier.errors
            return
        }

        respond carrier, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Carrier carrier) {
        if (carrier == null) {
            render status: NOT_FOUND
            return
        }
        if (carrier.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond carrier.errors
            return
        }

        try {
            carrierService.save(carrier)
        } catch (ValidationException e) {
            respond carrier.errors
            return
        }

        respond carrier, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null || carrierService.delete(id) == null) {
            render status: NOT_FOUND
            return
        }

        render status: NO_CONTENT
    }
}
