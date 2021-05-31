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

import local.example.capstone.data.entity.CarrierEntity;
import local.example.capstone.data.repository.CarrierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrierService {

    @Autowired
    CarrierRepository carrierRepository;

    public List<CarrierEntity> readAll() {
        return (List<CarrierEntity>) carrierRepository.findAll();
    }

    public void create(CarrierEntity carrierEntity) {
        carrierRepository.save(carrierEntity);
    }

    public Optional<CarrierEntity> read(Long id) {
        return carrierRepository.findById(id);
    }

    public void update(CarrierEntity updatedCarrierEntity, Long id) {
        Optional.of(carrierRepository.findById(id).map(
                storedCarrierEntity -> {
                    if (updatedCarrierEntity.getName() != null)
                        storedCarrierEntity.setName(updatedCarrierEntity.getName());
                    if (updatedCarrierEntity.getSticker() != null)
                        storedCarrierEntity.setSticker(updatedCarrierEntity.getSticker());
                    // TODO
                    //storedCarrierEntity.setUpdated(LocalDate.now());
                    return carrierRepository.save(storedCarrierEntity);
                }).orElseGet(
                () -> {
                    return carrierRepository.save(updatedCarrierEntity);
                }));
    }

    public void delete() {
        // TODO
    }
}
