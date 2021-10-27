package br.com.prime.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

public class AppValidationException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private final transient List<String> messages = new ArrayList<>();
	
	public AppValidationException() {
		super();		
	}
	
	public AppValidationException(String codErro) {
		super(codErro);
		this.messages.add(codErro);
	}
	
	public AppValidationException(String codErro, String... params) {
		super(codErro);
		this.messages.add(codErro + " " + params);
	}
	
	public AppValidationException(Set<ConstraintViolation<Object>> violations) {
		for(ConstraintViolation<Object> constraint : violations) {
			preparaMensagem(constraint);
		}
	}

	private void preparaMensagem(ConstraintViolation<Object> constraint) {
		if(constraint.getPropertyPath() == null) {
			return;
		}
		String field = constraint.getPropertyPath().iterator().next().toString();
		String message = constraint.getMessage();
		
		this.messages.add("Campo: " + field + ", " + message);
	}
	
	public List<String> getMessages() {
		return messages;
	}
}
