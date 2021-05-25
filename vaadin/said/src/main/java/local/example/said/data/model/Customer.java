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

package local.example.said.data.model;

import local.example.said.data.AbstractData;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Customer
        extends AbstractData {

    @NotNull
    @Size(min = 1, max = 20, message = "size range of this field is 1 to 20 characters")
    @Pattern(
            regexp = "^[a-zA-Z_-]*$",
            message = "only the characters `a-z`, `A-Z`, `_` and `-` are allowed"
    )
    private String firstName;

    @NotNull
    @Size(min = 1, max = 20, message = "size range of this field is 1 to 20 characters")
    @Pattern(
            regexp = "^[a-zA-Z_-]*$",
            message = "only the characters `a-z`, `A-Z`, `_` and `-` are allowed"
    )
    private String lastName;

    @Email
    private String email;

    @NotNull
    @Size(min = 6, max = 20, message = "size range of this field is 6 to 20 characters")
    @Pattern(
            regexp = "^[0-9-]*$",
            message = "only the characters `0-9` `-` are allowed"
    )
    private String phone;

    private LocalDate dateOfBirth;

    @NotNull
    @Size(min = 3, max = 50, message = "size range of this field is 3 to 50 characters")
    @Pattern(
            regexp = "^[a-zA-Z_-]*$",
            message = "only the characters `a-z`, `A-Z`, `_` and `-` are allowed"
    )
    private String occupation;

    private boolean important;
}
