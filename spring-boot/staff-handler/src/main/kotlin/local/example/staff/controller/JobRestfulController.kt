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
import local.example.staff.exception.JobNotFoundException
import local.example.staff.repository.JobRepository

import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
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
        val jobRepresentationModel = jobRepresentationModelAssembler.toModel(jobRepository.save(job))
        return ResponseEntity.created(URI(jobRepresentationModel.links.toString())).body(jobRepresentationModel)
    }

    @GetMapping("/{id}")
    @Throws(URISyntaxException::class)
    internal fun read(@PathVariable id: Long?): EntityModel<JobEntity> {
        val job = jobRepository.findById(id!!)
            .orElseThrow { JobNotFoundException(id) }
        return jobRepresentationModelAssembler.toModel(job)
    }

    @GetMapping("/code/{code}")
    @Throws(URISyntaxException::class)
    internal fun searchByCode(@PathVariable code: String?): CollectionModel<EntityModel<JobEntity>> {
        val jobs = jobRepository.findByCode(code!!)
            .asSequence()
            .map(jobRepresentationModelAssembler::toModel).toList()
        return CollectionModel.of(jobs,
            linkTo(methodOn(JobRestfulController::class.java).searchByCode(code)).withSelfRel())
    }

    @GetMapping("/name/{name}")
    @Throws(URISyntaxException::class)
    internal fun searchByName(@PathVariable name: String?): CollectionModel<EntityModel<JobEntity>> {
        val jobs = jobRepository.findByName(name!!)
            .asSequence()
            .map(jobRepresentationModelAssembler::toModel).toList()
        return CollectionModel.of(jobs,
            linkTo(methodOn(JobRestfulController::class.java).searchByName(name)).withSelfRel())
    }

    @GetMapping
    @Throws(URISyntaxException::class)
    internal fun readAll(): CollectionModel<EntityModel<JobEntity>> {
        return CollectionModel.empty()
    }

    @PutMapping("/{id}")
    @Throws(URISyntaxException::class)
    internal fun update(@RequestBody update: JobEntity, @PathVariable id: Long?): ResponseEntity<*> {
        return ResponseEntity.ok(HttpStatus.NOT_IMPLEMENTED)
    }

    @PatchMapping("/{id}")
    @Throws(URISyntaxException::class)
    internal fun partialUpdate(@RequestBody update: JobEntity, @PathVariable id: Long?): ResponseEntity<*> {
        return ResponseEntity.ok(HttpStatus.NOT_IMPLEMENTED)
    }

    @DeleteMapping("/{id}")
    @Throws(URISyntaxException::class)
    internal fun delete(@PathVariable id: Long?): ResponseEntity<*> {
        return ResponseEntity.ok(HttpStatus.NOT_IMPLEMENTED)
    }
}
