package br.com.prime.exception;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"timestamp", "errorCode", "statusCode", "message", "fieldErrors", "details"})
public class ExceptionResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private String timestamp;
    private Integer statusCode;
    private String message;
    private String errorCode;
    private Map<String, String> fieldErrors;
    
	public ExceptionResponse() {
		super();
	}
	
	public ExceptionResponse(String timestamp, Integer statusCode, String message) {
		super();
		this.timestamp = timestamp;
		this.statusCode = statusCode;
		this.message = message;
	}
    
	public ExceptionResponse(String timestamp, Integer statusCode, String message, String errorCode,
			Map<String, String> fieldErrors) {
		super();
		this.timestamp = timestamp;
		this.statusCode = statusCode;
		this.message = message;
		this.errorCode = errorCode;
		this.fieldErrors = fieldErrors;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public Map<String, String> getFieldErrors() {
		return fieldErrors;
	}
	public void setFieldErrors(Map<String, String> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
}
