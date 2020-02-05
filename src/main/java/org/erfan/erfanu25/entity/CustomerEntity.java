package org.erfan.erfanu25.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
public class CustomerEntity implements Serializable {

    // "customer_seq" is Oracle sequence name.
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
//    @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    String email;

    @Column(name = "CREATED_DATE", updatable = false)
    @CreationTimestamp
    Date date;

    @Column(name = "UPDATED_DATE")
    @UpdateTimestamp
    Date updateDate;

    Long balance;

    //getters and setters, contructors
}
