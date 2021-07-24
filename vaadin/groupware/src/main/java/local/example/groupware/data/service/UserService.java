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

package local.example.groupware.data.service;

import local.example.groupware.data.entity.User;
import local.example.groupware.data.helper.RepositoryHelper;
import local.example.groupware.data.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService
        extends RepositoryHelper<User, Long> {

    private UserRepository repository;

    public UserService(
            @Autowired UserRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    protected JpaRepository<User, Long> getRepository() {
        return this.repository;
    }
}
