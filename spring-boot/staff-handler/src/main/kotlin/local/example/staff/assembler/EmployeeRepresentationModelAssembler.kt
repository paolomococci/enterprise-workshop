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

package local.example.staff.assembler

import local.example.staff.controller.EmployeeRestfulController
import local.example.staff.entity.EmployeeEntity

import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.RepresentationModelAssembler
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
import org.springframework.stereotype.Component

@Component
class EmployeeRepresentationModelAssembler :
    RepresentationModelAssembler<EmployeeEntity, EntityModel<EmployeeEntity>> {

    override fun toModel(employeeEntity: EmployeeEntity): EntityModel<EmployeeEntity> {
        return EntityModel.of(employeeEntity,
            linkTo(methodOn(EmployeeRestfulController::class.java).read(employeeEntity.id)).withSelfRel(),
            linkTo(methodOn(EmployeeRestfulController::class.java).readAll()).withRel("employees")
        )
    }
}
