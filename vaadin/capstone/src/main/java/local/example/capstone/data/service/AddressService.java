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

import local.example.capstone.data.entity.AddressEntity;
import local.example.capstone.data.repository.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public List<AddressEntity> readAll() {
        return (List<AddressEntity>) addressRepository.findAll();
    }

    public void create(AddressEntity addressEntity) {
        addressRepository.save(addressEntity);
    }

    public Optional<AddressEntity> read(Long id) {
        return addressRepository.findById(id);
    }

    public void update(AddressEntity updatedAddressEntity, Long id) {
        Optional.of(addressRepository.findById(id).map(
                storedAddressEntity -> {
                    if (updatedAddressEntity.getStreet() != null)
                        storedAddressEntity.setStreet(updatedAddressEntity.getStreet());
                    if (updatedAddressEntity.getPostalCode() != null)
                        storedAddressEntity.setPostalCode(updatedAddressEntity.getPostalCode());
                    if (updatedAddressEntity.getCity() != null)
                        storedAddressEntity.setCity(updatedAddressEntity.getCity());
                    if (updatedAddressEntity.getState() != null)
                        storedAddressEntity.setState(updatedAddressEntity.getState());
                    if (updatedAddressEntity.getCountry() != null)
                        storedAddressEntity.setCountry(updatedAddressEntity.getCountry());
                    return addressRepository.save(storedAddressEntity);
                }).orElseGet(
                () -> {
                    return addressRepository.save(updatedAddressEntity);
                }));
    }

    public void update(AddressEntity updatedAddressEntity) {
        this.update(updatedAddressEntity, updatedAddressEntity.getId());
    }

    public void delete(Long id) {
        addressRepository.deleteById(id);
    }

    public void delete(AddressEntity addressEntity) {
        try {
            this.delete(addressEntity.getId());
        } catch (Exception exception) {
            exception.getMessage();
        }
    }
}
