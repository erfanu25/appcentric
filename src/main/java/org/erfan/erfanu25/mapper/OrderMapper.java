package org.erfan.erfanu25.mapper;

import org.erfan.erfanu25.domain.Order;
import org.erfan.erfanu25.entity.OrderEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    ModelMapper modelMapper = new ModelMapper();

    public OrderEntity domainToEntity(Order order) {
        return modelMapper.map(order,OrderEntity.class);
    }

    public Order entityToDomain(OrderEntity orderEntity ) {
        return modelMapper.map(orderEntity,Order.class);
    }
}
