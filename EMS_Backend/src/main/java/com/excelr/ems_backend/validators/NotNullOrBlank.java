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
@Constraint(validatedBy = {NotNullOrBlankValidator.class})
public @interface NotNullOrBlank {
	String message() default "This field cannot be null,empty and blank.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
