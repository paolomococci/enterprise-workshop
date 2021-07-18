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

import local.example.capstone.data.entity.OperatorEntity;
import local.example.capstone.data.repository.OperatorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperatorService {

    @Autowired
    OperatorRepository operatorRepository;

    public List<OperatorEntity> readAll() {
        return (List<OperatorEntity>) operatorRepository.findAll();
    }

    public List<OperatorEntity> readAll(PageRequest pageRequest) {
        return (List<OperatorEntity>) operatorRepository.findAll();
    }

    public void create(OperatorEntity operatorEntity) {
        operatorRepository.save(operatorEntity);
    }

    public Optional<OperatorEntity> read(Long id) {
        return operatorRepository.findById(id);
    }

    public void update(OperatorEntity updatedOperatorEntity, Long id) {
        Optional.of(operatorRepository.findById(id).map(
                storedOperatorEntity -> {
                    if (updatedOperatorEntity.getName() != null)
                        storedOperatorEntity.setName(updatedOperatorEntity.getName());
                    if (updatedOperatorEntity.getSurname() != null)
                        storedOperatorEntity.setSurname(updatedOperatorEntity.getSurname());
                    if (updatedOperatorEntity.getDateOfBirth() != null)
                        storedOperatorEntity.setDateOfBirth(updatedOperatorEntity.getDateOfBirth());
                    if (updatedOperatorEntity.getRole() != null)
                        storedOperatorEntity.setRole(updatedOperatorEntity.getRole());
                    if (updatedOperatorEntity.getPhoneNumber() != null)
                        storedOperatorEntity.setPhoneNumber(updatedOperatorEntity.getPhoneNumber());
                    if (updatedOperatorEntity.getContributoryIdentifier() != null)
                        storedOperatorEntity.setContributoryIdentifier(updatedOperatorEntity.getContributoryIdentifier());
                    if (updatedOperatorEntity.getEmail() != null)
                        storedOperatorEntity.setEmail(updatedOperatorEntity.getEmail());
                    return operatorRepository.save(storedOperatorEntity);
                }).orElseGet(
                () -> {
                    return operatorRepository.save(updatedOperatorEntity);
                }));
    }

    public void update(OperatorEntity updatedOperatorEntity) {
        this.update(updatedOperatorEntity, updatedOperatorEntity.getId());
    }

    public void delete(Long id) {
        operatorRepository.deleteById(id);
    }

    public void delete(OperatorEntity operatorEntity) {
        try {
            this.delete(operatorEntity.getId());
        } catch (Exception exception) {
            exception.getMessage();
        }
    }
}
