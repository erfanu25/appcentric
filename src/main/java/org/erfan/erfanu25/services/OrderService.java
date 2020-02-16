package org.erfan.erfanu25.services;

import org.erfan.erfanu25.domain.Order;
import org.erfan.erfanu25.mapper.OrderMapper;
import org.erfan.erfanu25.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public List<Order> getOrderList() {
        return orderRepository.findAll()
                .stream()
                .map(orderEntity -> orderMapper
                                        .entityToDomainMapping()
                                        .map(orderEntity))
                .collect(Collectors.toList());
    }

    public Long saveOrder(Order order) {
        return orderRepository.save(orderMapper.domainToEntityMapping().map(order)).getId();
    }

}
