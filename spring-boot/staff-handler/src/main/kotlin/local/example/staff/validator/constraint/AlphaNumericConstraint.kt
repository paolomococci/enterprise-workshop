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

package local.example.staff.validator.constraint

import local.example.staff.validator.AlphaNumericValidator

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.validation.Constraint
import kotlin.reflect.KClass

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(AnnotationTarget.FIELD)
@Constraint(validatedBy = [AlphaNumericValidator::class])
annotation class AlphaNumericConstraint(
    val message: String = "local.example.staff.validator.constraint.AlphaNumericConstraint",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out javax.validation.Payload>> = []
)
