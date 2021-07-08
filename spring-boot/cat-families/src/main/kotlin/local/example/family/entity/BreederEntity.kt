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
import java.sql.Date
import javax.persistence.*

@Entity(name = "breeders")
@Table(name = "breeders")
data class BreederEntity(
    @Id
    @GeneratedValue
    var id: Long,
    var code: String,
    var name: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-YYYY")
    val birthday: Date
) {
    @OneToMany(mappedBy = "breederCat", fetch = FetchType.LAZY)
    lateinit var cats: List<SonEntity>

    @OneToMany(mappedBy = "breederMotherCat", fetch = FetchType.LAZY)
    lateinit var motherCats: List<MotherEntity>

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinTable(
        name = "exposure_breeder",
        joinColumns = [JoinColumn(name = "exposure_fk", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "breeder_fk", referencedColumnName = "id")])
    lateinit var exposures: List<ExposureEntity>
}
