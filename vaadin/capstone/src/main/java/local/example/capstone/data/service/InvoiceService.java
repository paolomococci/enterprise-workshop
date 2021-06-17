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

import local.example.capstone.data.entity.InvoiceEntity;
import local.example.capstone.data.repository.InvoiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    public List<InvoiceEntity> readAll() {
        return (List<InvoiceEntity>) invoiceRepository.findAll();
    }

    public void create(InvoiceEntity invoiceEntity) {
        invoiceRepository.save(invoiceEntity);
    }

    public Optional<InvoiceEntity> read(String id) {
        return invoiceRepository.findById(Long.valueOf(id));
    }

    public void update(InvoiceEntity updatedInvoiceEntity, Long id) {
        Optional.of(invoiceRepository.findById(id).map(
                storedInvoiceEntity -> {
                    // TODO
                    return invoiceRepository.save(storedInvoiceEntity);
                }).orElseGet(
                () -> {
                    return invoiceRepository.save(updatedInvoiceEntity);
                }));
    }

    public void update(InvoiceEntity updatedInvoiceEntity) {
        Optional.of(invoiceRepository.findById(updatedInvoiceEntity.getId()).map(
                storedInvoiceEntity -> {
                    // TODO
                    return invoiceRepository.save(storedInvoiceEntity);
                }).orElseGet(
                () -> {
                    return invoiceRepository.save(updatedInvoiceEntity);
                }));
    }

    public void delete(Long id) {
        invoiceRepository.deleteById(id);
    }

    public void delete(InvoiceEntity invoiceEntity) {
        invoiceRepository.deleteById(invoiceEntity.getId());
    }
}
