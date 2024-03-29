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

package local.example.users.data.endpoint;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import local.example.users.data.entity.User;
import local.example.users.data.security.auth.UserAuth;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@AnonymousAllowed
public class UserEndpoint {

    @Autowired
    private UserAuth userAuth;

    public Optional<User> getOptionalUserAuth() {
        return this.userAuth.get();
    }
}
