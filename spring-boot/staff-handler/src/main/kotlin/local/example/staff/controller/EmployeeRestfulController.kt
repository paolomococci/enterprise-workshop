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
import local.example.staff.repository.EmployeeRepository

import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.EntityModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
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
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @GetMapping("/{id}")
    @Throws(URISyntaxException::class)
    internal fun read(@PathVariable id: Long?): EntityModel<EmployeeEntity> {
        return EntityModel.of(EmployeeEntity())
    }

    @GetMapping("/name/{name}")
    @Throws(URISyntaxException::class)
    internal fun searchByName(@PathVariable name: String?): CollectionModel<EntityModel<EmployeeEntity>> {
        return CollectionModel.empty()
    }

    @GetMapping("/surname/{surname}")
    @Throws(URISyntaxException::class)
    internal fun searchBySurname(@PathVariable surname: String?): CollectionModel<EntityModel<EmployeeEntity>> {
        return CollectionModel.empty()
    }

    @GetMapping
    @Throws(URISyntaxException::class)
    internal fun readAll(): CollectionModel<EntityModel<EmployeeEntity>> {
        return CollectionModel.empty()
    }

    @PutMapping("/{id}")
    @Throws(URISyntaxException::class)
    internal fun update(@RequestBody update: EmployeeEntity, @PathVariable id: Long?): ResponseEntity<*> {
        return ResponseEntity.ok(HttpStatus.NOT_IMPLEMENTED)
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
