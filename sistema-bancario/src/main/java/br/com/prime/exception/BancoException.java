package br.com.prime.exception;

import org.springframework.http.HttpStatus;

public class BancoException extends Exception{

	private static final long serialVersionUID = -4736663918596871691L;
	
	private final transient Throwable error;
	private final transient HttpStatus status;

	public BancoException(final String errorCode, final Throwable error) {
		super(errorCode);
		this.error = error;
		this.status = HttpStatus.BAD_REQUEST;
	}
	
	public BancoException(final String errorCode, final Throwable error, HttpStatus status) {
		super(errorCode);
		this.error = error;
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public Throwable getError() {
		return error;
	}
}
