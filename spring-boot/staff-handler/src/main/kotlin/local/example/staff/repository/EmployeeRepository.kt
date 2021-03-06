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

package local.example.staff.repository

import local.example.staff.entity.EmployeeEntity

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.transaction.annotation.Transactional

@RepositoryRestResource(path = "employees", collectionResourceRel = "employees")
interface EmployeeRepository : CrudRepository<EmployeeEntity, Long> {

    fun findByName(@Param("name") name: String): List<EmployeeEntity>
    fun findBySurname(@Param("surname") surname: String): List<EmployeeEntity>

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE EMPLOYEES SET TASK_ID = :taskId WHERE ID = :employeeId")
    fun assignToTask(@Param("taskId") taskId: Long, @Param("employeeId") employeeId: Long)

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE EMPLOYEES SET TASK_ID = NULL WHERE ID = :employeeId")
    fun meltAssignmentToTask(@Param("employeeId") employeeId: Long)
}
