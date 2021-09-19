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

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback

import spock.lang.Specification

import org.hibernate.SessionFactory

@Integration
@Rollback
class CustomerServiceSpec
        extends Specification {

    CustomerService customerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Customer(...).save(flush: true, failOnError: true)
        //new Customer(...).save(flush: true, failOnError: true)
        //Customer customer = new Customer(...).save(flush: true, failOnError: true)
        //new Customer(...).save(flush: true, failOnError: true)
        //new Customer(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //customer.id
    }

    void "test get"() {
        setupData()

        expect:
        customerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Customer> customerList = customerService.list(max: 2, offset: 2)

        then:
        customerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        customerService.count() == 5
    }

    void "test delete"() {
        Long customerId = setupData()

        expect:
        customerService.count() == 5

        when:
        customerService.delete(customerId)
        sessionFactory.currentSession.flush()

        then:
        customerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Customer customer = new Customer()
        customerService.save(customer)

        then:
        customer.id != null
    }
}
