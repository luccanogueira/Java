package br.com.prime.exception.handlers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.prime.exception.AppValidationException;

@Provider
public class AppValidationHandler extends RuntimeException implements ExceptionMapper<br.com.prime.exception.AppValidationException> {
	
	private static final long serialVersionUID = 1L;

	@Override
	public Response toResponse(AppValidationException exception) {
		return Response.status(400).entity(exception.getMessages()).build();
	}
}
