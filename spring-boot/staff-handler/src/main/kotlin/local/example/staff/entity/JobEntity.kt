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
import javax.validation.constraints.Size

@Entity
@Table(name = "JOBS", uniqueConstraints = [UniqueConstraint(columnNames = ["CODE","NAME"])])
data class JobEntity(
    @Id
    @GeneratedValue
    @Column(name = "ID")
    val id: Long? = null,
    @Size(min = 8, max = 124)
    @Column(name = "CODE", nullable = false, columnDefinition = "VARCHAR(128)")
    var code: String,
    @Size(min = 11, max = 127)
    @Column(name = "NAME", nullable = false, columnDefinition = "VARCHAR(128)")
    var name: String
) {
    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
    lateinit var tasks: List<TaskEntity>
}
