package org.erfan.erfanu25.services;

import org.erfan.erfanu25.domain.Order;
import org.erfan.erfanu25.mapper.OrderMapper;
import org.erfan.erfanu25.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public List<Order> getOrderList() {
        return orderMapper.entityToDomainList(orderRepository.findAll());
    }
}
