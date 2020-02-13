package org.erfan.erfanu25.controller;

import org.erfan.erfanu25.domain.Order;
import org.erfan.erfanu25.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/customer")
    public List<Order> customer() {
        return orderService.getOrderList();
    }
}
