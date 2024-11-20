package com.davs.springSecurity.validation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.davs.springSecurity.services.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class ExistByUsernameValidation implements ConstraintValidator<ExistByUsername, String> {

    @Autowired
    private UserService service;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(service == null){
            
            return true; 
        }
        return !service.existsByUsername(value);
    }

}
