package com.cg.movie.Exception;

public class TheatreIdNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TheatreIdNotFoundException(String msg) {
		super(msg);
	}
	public TheatreIdNotFoundException(String msg,Throwable T) {
		super(msg,T);
	}
}
