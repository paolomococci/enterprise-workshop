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

import local.example.staff.assembler.TaskRepresentationModelAssembler
import local.example.staff.entity.TaskEntity
import local.example.staff.exception.TaskNotFoundException
import local.example.staff.repository.TaskRepository

import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URISyntaxException

@RestController
@RequestMapping("/api/tasks")
class TaskRestfulController(
    private val taskRepository: TaskRepository,
    private val taskRepresentationModelAssembler: TaskRepresentationModelAssembler
) {

    @PostMapping
    @Throws(URISyntaxException::class)
    internal fun create(@RequestBody task: TaskEntity): ResponseEntity<EntityModel<TaskEntity>> {
        val taskRepresentationModel = taskRepresentationModelAssembler
            .toModel(taskRepository.save(task))
        return ResponseEntity<EntityModel<TaskEntity>>(
            taskRepresentationModel,
            HttpStatus.CREATED
        )
    }

    @GetMapping("/{id}")
    @Throws(URISyntaxException::class)
    internal fun read(@PathVariable id: Long?): EntityModel<TaskEntity> {
        val task = taskRepository.findById(id!!)
            .orElseThrow { TaskNotFoundException(id) }
        return taskRepresentationModelAssembler.toModel(task)
    }

    @GetMapping("/code/{code}")
    @Throws(URISyntaxException::class)
    internal fun searchByCode(@PathVariable code: String?): CollectionModel<EntityModel<TaskEntity>> {
        val tasks = taskRepository.findByCode(code!!)
            .asSequence()
            .map(taskRepresentationModelAssembler::toModel).toList()
        return CollectionModel.of(tasks,
            linkTo(methodOn(TaskRestfulController::class.java).searchByCode(code)).withSelfRel())
    }

    @GetMapping("/name/{name}")
    @Throws(URISyntaxException::class)
    internal fun searchByName(@PathVariable name: String?): CollectionModel<EntityModel<TaskEntity>> {
        val tasks = taskRepository.findByName(name!!)
            .asSequence()
            .map(taskRepresentationModelAssembler::toModel).toList()
        return CollectionModel.of(tasks,
            linkTo(methodOn(TaskRestfulController::class.java).searchByName(name)).withSelfRel())
    }

    @GetMapping
    @Throws(URISyntaxException::class)
    internal fun readAll(): CollectionModel<EntityModel<TaskEntity>> {
        val tasks = taskRepository.findAll()
            .asSequence()
            .map(taskRepresentationModelAssembler::toModel).toList()
        return CollectionModel.of(tasks,
            linkTo(methodOn(TaskRestfulController::class.java).readAll()).withSelfRel())
    }

    @PutMapping("/{id}")
    @Throws(URISyntaxException::class)
    internal fun update(@RequestBody update: TaskEntity, @PathVariable id: Long?): ResponseEntity<*> {
        val updated = taskRepository.findById(id!!)
            .map { temp ->
                temp.code = update.code
                temp.name = update.name
                taskRepository.save(temp)
            }
            .orElseGet {
                taskRepository.save(update)
            }
        val taskRepresentationModel = taskRepresentationModelAssembler.toModel(updated)
        return ResponseEntity<EntityModel<TaskEntity>>(
            taskRepresentationModel,
            HttpStatus.OK
        )
    }

    @PatchMapping("/{id}")
    @Throws(URISyntaxException::class)
    internal fun partialUpdate(@RequestBody update: TaskEntity, @PathVariable id: Long?): ResponseEntity<*> {
        val updated = taskRepository.findById(id!!)
            .map { temp ->
                if (!update.code.isNullOrBlank()) temp.code = update.code
                if (!update.name.isNullOrBlank()) temp.name = update.name
                taskRepository.save(temp)
            }
            .orElseGet {
                taskRepository.save(update)
            }
        val taskRepresentationModel = taskRepresentationModelAssembler.toModel(updated)
        return ResponseEntity<EntityModel<TaskEntity>>(
            taskRepresentationModel,
            HttpStatus.OK
        )
    }

    @DeleteMapping("/{id}")
    @Throws(URISyntaxException::class)
    internal fun delete(@PathVariable id: Long?): ResponseEntity<*> {
        if (id != null) taskRepository.deleteById(id)
        return ResponseEntity.noContent().build<Any>()
    }
}
