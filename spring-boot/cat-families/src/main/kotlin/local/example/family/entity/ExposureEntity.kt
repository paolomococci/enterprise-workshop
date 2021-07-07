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

@Entity(name = "exposures")
@Table(name = "exposures")
data class ExposureEntity(
    @Id
    @GeneratedValue
    open val id: Long,
    open val code: String,
    open val title: String,
    @JsonFormat(pattern = "YYYY-MM-dd")
    open val occurrence: Date
) {
    @ManyToMany(mappedBy = "exposures")
    lateinit var breeders: List<BreederEntity>
}
