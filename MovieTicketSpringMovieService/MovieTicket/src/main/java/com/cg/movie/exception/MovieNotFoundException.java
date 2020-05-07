package com.cg.movie.exception;

public class MovieNotFoundException extends RuntimeException{
	
	

	private static final long serialVersionUID = 1L;
	public MovieNotFoundException(String message)
	{
		super(message);
	}
	public MovieNotFoundException(String message,Throwable t)
	{
		super(message,t);
	}


}
