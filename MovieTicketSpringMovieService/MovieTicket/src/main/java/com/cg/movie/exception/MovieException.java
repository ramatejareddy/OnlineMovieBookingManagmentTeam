package com.cg.movie.exception;

public class MovieException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public MovieException(String message) {
		super(message);
	}
	
	public MovieException(String message,Throwable t)
	{
		super(message,t);
	}
	
	
	
}
