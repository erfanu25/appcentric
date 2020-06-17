package org.erfan.appcentric.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.erfan.appcentric.domain.Enum.UserRole;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "UserInfo")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "user_seq", allocationSize = 1, name = "CUST_SEQ")
    @Column(name = "CUSTOMER_ID", updatable = false, nullable = false)
    Long id;

    @NotNull
    @NotEmpty
    @Column(name = "CUSTOMER_FIRST_NAME")
    String firstName;

    @NotNull
    @NotEmpty
    @Column(name = "CUSTOMER_LAST_NAME")
    String lastName;

    @Column(name = "EMAIL", unique = true, updatable = false)
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

    UserRole userType;

}
