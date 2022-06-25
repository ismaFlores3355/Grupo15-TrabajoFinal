package ar.edu.unju.fi.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DominioValidator implements ConstraintValidator<Dominio, String>  {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return (value != null && value.endsWith("fi.unju.edu.ar"));
	}

}