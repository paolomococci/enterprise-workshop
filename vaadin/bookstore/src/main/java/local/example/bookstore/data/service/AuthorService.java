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

package local.example.bookstore.data.service;

import local.example.bookstore.data.entity.AuthorEntity;
import local.example.bookstore.data.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public List<AuthorEntity> readAll() {
        return (List<AuthorEntity>) authorRepository.findAll();
    }

    public List<AuthorEntity> readAll(PageRequest pageRequest) {
        return (List<AuthorEntity>) authorRepository.findAll();
    }

    public void create(AuthorEntity addressEntity) {
        authorRepository.save(addressEntity);
    }

    public Optional<AuthorEntity> read(Long id) {
        return authorRepository.findById(id);
    }

    public void update(AuthorEntity updatedAuthorEntity, Long id) {
        Optional.of(authorRepository.findById(id).map(
                storedAuthorEntity -> {
                    if (updatedAuthorEntity.getName() != null)
                        storedAuthorEntity.setName(updatedAuthorEntity.getName());
                    if (updatedAuthorEntity.getSurname() != null)
                        storedAuthorEntity.setSurname(updatedAuthorEntity.getSurname());
                    if (updatedAuthorEntity.getAlias() != null)
                        storedAuthorEntity.setAlias(updatedAuthorEntity.getAlias());
                    if (updatedAuthorEntity.getBirthday() != null)
                        storedAuthorEntity.setBirthday(updatedAuthorEntity.getBirthday());
                    if (updatedAuthorEntity.getEmail() != null)
                        storedAuthorEntity.setEmail(updatedAuthorEntity.getEmail());
                    if (updatedAuthorEntity.getActive() != null)
                        storedAuthorEntity.setActive(updatedAuthorEntity.getActive());
                    return authorRepository.save(storedAuthorEntity);
                }).orElseGet(
                () -> {
                    return authorRepository.save(updatedAuthorEntity);
                }));
    }

    public void update(AuthorEntity updatedAuthorEntity) {
        this.update(updatedAuthorEntity, updatedAuthorEntity.getId());
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    public void delete(AuthorEntity addressEntity) {
        try {
            this.delete(addressEntity.getId());
        } catch (Exception exception) {
            exception.getMessage();
        }
    }
}
