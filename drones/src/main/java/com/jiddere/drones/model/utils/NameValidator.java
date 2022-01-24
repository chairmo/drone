package com.jiddere.drones.model.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<Name, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return (value != null) && (value.matches("^\\w+$"));
	}

}
