package com.cg.movie.controller;

import java.sql.Date;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movie.dto.BookingForm;
import com.cg.movie.dto.SeatDisplayForm;
import com.cg.movie.dto.SeatsBookedForm;
import com.cg.movie.dto.SeatsForm;
import com.cg.movie.dto.ShowForm;
import com.cg.movie.dto.TicketForm;
import com.cg.movie.entity.Movie;

import com.cg.movie.exception.BookingDateException;
import com.cg.movie.exception.BookingException;
import com.cg.movie.exception.BookingIdNotFoundException;
import com.cg.movie.exception.MovieIdNotFoundException;

import com.cg.movie.exception.NoofSeatsException;
import com.cg.movie.exception.SeatException;
import com.cg.movie.exception.SeatsAvailabiltyException;
import com.cg.movie.exception.ShowException;
import com.cg.movie.exception.TheaterNotFoundException;
import com.cg.movie.service.BookingServiceInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OnlineMovieBookingController {
	@Autowired
	BookingServiceInterface service;
	
	//http request for calculating the fare based on no of seats and seatId
	@GetMapping("/seatfare/{showId}/{noOfSeats}")
	public double  calculateFare(@PathVariable("showId") int showId,@PathVariable("noOfSeats") int noOfSeats) throws ShowException, NoofSeatsException
	{
		if(noOfSeats<=0) {
			throw new NoofSeatsException("No of seats cannot be less than or equal to zero");
		}
		double totalFare=service.totalCost(showId,noOfSeats);
		return totalFare;
	}
	
	
	//http request for getting the theater and show List based on booking date  and movieId;
		@GetMapping("/getTheaterAndShow/{bookingDate}/{movieId}")
		public ResponseEntity<List<ShowForm>> getTheater(@PathVariable("bookingDate") Date bookingDate,@PathVariable("movieId") int movieId) throws ShowException, TheaterNotFoundException, BookingDateException {
			
			List<ShowForm> showList=service.getTheaterAndShow(bookingDate,movieId);
			if(showList.isEmpty()) {
				throw new ShowException("Shows are not available for this movie .Please try another movie.");
			}
			return new  ResponseEntity<List<ShowForm>>(showList,HttpStatus.OK);
					}
	
	
    //http request for getting the show List
		@GetMapping("/getMovies")
		public List<Movie> getMovies() throws MovieIdNotFoundException{
			List<Movie> movieList=service.getMovies();
			return movieList;
		}
	
	//http request for getting the specific seats based on showId
	@GetMapping("/getSeats/{showId}")
	public List<SeatDisplayForm> getSeats(@PathVariable("showId") int showId) throws ShowException, SeatException{
		List<SeatDisplayForm> seatList=service.getSeats(showId);
		if(seatList.isEmpty())
		{
			throw new SeatException("seats are not found for the "+showId+" showId");			
		}
		return seatList;
		
	}
	//http request to count the available seats on the particular show
	@GetMapping("/getAvailableSeats/{showId}")
	public Integer getAvailableSeats(@PathVariable("showId") int showId) throws ShowException {
		int availableSeats=service.countAvailableSeats(showId);
		return availableSeats;
	}
	
	//http request for updating the seats status customer booked based on no of seats and showId
	@PutMapping("/selectedSeats/{noOfSeats}/{showId}")
	public List<SeatsBookedForm> selectedSeats(@PathVariable("noOfSeats") int noOfSeats,@PathVariable("showId") int showId ) throws SeatsAvailabiltyException, ShowException {
		
		Boolean checkAvailablilty=service.checkAvailableSeats(showId, noOfSeats);
		if(!checkAvailablilty) { 
			throw new SeatsAvailabiltyException("The available seats are less than the your required no of seats");
			}
		List<SeatsBookedForm> seatsBookedList=service.selectedSeats(noOfSeats, showId);
		return seatsBookedList;		
	}
	
	//http request to cancel the block seats 
	@PutMapping("/cancelBlockSeats/{showId}")
	public String cancelBlockSeats(@PathVariable("showId") int showId,@RequestBody List<SeatsForm> seatsBooked) {
		boolean seatStatus=service.unblockSeats(showId, seatsBooked);
		String statement="Seats are unblocked successfully" ;
		return statement;
	}
	
	//http request for insert the booking details 
	@PostMapping("/generateTickets")
	public TicketForm generateTickets(@RequestBody BookingForm booking) throws ShowException, BookingException
	{
		if(booking==null)
		{
			throw new BookingException("BookingDetails are not correct .Please check again");
		}	
		TicketForm ticket =service.addBooking(booking);
		
		return ticket;
	}
	
	//http request for canceling the booking based on booking Id
	@PostMapping("/cancelBooking/{bookingId}")
	public String cancelBooking(@PathVariable("bookingId") int bookingId) throws BookingIdNotFoundException
	{
		service.cancelBooking(bookingId);
		String statement="Booking has been successfully deleted";
		return statement;
		
		
	}
			
}				
