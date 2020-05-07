package com.cg.movie.exception;

public class ContactAndUserNameExistsException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ContactAndUserNameExistsException(String message) {
		super(message);
	}
	
	public ContactAndUserNameExistsException(String message,Throwable t)
	{
		super(message,t);
	}
	
	
	
}
