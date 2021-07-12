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

import local.example.capstone.data.repository.CapacityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapacityService {

    @Autowired
    CapacityRepository capacityRepository;

    public List<CapacityEntity> readAll() {
        return (List<CapacityEntity>) capacityRepository.findAll();
    }

    public void create(CapacityEntity capacityEntity) {
        capacityRepository.save(capacityEntity);
    }

    public Optional<CapacityEntity> read(String id) {
        return capacityRepository.findById(Long.valueOf(id));
    }

    public void update(CapacityEntity updatedCapacityEntity, Long id) {
        Optional.of(capacityRepository.findById(id).map(
                storedCapacityEntity -> {
                    if (updatedCapacityEntity.getUsefulWeight() != null)
                        storedCapacityEntity.setUsefulWeight(updatedCapacityEntity.getUsefulWeight());
                    if (updatedCapacityEntity.getUsefulVolume() != null)
                        storedCapacityEntity.setUsefulVolume(updatedCapacityEntity.getUsefulVolume());
                    if (updatedCapacityEntity.getType() != null)
                        storedCapacityEntity.setType(updatedCapacityEntity.getType());
                    return capacityRepository.save(storedCapacityEntity);
                }).orElseGet(
                () -> {
                    return capacityRepository.save(updatedCapacityEntity);
                }));
    }

    public void update(CapacityEntity updatedCapacityEntity) {
        this.update(updatedCapacityEntity, updatedCapacityEntity.getId());
    }
}
