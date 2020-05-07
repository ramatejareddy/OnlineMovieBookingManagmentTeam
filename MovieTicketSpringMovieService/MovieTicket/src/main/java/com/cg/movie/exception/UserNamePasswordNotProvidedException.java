package com.cg.movie.exception;

public class UserNamePasswordNotProvidedException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UserNamePasswordNotProvidedException(String message) {
		super(message);
	}
	
	public UserNamePasswordNotProvidedException(String message,Throwable t)
	{
		super(message,t);
	}
	
}
