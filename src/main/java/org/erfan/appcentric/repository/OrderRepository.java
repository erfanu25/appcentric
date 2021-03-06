package org.erfan.appcentric.repository;

import org.erfan.appcentric.entity.UserEntity;
import org.erfan.appcentric.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findAllByUserEntity(UserEntity userEntity);
}

