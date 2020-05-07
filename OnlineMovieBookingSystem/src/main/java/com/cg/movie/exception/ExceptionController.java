package com.cg.movie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionController {
	@ExceptionHandler(value = BookingDateException.class)
	public ResponseEntity<String> handleException(BookingDateException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = MovieIdNotFoundException.class)
	public ResponseEntity<Object> handleException(MovieIdNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = NoofSeatsException.class)
	public ResponseEntity<Object> handleException(NoofSeatsException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = SeatsAvailabiltyException.class)
	public ResponseEntity<Object> handleException(SeatsAvailabiltyException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = BookingIdNotFoundException.class)
	public ResponseEntity<Object> handleException(BookingIdNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = SeatException.class)
	public ResponseEntity<Object> handleException(SeatException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = ShowException.class)
	public ResponseEntity<Object> handleException(ShowException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = BookingException.class)
	public ResponseEntity<Object> handleException(BookingException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = TheaterNotFoundException.class)
	public ResponseEntity<Object> handleException(TheaterNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	

}
