package org.erfan.erfanu25.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "CustomerInfo")
public class CustomerEntity {

    // "customer_seq" is Oracle sequence name.
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
//    @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
    Long id;

    @NotNull
    @NotEmpty
    @Column(name = "CUSTOMER_FIRST_NAME")
    String firstName;

    @NotNull
    @NotEmpty
    @Column(name = "CUSTOMER_LAST_NAME")
    String lastName;

    @Column(name = "EMAIL")
    String email;

    @Column(name = "CREATED_DATE", updatable = false)
    @CreationTimestamp
    LocalDateTime date;

    @Column(name = "UPDATED_DATE")
    @UpdateTimestamp
    LocalDateTime updateDate;
    @Column(name = "BALANCE")
    Long balance;

    @Column(name = "PASS")
    String password;

    //getters and setters, contructors
}
