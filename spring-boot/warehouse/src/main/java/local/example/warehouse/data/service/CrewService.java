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

import local.example.warehause.data.entity.CrewEntity;
import local.example.warehause.data.repository.CrewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrewService {

    @Autowired
    CrewRepository crewRepository;

    public List<CrewEntity> readAll() {
        return (List<CrewEntity>) crewRepository.findAll();
    }

    public List<CrewEntity> readAll(PageRequest pageRequest) {
        return (List<CrewEntity>) crewRepository.findAll();
    }

    public void create(CrewEntity crewEntity) {
        crewRepository.save(crewEntity);
    }

    public Optional<CrewEntity> read(Long id) {
        return crewRepository.findById(id);
    }

    public void update(CrewEntity updatedCrewEntity, Long id) {
        Optional.of(crewRepository.findById(id).map(
                storedCrewEntity -> {
                    if (updatedCrewEntity.getCode() != null)
                        storedCrewEntity.setCode(updatedCrewEntity.getCode());
                    if (updatedCrewEntity.getName() != null)
                        storedCrewEntity.setName(updatedCrewEntity.getCode());
                    return crewRepository.save(storedCrewEntity);
                }).orElseGet(
                () -> {
                    return crewRepository.save(updatedCrewEntity);
                }));
    }

    public void update(CrewEntity updatedCrewEntity) {
        this.update(updatedCrewEntity, updatedCrewEntity.getId());
    }

    public void delete(Long id) {
        crewRepository.deleteById(id);
    }

    public void delete(CrewEntity crewEntity) {
        try {
            this.delete(crewEntity.getId());
        } catch (Exception exception) {
            exception.getMessage();
        }
    }
}
