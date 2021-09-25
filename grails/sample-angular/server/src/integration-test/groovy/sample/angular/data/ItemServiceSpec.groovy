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

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback

import org.grails.datastore.mapping.core.Datastore
import org.springframework.beans.factory.annotation.Autowired

import spock.lang.Specification

@Integration
@Rollback
class ItemServiceSpec
        extends Specification {

    ItemService itemService
    @Autowired Datastore datastore

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Item(...).save(flush: true, failOnError: true)
        //new Item(...).save(flush: true, failOnError: true)
        //Item item = new Item(...).save(flush: true, failOnError: true)
        //new Item(...).save(flush: true, failOnError: true)
        //new Item(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //item.id
    }

    void cleanup() {
        assert false, "TODO: Provide a cleanup implementation if using MongoDB"
    }

    void "test get"() {
        setupData()

        expect:
        itemService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Item> itemList = itemService.list(max: 2, offset: 2)

        then:
        itemList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        itemService.count() == 5
    }

    void "test delete"() {
        Long itemId = setupData()

        expect:
        itemService.count() == 5

        when:
        itemService.delete(itemId)
        datastore.currentSession.flush()

        then:
        itemService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Item item = new Item()
        itemService.save(item)

        then:
        item.id != null
    }
}
