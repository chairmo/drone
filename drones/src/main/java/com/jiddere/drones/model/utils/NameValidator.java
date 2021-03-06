package com.jiddere.drones.model.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<Name, String>{

	/**this validates the name field for only alphabets a-zA-Z, 0-9 and 
	  none English characters using regex*/
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return (value != null) && (value.matches("^\\w+$"));
	}

}
