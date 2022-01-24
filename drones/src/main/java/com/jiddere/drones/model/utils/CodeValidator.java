package com.jiddere.drones.model.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CodeValidator implements ConstraintValidator<Code, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		return (value != null) && (value.matches("[A-Z0-9_]+"));
	}

}
