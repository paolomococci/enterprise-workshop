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

import local.example.staff.assembler.EmployeeRepresentationModelAssembler
import local.example.staff.entity.EmployeeEntity
import local.example.staff.exception.EmployeeNotFoundException
import local.example.staff.repository.EmployeeRepository

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
@RequestMapping("/api/employees")
class EmployeeRestfulController(
    private val employeeRepository: EmployeeRepository,
    private val employeeRepresentationModelAssembler: EmployeeRepresentationModelAssembler
) {

    @PostMapping
    @Throws(URISyntaxException::class)
    internal fun create(@RequestBody employee: EmployeeEntity): ResponseEntity<EntityModel<EmployeeEntity>> {
        val employeeRepresentationModel = employeeRepresentationModelAssembler.toModel(employeeRepository.save(employee))
        return ResponseEntity.created(URI(employeeRepresentationModel.links.toString())).body(employeeRepresentationModel)
    }

    @GetMapping("/{id}")
    @Throws(URISyntaxException::class)
    internal fun read(@PathVariable id: Long?): EntityModel<EmployeeEntity> {
        val employee = employeeRepository.findById(id!!)
            .orElseThrow { EmployeeNotFoundException(id) }
        return employeeRepresentationModelAssembler.toModel(employee)
    }

    @GetMapping("/name/{name}")
    @Throws(URISyntaxException::class)
    internal fun searchByName(@PathVariable name: String?): CollectionModel<EntityModel<EmployeeEntity>> {
        val employee = employeeRepository.findByName(name!!)
            .asSequence()
            .map(employeeRepresentationModelAssembler::toModel).toList()
        return CollectionModel.of(employee,
            linkTo(methodOn(EmployeeRestfulController::class.java).searchByName(name)).withSelfRel())
    }

    @GetMapping("/surname/{surname}")
    @Throws(URISyntaxException::class)
    internal fun searchBySurname(@PathVariable surname: String?): CollectionModel<EntityModel<EmployeeEntity>> {
        val employee = employeeRepository.findByName(surname!!)
            .asSequence()
            .map(employeeRepresentationModelAssembler::toModel).toList()
        return CollectionModel.of(employee,
            linkTo(methodOn(EmployeeRestfulController::class.java).searchBySurname(surname)).withSelfRel())
    }

    @GetMapping
    @Throws(URISyntaxException::class)
    internal fun readAll(): CollectionModel<EntityModel<EmployeeEntity>> {
        val employees = employeeRepository.findAll()
            .asSequence()
            .map(employeeRepresentationModelAssembler::toModel).toList()
        return CollectionModel.of(employees,
            linkTo(methodOn(EmployeeRestfulController::class.java).readAll()).withSelfRel())
    }

    @PutMapping("/{id}")
    @Throws(URISyntaxException::class)
    internal fun update(@RequestBody update: EmployeeEntity, @PathVariable id: Long?): ResponseEntity<*> {
        val updated = employeeRepository.findById(id!!)
            .map { temp ->
                temp.name = update.name
                temp.surname = update.surname
                employeeRepository.save(temp)
            }
            .orElseGet {
                employeeRepository.save(update)
            }
        val employeeRepresentationModel = employeeRepresentationModelAssembler.toModel(updated)
        return ResponseEntity
            .created(URI(employeeRepresentationModel.links.toString()))
            .body(employeeRepresentationModel)
    }

    @PatchMapping("/{id}")
    @Throws(URISyntaxException::class)
    internal fun partialUpdate(@RequestBody update: EmployeeEntity, @PathVariable id: Long?): ResponseEntity<*> {
        return ResponseEntity.ok(HttpStatus.NOT_IMPLEMENTED)
    }

    @DeleteMapping("/{id}")
    @Throws(URISyntaxException::class)
    internal fun delete(@PathVariable id: Long?): ResponseEntity<*> {
        return ResponseEntity.ok(HttpStatus.NOT_IMPLEMENTED)
    }
}
