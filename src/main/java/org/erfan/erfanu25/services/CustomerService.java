package org.erfan.erfanu25.services;

import org.erfan.erfanu25.domain.Customer;
import org.erfan.erfanu25.entity.CustomerEntity;
import org.erfan.erfanu25.mapper.CustomerMapper;
import org.erfan.erfanu25.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository,
                           CustomerMapper customerMapper){
        this.customerRepository = customerRepository;
        this.customerMapper =  customerMapper;
    }

    public List<Customer> getCustomer() {
        return customerRepository.findAll()
                .stream()
                .map(customerEntity -> customerMapper
                        .entityToDomainMapping()
                        .map(customerEntity))
                .collect(Collectors.toList());
    }

    public Customer getCustomerById(long id)  {
        return customerMapper.entityToDomain(customerRepository.findById(id).get());
    }

    public void delete(long id) {
        customerRepository.deleteById(id);
    }

    public Customer saveCustomer(Customer customer) {
        return customerMapper.entityToDomain(customerRepository.save(customerMapper.domainToEntity(customer)));
    }

    public String updateCustomer(Customer customer, long id) {
        Optional<CustomerEntity> customerOptional =  customerRepository.findById(id);
        if (!customerOptional.isPresent()) {
            return "Customer Not Found";
        }
        CustomerEntity customerEntity = customerMapper.domainToEntity(customer);
        customerEntity.setId(id);
        customerRepository.save(customerEntity);
        return "Update Success";
    }
}
