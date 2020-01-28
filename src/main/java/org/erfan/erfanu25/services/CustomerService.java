package org.erfan.erfanu25.services;

import org.erfan.erfanu25.entity.CustomerEntity;
import org.erfan.erfanu25.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<CustomerEntity> getCustomer() {
        return customerRepository.findAll();
    }

    public Optional<CustomerEntity> getCustomerById(long id)  {
        return customerRepository.findById(id);
    }

    public void delete(long id) {
        customerRepository.deleteById(id);
    }

    public CustomerEntity saveCustomer(CustomerEntity customerEntity) {
        return customerRepository.save(customerEntity);
    }

    public CustomerEntity updateCustomer(CustomerEntity customerEntity, long id) {
        Optional<CustomerEntity> customerOptional =  customerRepository.findById(id);
        if (!customerOptional.isPresent()) {
            return null;
        }
        customerEntity.setId(id);
        customerRepository.save(customerEntity);
        return customerEntity;
    }
}
