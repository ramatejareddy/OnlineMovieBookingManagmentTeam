package com.cg.movie.exception;

public class UserNamePasswordInvalidException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UserNamePasswordInvalidException(String message) {
		super(message);
	}
	
	public UserNamePasswordInvalidException(String message,Throwable t)
	{
		super(message,t);
	}

}
