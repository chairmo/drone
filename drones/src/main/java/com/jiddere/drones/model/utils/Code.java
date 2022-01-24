package com.jiddere.drones.model.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CodeValidator.class)
@Documented
public @interface Code {
	String message() default "Invalid character entered";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
