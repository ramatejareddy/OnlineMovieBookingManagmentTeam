package com.cg.movie.exception;

public class NoMoviesFoundException extends RuntimeException{
	
	
	
	private static final long serialVersionUID = 1L;
	public NoMoviesFoundException(String message)
	{
		super(message);
	}
	public NoMoviesFoundException(String message,Throwable t)
	{
		super(message,t);
	}


}
