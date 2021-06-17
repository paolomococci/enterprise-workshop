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

import local.example.capstone.data.entity.MachineEntity;
import local.example.capstone.data.repository.MachineRepository;

import org.springframework.beans.factory.annotation.Autowired;
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

    public void create(MachineEntity machineEntity) {
        machineRepository.save(machineEntity);
    }

    public Optional<MachineEntity> read(String id) {
        return machineRepository.findById(Long.valueOf(id));
    }

    public void update(MachineEntity updatedMachineEntity, Long id) {
        Optional.of(machineRepository.findById(id).map(
                storedMachineEntity -> {
                    if (updatedMachineEntity.getLabel() != null)
                        storedMachineEntity.setLabel(updatedMachineEntity.getLabel());
                    // TODO
                    return machineRepository.save(storedMachineEntity);
                }).orElseGet(
                () -> {
                    return machineRepository.save(updatedMachineEntity);
                }));
    }

    public void delete(Long id) {
        machineRepository.deleteById(id);
    }

    public void delete(MachineEntity machineEntity) {
        machineRepository.deleteById(machineEntity.getId());
    }
}
