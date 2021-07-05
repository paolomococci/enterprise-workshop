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

package local.example.staff.entity

import javax.persistence.*

@Entity
@Table(name = "EMPLOYEES")
data class EmployeeEntity(
    @Id
    @GeneratedValue
    @Column(name = "ID")
    val id: Long? = null,
    @Column(name = "NAME")
    var name: String? = null,
    @Column(name = "SURNAME")
    var surname: String? = null
) {
    @Column(name = "TASK")
    @ManyToOne
    @JoinColumn(name = "task_id")
    lateinit var task: TaskEntity
}
