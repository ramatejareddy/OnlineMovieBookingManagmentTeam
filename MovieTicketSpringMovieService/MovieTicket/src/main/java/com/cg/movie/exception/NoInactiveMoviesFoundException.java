package com.cg.movie.exception;

public class NoInactiveMoviesFoundException extends RuntimeException{
	
	
	 
	private static final long serialVersionUID = 1L;
	public NoInactiveMoviesFoundException(String message)
	{
		super(message);
	}
	public NoInactiveMoviesFoundException(String message,Throwable t)
	{
		super(message,t);
	}


}
