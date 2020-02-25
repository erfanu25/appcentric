package org.erfan.appcentric.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.erfan.appcentric.annotation.PasswordMatches;
import org.erfan.appcentric.annotation.ValidEmail;
import org.erfan.appcentric.domain.Enum.UserRole;

@Getter
@Setter
@Accessors(chain = true)
@PasswordMatches
public class User {
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long id;
    String firstName;
    String lastName;
    @ValidEmail
    String email;
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password;
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String matchPassword;
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    UserRole userType;

}
