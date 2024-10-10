package com.excelr.ems_backend.validators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { PhoneNumberValidator.class })
public @interface Phone {
	
	String message() default "Invalid phone number";

    // Length of the phone number (optional, default is 10)
    int length() default 10;

    // Required for custom validation annotations
    Class<?>[] groups() default {};

    // Payload for clients of the Bean Validation API to specify additional error details
    Class<? extends Payload>[] payload() default {};
}
