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
class CarrierServiceSpec
        extends Specification {

    CarrierService carrierService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Carrier(...).save(flush: true, failOnError: true)
        //new Carrier(...).save(flush: true, failOnError: true)
        //Carrier carrier = new Carrier(...).save(flush: true, failOnError: true)
        //new Carrier(...).save(flush: true, failOnError: true)
        //new Carrier(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //carrier.id
    }

    void "test get"() {
        setupData()

        expect:
        carrierService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Carrier> carrierList = carrierService.list(max: 2, offset: 2)

        then:
        carrierList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        carrierService.count() == 5
    }

    void "test delete"() {
        Long carrierId = setupData()

        expect:
        carrierService.count() == 5

        when:
        carrierService.delete(carrierId)
        sessionFactory.currentSession.flush()

        then:
        carrierService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Carrier carrier = new Carrier()
        carrierService.save(carrier)

        then:
        carrier.id != null
    }
}
