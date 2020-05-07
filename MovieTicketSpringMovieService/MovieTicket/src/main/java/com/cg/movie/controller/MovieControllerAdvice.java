package com.cg.movie.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.movie.exception.ContactAndUserNameExistsException;
import com.cg.movie.exception.ContactOrUserNameExistsException;
import com.cg.movie.exception.MovieException;
import com.cg.movie.exception.MovieNotFoundException;
import com.cg.movie.exception.NoActiveMoviesFoundException;
import com.cg.movie.exception.NoInactiveMoviesFoundException;
import com.cg.movie.exception.NoMoviesFoundException;
import com.cg.movie.exception.SearchMovieNameEmptyException;
import com.cg.movie.exception.UserNamePasswordInvalidException;
import com.cg.movie.exception.UserNamePasswordNotProvidedException;
import com.cg.movie.exception.UserNotFoundException;


@ControllerAdvice
public class MovieControllerAdvice {
	
	@ExceptionHandler(MovieException.class)
    public final ResponseEntity<String> exceptionHandler( MovieException e) 
    {
       
     System.out.println();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(MovieNotFoundException.class)
    public final ResponseEntity<String> exceptionHandler
                        ( MovieNotFoundException e) 
    {
       
     System.out.println();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(NoMoviesFoundException.class)
    public final ResponseEntity<String> exceptionHandler( NoMoviesFoundException e) 
    {
       
     System.out.println();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
	
	
	@ExceptionHandler(NoActiveMoviesFoundException.class)
    public final ResponseEntity<String> exceptionHandler( NoActiveMoviesFoundException e) 
    {
       
     System.out.println();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

	@ExceptionHandler(NoInactiveMoviesFoundException.class)
    public final ResponseEntity<String> exceptionHandler( NoInactiveMoviesFoundException e) 
    {
       
     System.out.println();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
	@ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<String> exceptionHandler( UserNotFoundException e) 
    {
       
     System.out.println();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
	@ExceptionHandler(UserNamePasswordInvalidException.class)
    public final ResponseEntity<String> exceptionHandler( UserNamePasswordInvalidException e) 
    {
       
     System.out.println();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
	@ExceptionHandler(UserNamePasswordNotProvidedException.class)
    public final ResponseEntity<String> exceptionHandler( UserNamePasswordNotProvidedException e) 
    {
       
     System.out.println();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
	@ExceptionHandler(ContactAndUserNameExistsException.class)
    public final ResponseEntity<String> exceptionHandler( ContactAndUserNameExistsException e) 
    {
       
     System.out.println();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
	@ExceptionHandler(ContactOrUserNameExistsException.class)
    public final ResponseEntity<String> exceptionHandler( ContactOrUserNameExistsException e) 
    {
       
     System.out.println();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
	@ExceptionHandler(SearchMovieNameEmptyException.class)
    public final ResponseEntity<String> exceptionHandler( SearchMovieNameEmptyException e) 
    {
       
     System.out.println();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
	
	
	
	

}
