package org.erfan.erfanu25.mapper;

import org.erfan.erfanu25.domain.Order;
import org.erfan.erfanu25.entity.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class OrderMapper {

    ModelMapper modelMapper = new ModelMapper();

    public OrderEntity domainToEntity(Order order) {
        return modelMapper.map(order,OrderEntity.class);
    }

    public Order entityToDomain(OrderEntity orderEntity ) {
        return modelMapper.map(orderEntity,Order.class);
    }

    public List<Order> entityToDomainList(List<OrderEntity> customerEntities) {

        Type listType = new TypeToken<List<Order>>(){}.getType();
        return modelMapper.map(customerEntities,  listType);

    }
}
