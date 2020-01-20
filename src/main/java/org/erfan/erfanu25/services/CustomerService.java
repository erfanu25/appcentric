package org.erfan.erfanu25.services;

import org.erfan.erfanu25.model.Customer;
import org.erfan.erfanu25.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(long id)  {
        return customerRepository.findById(id);
    }

    public void delete(long id) {
        customerRepository.deleteById(id);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer, long id) {
        Optional<Customer> customerOptional =  customerRepository.findById(id);
        if (!customerOptional.isPresent()) {
            return null;
        }
        customer.setId(id);
        customerRepository.save(customer);
        return customer;
    }
}
