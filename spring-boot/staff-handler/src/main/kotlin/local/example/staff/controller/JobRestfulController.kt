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

package local.example.staff.controller

import local.example.staff.assembler.JobRepresentationModelAssembler
import local.example.staff.entity.JobEntity
import local.example.staff.repository.JobRepository

import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.EntityModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URISyntaxException

@RestController
@RequestMapping("/api/jobs")
class JobRestfulController(
    private val jobRepository: JobRepository,
    private val jobRepresentationModelAssembler: JobRepresentationModelAssembler
) {

    @PostMapping
    @Throws(URISyntaxException::class)
    internal fun create(@RequestBody job: JobEntity): ResponseEntity<EntityModel<JobEntity>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @GetMapping("/{id}")
    @Throws(URISyntaxException::class)
    internal fun read(@PathVariable id: Long?): EntityModel<JobEntity> {
        return EntityModel.of(JobEntity())
    }

    @GetMapping("/code/{code}")
    @Throws(URISyntaxException::class)
    internal fun searchByCode(@PathVariable code: String?): CollectionModel<EntityModel<JobEntity>> {
        return CollectionModel.empty()
    }

    @GetMapping("/name/{name}")
    @Throws(URISyntaxException::class)
    internal fun searchByName(@PathVariable name: String?): CollectionModel<EntityModel<JobEntity>> {
        return CollectionModel.empty()
    }
}
