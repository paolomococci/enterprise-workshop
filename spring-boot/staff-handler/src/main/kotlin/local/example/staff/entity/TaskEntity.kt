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

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "tasks")
class TaskEntity {

    @Id
    @GeneratedValue
    val id: Long? = null

    var code: String? = null
    var name: String? = null

    @JsonIgnore
    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
    lateinit var employees: List<EmployeeEntity>

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "job_id")
    lateinit var job: JobEntity
}
