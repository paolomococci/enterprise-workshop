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

package sample.web.data

import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.*

class CarrierController {

    CarrierService carrierService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond carrierService.list(params), model:[carrierCount: carrierService.count()]
    }

    def show(Long id) {
        respond carrierService.get(id)
    }

    def create() {
        respond new Carrier(params)
    }

    def save(Carrier carrier) {
        if (carrier == null) {
            notFound()
            return
        }

        try {
            carrierService.save(carrier)
        } catch (ValidationException e) {
            respond carrier.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'carrier.label', default: 'Carrier'), carrier.id])
                redirect carrier
            }
            '*' { respond carrier, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond carrierService.get(id)
    }

    def update(Carrier carrier) {
        if (carrier == null) {
            notFound()
            return
        }

        try {
            carrierService.save(carrier)
        } catch (ValidationException e) {
            respond carrier.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'carrier.label', default: 'Carrier'), carrier.id])
                redirect carrier
            }
            '*'{ respond carrier, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        carrierService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'carrier.label', default: 'Carrier'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'carrier.label', default: 'Carrier'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
