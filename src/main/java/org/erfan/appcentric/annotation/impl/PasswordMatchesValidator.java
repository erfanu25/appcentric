package org.erfan.appcentric.annotation.impl;

import org.erfan.appcentric.annotation.PasswordMatches;
import org.erfan.appcentric.domain.Customer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
         Customer customer = (Customer) obj;
         return customer.getMatchPassword().equals(customer.getPassword());
    }
}
