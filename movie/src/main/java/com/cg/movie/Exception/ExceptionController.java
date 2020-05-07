package com.cg.movie.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.movie.Exception.TheatreIdNotFoundException;
@RestControllerAdvice
public class ExceptionController {
	@ExceptionHandler(value = TheatreIdNotFoundException.class)
	public ResponseEntity<Object> handleException(TheatreIdNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = NoTheatresFoundException.class)
	public ResponseEntity<Object> handleException(NoTheatresFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
}


