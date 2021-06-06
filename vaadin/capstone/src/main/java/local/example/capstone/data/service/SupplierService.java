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

import local.example.capstone.data.entity.SupplierEntity;
import local.example.capstone.data.repository.SupplierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public List<SupplierEntity> readAll() {
        return (List<SupplierEntity>) supplierRepository.findAll();
    }

    public void create(SupplierEntity supplierEntity) {
        supplierRepository.save(supplierEntity);
    }

    public Optional<SupplierEntity> read(Long id) {
        return supplierRepository.findById(id);
    }

    public void update(SupplierEntity updatedSupplierEntity, Long id) {
        Optional.of(supplierRepository.findById(id).map(
                storedSupplierEntity -> {
                    if (updatedSupplierEntity.getName() != null)
                        storedSupplierEntity.setName(updatedSupplierEntity.getName());
                    // TODO
                    return supplierRepository.save(storedSupplierEntity);
                }).orElseGet(
                () -> {
                    return supplierRepository.save(updatedSupplierEntity);
                }));
    }

    public void delete(Long id) {
        supplierRepository.deleteById(id);
    }

    public void delete(SupplierEntity supplierEntity) {
        supplierRepository.deleteById(supplierEntity.getId());
    }
}
