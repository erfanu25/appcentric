package org.erfan.appcentric.controller.order;

import org.erfan.appcentric.domain.Enum.StatusType;
import org.erfan.appcentric.domain.Order;
import org.erfan.appcentric.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/order")
    public List<Order> orderList() {
        return orderService.getOrderList();
    }

    @GetMapping(value = "/order/{userId}")
    public List<Order> getOrdersByUser(@PathVariable long userId) {
        return orderService.getOrdersByUser(userId);
    }

    @PostMapping("/order")
    public ResponseEntity<Long> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.saveOrder(order));
    }

    @PutMapping("/UpdateStatus/{status}/{orderId}")
    public ResponseEntity<String> updateStatus(@PathVariable StatusType status, @PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.changeStatus(status, orderId));
    }




}
