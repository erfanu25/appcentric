package org.erfan.erfanu25.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.erfan.erfanu25.domain.Enum.StatusType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "OrderInfo")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String item;

    int quantity;

    @Column(name = "CREATED_DATE", updatable = false)
    @CreationTimestamp
    LocalDateTime date;

    @Column(name = "UPDATED_DATE")
    @UpdateTimestamp
    LocalDateTime updateDate;

    long price;
    StatusType status;

    @OneToOne
    CustomerEntity customerEntity;
}
