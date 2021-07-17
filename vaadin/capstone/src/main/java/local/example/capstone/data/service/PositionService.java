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

import local.example.capstone.data.entity.PositionEntity;
import local.example.capstone.data.repository.PositionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {

    @Autowired
    PositionRepository positionRepository;

    public List<PositionEntity> readAll() {
        return (List<PositionEntity>) positionRepository.findAll();
    }

    public void create(PositionEntity positionEntity) {
        positionRepository.save(positionEntity);
    }

    public Optional<PositionEntity> read(Long id) {
        return positionRepository.findById(id);
    }

    public void update(PositionEntity updatedPositionEntity, Long id) {
        Optional.of(positionRepository.findById(id).map(
                storedPositionEntity -> {
                    if (updatedPositionEntity.getLabel() != null)
                        storedPositionEntity.setLabel(updatedPositionEntity.getLabel());
                    if (updatedPositionEntity.getConsumptionProduct() != null)
                        storedPositionEntity.setConsumptionProduct(updatedPositionEntity.getConsumptionProduct());
                    if (updatedPositionEntity.getDetergent() != null)
                        storedPositionEntity.setDetergent(updatedPositionEntity.getDetergent());
                    if (updatedPositionEntity.getSanitizing() != null)
                        storedPositionEntity.setSanitizing(updatedPositionEntity.getSanitizing());
                    if (updatedPositionEntity.getEquipment() != null)
                        storedPositionEntity.setEquipment(updatedPositionEntity.getEquipment());
                    if (updatedPositionEntity.getClothing() != null)
                        storedPositionEntity.setClothing(updatedPositionEntity.getClothing());
                    if (updatedPositionEntity.getProtectionDevice() != null)
                        storedPositionEntity.setProtectionDevice(updatedPositionEntity.getProtectionDevice());
                    if (updatedPositionEntity.getPrimaryPackaging() != null)
                        storedPositionEntity.setPrimaryPackaging(updatedPositionEntity.getPrimaryPackaging());
                    if (updatedPositionEntity.getSecondaryPackaging() != null)
                        storedPositionEntity.setSecondaryPackaging(updatedPositionEntity.getSecondaryPackaging());
                    if (updatedPositionEntity.getComplementForShipping() != null)
                        storedPositionEntity.setComplementForShipping(updatedPositionEntity.getComplementForShipping());
                    if (updatedPositionEntity.getRowMaterial() != null)
                        storedPositionEntity.setRowMaterial(updatedPositionEntity.getRowMaterial());
                    if (updatedPositionEntity.getContainingAllergens() != null)
                        storedPositionEntity.setContainingAllergens(updatedPositionEntity.getContainingAllergens());
                    return positionRepository.save(storedPositionEntity);
                }).orElseGet(
                () -> {
                    return positionRepository.save(updatedPositionEntity);
                }));
    }

    public void update(PositionEntity updatedPositionEntity) {
        this.update(updatedPositionEntity, updatedPositionEntity.getId());
    }

    public void delete(Long id) {
        positionRepository.deleteById(id);
    }

    public void delete(PositionEntity positionEntity) {
        try {
            this.delete(positionEntity.getId());
        } catch (Exception exception) {
            exception.getMessage();
        }
    }
}
