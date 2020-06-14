package com.citas.citas.exceptions.generics;

public class NoContentException extends RuntimeException{
	
	private static final String  DESCRIPTION = "No Content Exception (204)";
	
	public NoContentException(String details) {
		super(DESCRIPTION + ". " + details);
		
	}
	
}
