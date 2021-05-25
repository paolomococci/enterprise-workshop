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

package local.example.said.data.service;

import local.example.said.data.model.Customer;
import local.example.said.data.repository.AddressRepository;
import local.example.said.data.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CustomerService {

    private static final Logger LOGGER = Logger
            .getLogger(CustomerService.class.getName());
    private CustomerRepository customerRepository;
    private AddressRepository addressRepository;

    public CustomerService(
            CustomerRepository customerRepository,
            AddressRepository addressRepository
    ) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    public long count() {
        return customerRepository.count();
    }

    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    public void save(Customer customer) {
        if (customer == null) {
            LOGGER.log(
                    Level.SEVERE,
                    "Customer cannot be null!"
            );
            return;
        }
        customerRepository.save(customer);
    }
}
