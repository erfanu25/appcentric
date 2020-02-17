package org.erfan.erfanu25.repository;

import org.erfan.erfanu25.entity.CustomerEntity;
import org.erfan.erfanu25.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findAllByCustomerEntity(CustomerEntity customerEntity);
}

