package org.erfan.erfanu25.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "OrderInfo")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    String status;
}
