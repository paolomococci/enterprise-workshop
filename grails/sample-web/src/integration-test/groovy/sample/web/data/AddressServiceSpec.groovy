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
class AddressServiceSpec
        extends Specification {

    AddressService addressService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Address(...).save(flush: true, failOnError: true)
        //new Address(...).save(flush: true, failOnError: true)
        //Address address = new Address(...).save(flush: true, failOnError: true)
        //new Address(...).save(flush: true, failOnError: true)
        //new Address(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //address.id
    }

    void "test get"() {
        setupData()

        expect:
        addressService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Address> addressList = addressService.list(max: 2, offset: 2)

        then:
        addressList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        addressService.count() == 5
    }

    void "test delete"() {
        Long addressId = setupData()

        expect:
        addressService.count() == 5

        when:
        addressService.delete(addressId)
        sessionFactory.currentSession.flush()

        then:
        addressService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Address address = new Address()
        addressService.save(address)

        then:
        address.id != null
    }
}
