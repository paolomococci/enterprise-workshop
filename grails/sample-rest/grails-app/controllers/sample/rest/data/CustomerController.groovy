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

package sample.rest.data

import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class CustomerController {

    CustomerService customerService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerService.list(params), model:[customerCount: customerService.count()]
    }

    def show(Long id) {
        respond customerService.get(id)
    }

    @Transactional
    def save(Customer customer) {
        if (customer == null) {
            render status: NOT_FOUND
            return
        }
        if (customer.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customer.errors
            return
        }

        try {
            customerService.save(customer)
        } catch (ValidationException validationException) {
            respond customer.errors
            return
        }

        respond customer, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Customer customer) {
        if (customer == null) {
            render status: NOT_FOUND
            return
        }
        if (customer.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customer.errors
            return
        }

        try {
            customerService.save(customer)
        } catch (ValidationException validationException) {
            respond customer.errors
            return
        }

        respond customer, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null || customerService.delete(id) == null) {
            render status: NOT_FOUND
            return
        }

        render status: NO_CONTENT
    }
}
