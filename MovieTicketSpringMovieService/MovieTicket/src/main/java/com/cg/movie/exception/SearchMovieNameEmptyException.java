package com.cg.movie.exception;

public class SearchMovieNameEmptyException extends RuntimeException {
	
	public SearchMovieNameEmptyException(String message) 
	{
		super(message);
	}
	public SearchMovieNameEmptyException(String message,Throwable t)
	{
		super(message,t);
	}

}
