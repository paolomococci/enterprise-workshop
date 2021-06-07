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

package local.example.capstone.data.service;

import local.example.capstone.data.entity.ContactEntity;
import local.example.capstone.data.repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public List<ContactEntity> readAll() {
        return (List<ContactEntity>) contactRepository.findAll();
    }

    public void create(ContactEntity contactEntity) {
        contactRepository.save(contactEntity);
    }

    public Optional<ContactEntity> read(Long id) {
        return contactRepository.findById(id);
    }

    public void update(ContactEntity updatedContactEntity, Long id) {
        Optional.of(contactRepository.findById(id).map(
                storedCarrierEntity -> {
                    if (updatedContactEntity.getFirstName() != null)
                        storedCarrierEntity.setFirstName(updatedContactEntity.getFirstName());
                    if (updatedContactEntity.getLastName() != null)
                        storedCarrierEntity.setLastName(updatedContactEntity.getLastName());
                    if (updatedContactEntity.getEmail() != null)
                        storedCarrierEntity.setEmail(updatedContactEntity.getEmail());
                    if (updatedContactEntity.getPhone() != null)
                        storedCarrierEntity.setPhone(updatedContactEntity.getPhone());
                    if (updatedContactEntity.getDateOfBirth() != null)
                        storedCarrierEntity.setDateOfBirth(updatedContactEntity.getDateOfBirth());
                    if (updatedContactEntity.getOccupation() != null)
                        storedCarrierEntity.setOccupation(updatedContactEntity.getOccupation());
                    if (updatedContactEntity.getImportant() != null)
                        storedCarrierEntity.setImportant(updatedContactEntity.getImportant());
                    return contactRepository.save(storedCarrierEntity);
                }).orElseGet(
                () -> {
                    return contactRepository.save(updatedContactEntity);
                }));
    }

    public void delete(Long id) {
        contactRepository.deleteById(id);
    }
}
