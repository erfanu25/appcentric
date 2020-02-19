package org.erfan.appcentric.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.erfan.appcentric.annotation.ValidEmail;

@Getter
@Setter
@Accessors(chain = true)
public class Customer {
    Long id;
    String firstName;
    String lastName;
    @ValidEmail
    String email;
    @Getter(AccessLevel.NONE)
    String password;

}
