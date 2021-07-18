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

import local.example.capstone.data.entity.ProductEntity;
import local.example.capstone.data.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductEntity> readAll() {
        return (List<ProductEntity>) productRepository.findAll();
    }

    public List<ProductEntity> readAll(PageRequest pageRequest) {
        return (List<ProductEntity>) productRepository.findAll();
    }

    public void create(ProductEntity productEntity) {
        productRepository.save(productEntity);
    }

    public Optional<ProductEntity> read(Long id) {
        return productRepository.findById(id);
    }

    public void update(ProductEntity updatedProductEntity, Long id) {
        Optional.of(productRepository.findById(id).map(
                storedProductEntity -> {
                    if (updatedProductEntity.getCode() != null)
                        storedProductEntity.setCode(updatedProductEntity.getCode());
                    if (updatedProductEntity.getAmount() != null)
                        storedProductEntity.setAmount(updatedProductEntity.getAmount());
                    return productRepository.save(storedProductEntity);
                }).orElseGet(
                () -> {
                    return productRepository.save(updatedProductEntity);
                }));
    }

    public void update(ProductEntity updatedProductEntity) {
        this.update(updatedProductEntity, updatedProductEntity.getId());
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public void delete(ProductEntity productEntity) {
        try {
            this.delete(productEntity.getId());
        } catch (Exception exception) {
            exception.getMessage();
        }
    }
}
