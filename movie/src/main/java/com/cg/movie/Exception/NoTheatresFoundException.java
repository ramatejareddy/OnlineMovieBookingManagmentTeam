package com.cg.movie.Exception;

public class NoTheatresFoundException  extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoTheatresFoundException(String msg) {
		super(msg);
	}
	public  NoTheatresFoundException(String msg,Throwable T) {
		super(msg,T);
	}
	
}
