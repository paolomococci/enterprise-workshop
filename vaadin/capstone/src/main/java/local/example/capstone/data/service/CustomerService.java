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

import local.example.capstone.data.entity.CustomerEntity;
import local.example.capstone.data.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerEntity> readAll() {
        return (List<CustomerEntity>) customerRepository.findAll();
    }

    public List<CustomerEntity> readAll(PageRequest pageRequest) {
        return (List<CustomerEntity>) customerRepository.findAll();
    }

    public void create(CustomerEntity customerEntity) {
        customerRepository.save(customerEntity);
    }

    public Optional<CustomerEntity> read(Long id) {
        return customerRepository.findById(id);
    }

    public void update(CustomerEntity updatedCustomerEntity, Long id) {
        Optional.of(customerRepository.findById(id).map(
                storedCustomerEntity -> {
                    if (updatedCustomerEntity.getName() != null)
                        storedCustomerEntity.setName(updatedCustomerEntity.getName());
                    if (updatedCustomerEntity.getSticker() != null)
                        storedCustomerEntity.setSticker(updatedCustomerEntity.getSticker());
                    return customerRepository.save(storedCustomerEntity);
                }).orElseGet(
                () -> {
                    return customerRepository.save(updatedCustomerEntity);
                }));
    }

    public void update(CustomerEntity updatedCustomerEntity) {
        this.update(updatedCustomerEntity, updatedCustomerEntity.getId());
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public void delete(CustomerEntity customerEntity) {
        try {
            this.delete(customerEntity.getId());
        } catch (Exception exception) {
            exception.getMessage();
        }
    }
}
