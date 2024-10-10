package com.excelr.ems_backend.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<Phone, String> {

    private int length;

    @Override
    public void initialize(Phone constraintAnnotation) {
        this.length = constraintAnnotation.length();  // Get the length specified in the annotation
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        // Check if phone number is null
        if (phoneNumber == null) {
            return false;
        }

        // Check if phone number has the correct length and only contains digits
        return phoneNumber.matches("\\d{" + length + "}");
    }
}
