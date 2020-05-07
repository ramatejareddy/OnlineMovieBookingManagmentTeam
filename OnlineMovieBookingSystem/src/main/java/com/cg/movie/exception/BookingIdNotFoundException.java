package com.cg.movie.exception;

public class BookingIdNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

    public BookingIdNotFoundException(String msg) {
		super(msg);
	}

}
