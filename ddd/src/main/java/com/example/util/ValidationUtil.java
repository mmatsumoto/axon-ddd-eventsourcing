package com.example.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;

public class ValidationUtil {

    public static <T> void validate(T value) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> validate = validator.validate(value);

        if(! validate.isEmpty()) {
            throw new ConstraintViolationException(validate);
        }
    }
}