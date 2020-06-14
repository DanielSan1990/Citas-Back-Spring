package com.citas.citas.exceptions.generics;

public class ImUsedException extends RuntimeException{
	
	private static final String  DESCRIPTION = "Im Used Exception (226)";
	
	public ImUsedException(String details) {
		super(DESCRIPTION + ". " + details);
		
	}
	
}
