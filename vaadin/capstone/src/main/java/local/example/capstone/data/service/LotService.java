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

import local.example.capstone.data.entity.LotEntity;
import local.example.capstone.data.repository.LotRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LotService {

    @Autowired
    LotRepository lotRepository;

    public List<LotEntity> readAll() {
        return (List<LotEntity>) lotRepository.findAll();
    }

    public List<LotEntity> readAll(PageRequest pageRequest) {
        return (List<LotEntity>) lotRepository.findAll();
    }

    public void create(LotEntity lotEntity) {
        lotRepository.save(lotEntity);
    }

    public Optional<LotEntity> read(Long id) {
        return lotRepository.findById(id);
    }

    public void update(LotEntity updatedLotEntity, Long id) {
        Optional.of(lotRepository.findById(id).map(
                storedLotEntity -> {
                    if (updatedLotEntity.getCode() != null)
                        storedLotEntity.setCode(updatedLotEntity.getCode());
                    if (updatedLotEntity.getAmount() != null)
                        storedLotEntity.setAmount(updatedLotEntity.getAmount());
                    if (updatedLotEntity.getDeadline() != null)
                        storedLotEntity.setDeadline(updatedLotEntity.getDeadline());
                    return lotRepository.save(storedLotEntity);
                }).orElseGet(
                () -> {
                    return lotRepository.save(updatedLotEntity);
                }));
    }

    public void update(LotEntity updatedLotEntity) {
        this.update(updatedLotEntity, updatedLotEntity.getId());
    }

    public void delete(Long id) {
        lotRepository.deleteById(id);
    }

    public void delete(LotEntity lotEntity) {
        try {
            this.delete(lotEntity.getId());
        } catch (Exception exception) {
            exception.getMessage();
        }
    }
}
