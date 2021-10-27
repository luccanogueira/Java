package br.com.prime.comum.controller;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import br.com.prime.exception.AppValidationException;

public class BaseController {

	@Inject
	protected Validator validator;
	
	public boolean validaObjeto(Object obj) throws AppValidationException  {
		Set<ConstraintViolation<Object>> violations = new HashSet<>();
		violations.addAll(this.validator.validate(obj));
		if(!violations.isEmpty()) {
			throw new AppValidationException(violations);
		}
		return true;
	}
}
