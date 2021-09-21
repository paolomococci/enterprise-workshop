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

package sample.react.data

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback

import org.grails.datastore.mapping.core.Datastore
import org.springframework.beans.factory.annotation.Autowired

import spock.lang.Specification

@Integration
@Rollback
class SupplierServiceSpec
        extends Specification {

    SupplierService supplierService
    @Autowired Datastore datastore

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Supplier(...).save(flush: true, failOnError: true)
        //new Supplier(...).save(flush: true, failOnError: true)
        //Supplier supplier = new Supplier(...).save(flush: true, failOnError: true)
        //new Supplier(...).save(flush: true, failOnError: true)
        //new Supplier(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //supplier.id
    }

    void cleanup() {
        assert false, "TODO: Provide a cleanup implementation if using MongoDB"
    }

    void "test get"() {
        setupData()

        expect:
        supplierService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Supplier> supplierList = supplierService.list(max: 2, offset: 2)

        then:
        supplierList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        supplierService.count() == 5
    }

    void "test delete"() {
        Long supplierId = setupData()

        expect:
        supplierService.count() == 5

        when:
        supplierService.delete(supplierId)
        datastore.currentSession.flush()

        then:
        supplierService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Supplier supplier = new Supplier()
        supplierService.save(supplier)

        then:
        supplier.id != null
    }
}
