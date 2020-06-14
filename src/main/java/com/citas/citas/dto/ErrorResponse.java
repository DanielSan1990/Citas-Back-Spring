package com.citas.citas.dto;



import lombok.Data;

@Data
public class ErrorResponse {
	
	private String exception;
	private String message;
	private String path;
	
	public ErrorResponse(Exception exception, String path) {
		this.exception = exception.getClass().getSimpleName();
		this.message = exception.getMessage();
		this.path = path;
	}
	
	public ErrorResponse(Exception exception,String message ,String path) {
		this.exception = exception.getClass().getSimpleName();
		this.message = message;
		this.path = path;
	}
}