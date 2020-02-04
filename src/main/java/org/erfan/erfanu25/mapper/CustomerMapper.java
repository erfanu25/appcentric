package org.erfan.erfanu25.mapper;

import org.erfan.erfanu25.domain.Customer;
import org.erfan.erfanu25.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class CustomerMapper {


    ModelMapper modelMapper = new ModelMapper();

    public CustomerEntity domainToEntity(Customer customer) {
        return modelMapper.map(customer,CustomerEntity.class);
    }

    public Customer entityToDomain(CustomerEntity customerEntity ) {
        return modelMapper.map(customerEntity,Customer.class);
    }

    public List<Customer> entityToDomainList(List<CustomerEntity> customerEntities) {

        Type listType = new TypeToken<List<Customer>>(){}.getType();
        return modelMapper.map(customerEntities,  listType);

    }
}
