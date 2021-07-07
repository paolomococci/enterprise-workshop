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

package local.example.family.entity

import com.fasterxml.jackson.annotation.JsonFormat

import local.example.family.fineness.Level

import java.sql.Date
import javax.persistence.*

@Entity(name = "mothers")
@Table(name = "mothers")
data class MotherEntity(
    @Id
    @GeneratedValue
    val id: Long,
    val code: String,
    val name: String,
    @Enumerated(EnumType.STRING)
    val level: Level,
    @JsonFormat(pattern = "YYYY-MM-dd")
    val birthday: Date
) {
    @OneToMany(mappedBy = "mother", fetch = FetchType.LAZY)
    lateinit var sons: List<SonEntity>

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "breeder_fk")
    lateinit var breederMotherCat: BreederEntity
}
