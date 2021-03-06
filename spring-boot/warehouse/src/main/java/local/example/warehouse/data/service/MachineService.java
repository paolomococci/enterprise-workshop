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

import local.example.warehause.data.entity.MachineEntity;
import local.example.warehause.data.repository.MachineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService {

    @Autowired
    MachineRepository machineRepository;

    public List<MachineEntity> readAll() {
        return (List<MachineEntity>) machineRepository.findAll();
    }

    public List<MachineEntity> readAll(PageRequest pageRequest) {
        return (List<MachineEntity>) machineRepository.findAll();
    }

    public void create(MachineEntity machineEntity) {
        machineRepository.save(machineEntity);
    }

    public Optional<MachineEntity> read(Long id) {
        return machineRepository.findById(id);
    }

    public void update(MachineEntity updatedMachineEntity, Long id) {
        Optional.of(machineRepository.findById(id).map(
                storedMachineEntity -> {
                    if (updatedMachineEntity.getLabel() != null)
                        storedMachineEntity.setLabel(updatedMachineEntity.getLabel());
                    if (updatedMachineEntity.getCapacity() != null)
                        storedMachineEntity.setCapacity(updatedMachineEntity.getCapacity());
                    return machineRepository.save(storedMachineEntity);
                }).orElseGet(
                () -> {
                    return machineRepository.save(updatedMachineEntity);
                }));
    }

    public void update(MachineEntity updatedMachineEntity) {
        this.update(updatedMachineEntity, updatedMachineEntity.getId());
    }

    public void delete(Long id) {
        machineRepository.deleteById(id);
    }

    public void delete(MachineEntity machineEntity) {
        try {
            this.delete(machineEntity.getId());
        } catch (Exception exception) {
            exception.getMessage();
        }
    }
}
