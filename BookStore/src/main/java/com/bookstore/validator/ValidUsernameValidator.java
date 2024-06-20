package com.bookstore.validator;

import com.bookstore.repository.IUserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext)
    {
        if(userRepository == null)
            return true;
        return userRepository.findByUsename(username) == null;

    }
}
