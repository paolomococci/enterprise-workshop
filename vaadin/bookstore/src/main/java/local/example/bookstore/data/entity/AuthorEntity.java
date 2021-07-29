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

package local.example.bookstore.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.time.LocalDate;

@Data
@Entity(name = "authors")
@Table(name = "AUTHOR")
public class AuthorEntity
        extends AbstractEntity {

    private String name;
    private String surname;
    private String alias;
    private String username;
    private LocalDate birthday;
    private String email;
    private boolean active;
}
