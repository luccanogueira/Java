package br.com.prime.exception.handlers;

import java.time.LocalDateTime;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.prime.exception.ClienteException;
import br.com.prime.exception.ExceptionResponse;

@Provider
public class ClienteExceptionHandler extends RuntimeException implements ExceptionMapper<ClienteException> {

	private static final long serialVersionUID = 1L;

	@Override
	public Response toResponse(ClienteException exception) {

		final int statusCode = exception.getStatus().value();

		final String mensagemEx = exception.getError().getMessage();
		final String mensagem = mensagemEx == null ? "Erro padrao" : mensagemEx;

		final ExceptionResponse response = new ExceptionResponse(LocalDateTime.now().toString(), statusCode, mensagem);

		return Response.status(statusCode).entity(response).type(MediaType.APPLICATION_JSON_TYPE).build();
	}
}
