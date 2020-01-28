package org.erfan.erfanu25.mapper;

import org.erfan.erfanu25.domain.Customer;
import org.erfan.erfanu25.entity.CustomerEntity;
import org.modelmapper.ModelMapper;

public class CustomerMapper {
    ModelMapper modelMapper = new ModelMapper();
    Customer customer = new Customer();
    CustomerEntity customerEntity = modelMapper.map(customer,CustomerEntity.class);
}
