package com.cg.movie.exception;

public class NoActiveMoviesFoundException extends RuntimeException{
	
	
	
	private static final long serialVersionUID = 1L;
	public NoActiveMoviesFoundException(String message)
	{
		super(message);
	}
	public NoActiveMoviesFoundException(String message,Throwable t)
	{
		super(message,t);
	}


}
