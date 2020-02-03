package org.erfan.erfanu25.mapper;

import org.erfan.erfanu25.domain.Customer;
import org.erfan.erfanu25.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {


    ModelMapper modelMapper = new ModelMapper();

    public CustomerEntity domainToEntity(Customer customer) {
        return modelMapper.map(customer,CustomerEntity.class);
    }

    public Customer entityToDomain(CustomerEntity customerEntity ) {
        return modelMapper.map(customerEntity,Customer.class);
    }
}
