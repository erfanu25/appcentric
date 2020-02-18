package org.erfan.erfanu25.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Customer {
    Long id;
    String firstName;
    String lastName;
    String email;
    @Getter(AccessLevel.NONE)
    String password;

}
