package org.erfan.appcentric.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.erfan.appcentric.domain.Enum.StatusType;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORD_SEQ")
    @SequenceGenerator(sequenceName = "order_seq", allocationSize = 1, name = "ORD_SEQ")
    Long id;

    @Column(name = "ITEM_NAME")
    String item;
    @Column(name = "QUANTITY")
    int quantity;

    @Column(name = "CREATED_DATE", updatable = false)
    @CreationTimestamp
    LocalDateTime date;

    @Column(name = "UPDATED_DATE")
    @UpdateTimestamp
    LocalDateTime updateDate;
    @Column(name = "PRICE")
    long price;
    @Column(name = "STATUS")
    StatusType status;

    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    UserEntity userEntity;
}
