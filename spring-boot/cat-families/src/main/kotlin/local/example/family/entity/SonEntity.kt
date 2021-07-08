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

@Entity(name = "sons")
@Table(name = "sons")
data class SonEntity(
    @Id
    @GeneratedValue
    var id: Long,
    var code: String,
    var name: String,
    @Enumerated(EnumType.STRING)
    var level: Level,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-YYYY", timezone = "UTC")
    val birthday: Date
) {
    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "mother_fk")
    lateinit var mother: MotherEntity

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "breeder_fk")
    lateinit var breederCat: BreederEntity
}
