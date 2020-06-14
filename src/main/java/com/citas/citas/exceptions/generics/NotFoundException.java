package com.citas.citas.exceptions.generics;

public class NotFoundException extends RuntimeException{

	private static final String  DESCRIPTION = "Not Found Exception (404)";
	
	public NotFoundException(String details) {
		super(DESCRIPTION + ". " + details);
		
	}


}
