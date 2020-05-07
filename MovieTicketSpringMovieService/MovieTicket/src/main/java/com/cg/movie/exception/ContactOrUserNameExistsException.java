package com.cg.movie.exception;

public class ContactOrUserNameExistsException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ContactOrUserNameExistsException(String message) {
		super(message);
	}
	
	public ContactOrUserNameExistsException(String message,Throwable t)
	{
		super(message,t);
	}
	
	
	
}
