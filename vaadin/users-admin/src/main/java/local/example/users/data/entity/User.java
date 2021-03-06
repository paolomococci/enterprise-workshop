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

package local.example.users.data.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.FetchType;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
@EqualsAndHashCode(callSuper=false)
public class User
        extends AbstractUser {

    private String username;
    private String name;
    private String hashedPassword;

    @ElementCollection(fetch = FetchType.LAZY)
    private Set<Role> roles;

    @Lob
    private String profilePictureUrl;
}
