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

package local.example.said.data.repository;

import local.example.said.data.model.Customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository
        extends CrudRepository<Customer, Long> {

    @Query(
            nativeQuery = true,
            value = "SELECT c FROM customer WHERE LOWER(c.firstName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(c.lastName) LIKE LOWER(CONCAT('%', :searchTerm, '%'))"
    )
    List<Customer> search(@Param("searchTerm") String searchTerm);
}
