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

package local.example.warehause.data.service;

import local.example.warehause.data.entity.ComponentEntity;
import local.example.warehause.data.repository.ComponentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentService {

    @Autowired
    ComponentRepository componentRepository;

    public List<ComponentEntity> readAll() {
        return (List<ComponentEntity>) componentRepository.findAll();
    }

    public List<ComponentEntity> readAll(PageRequest pageRequest) {
        return (List<ComponentEntity>) componentRepository.findAll();
    }

    public void create(ComponentEntity componentEntity) {
        componentRepository.save(componentEntity);
    }

    public Optional<ComponentEntity> read(Long id) {
        return componentRepository.findById(id);
    }

    public void update(ComponentEntity updatedComponentEntity, Long id) {
        Optional.of(componentRepository.findById(id).map(
                storedComponentEntity -> {
                    if (updatedComponentEntity.getCode() != null)
                        storedComponentEntity.setCode(updatedComponentEntity.getCode());
                    if (updatedComponentEntity.getAmount() != null)
                        storedComponentEntity.setAmount(updatedComponentEntity.getAmount());
                    return componentRepository.save(storedComponentEntity);
                }).orElseGet(
                () -> {
                    return componentRepository.save(updatedComponentEntity);
                }));
    }

    public void update(ComponentEntity updatedComponentEntity) {
        this.update(updatedComponentEntity, updatedComponentEntity.getId());
    }

    public void delete(Long id) {
        componentRepository.deleteById(id);
    }

    public void delete(ComponentEntity componentEntity) {
        try {
            this.delete(componentEntity.getId());
        } catch (Exception exception) {
            exception.getMessage();
        }
    }
}
