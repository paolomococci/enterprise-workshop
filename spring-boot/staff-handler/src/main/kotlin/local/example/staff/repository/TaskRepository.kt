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

import local.example.staff.entity.TaskEntity

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.transaction.annotation.Transactional

@RepositoryRestResource(path = "tasks", collectionResourceRel = "tasks")
interface TaskRepository : CrudRepository<TaskEntity, Long> {

    fun findByCode(@Param("code") code: String): List<TaskEntity>
    fun findByName(@Param("name") name: String): List<TaskEntity>

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE TASKS SET JOB_ID = :jobId WHERE ID = :taskId")
    fun assignToJob(@Param("jobId") jobId: Long, @Param("taskId") taskId: Long)

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE TASKS SET JOB_ID = NULL WHERE ID = :taskId")
    fun meltAssignmentToJob(@Param("taskId") taskId: Long)
}
