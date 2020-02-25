package org.erfan.appcentric.mapper;

import org.erfan.appcentric.domain.Order;
import org.erfan.appcentric.entity.OrderEntity;
import org.erfan.appcentric.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    private final UserRepository userRepository;

    public OrderMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResultMapper<OrderEntity, Order> entityToDomainMapping() {
        return entity ->
                new Order().setId(entity.getId())
                        .setQuantity(entity.getQuantity())
                        .setStatus(entity.getStatus())
                        .setItemName(entity.getItem())
                        .setPrice(entity.getPrice())
                        .setDate(entity.getDate())
                        .setUserId(entity.getUserEntity().getId());
    }


    public ResultMapper<Order, OrderEntity> domainToEntityMapping() {
        return domain ->
                new OrderEntity()
                        .setQuantity(domain.getQuantity())
                        .setStatus(domain.getStatus())
                        .setItem(domain.getItemName())
                        .setPrice(domain.getPrice())
                        .setUserEntity(
                                userRepository.findById(domain.getUserId()).get()
                        );
    }

}
