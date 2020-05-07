package com.cg.movie.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


import com.cg.movie.dto.BookingForm;
import com.cg.movie.dto.SeatDisplayForm;
import com.cg.movie.dto.SeatsBookedForm;
import com.cg.movie.dto.SeatsForm;
import com.cg.movie.dto.ShowForm;
import com.cg.movie.dto.TicketForm;
import com.cg.movie.entity.Movie;
import com.cg.movie.entity.Seat;
import com.cg.movie.entity.Show;
import com.cg.movie.entity.Theater;
import com.cg.movie.entity.Ticket;
import com.cg.movie.entity.user;
import com.cg.movie.exception.BookingDateException;
import com.cg.movie.exception.BookingIdNotFoundException;
import com.cg.movie.exception.MovieIdNotFoundException;
import com.cg.movie.exception.SeatException;
import com.cg.movie.exception.ShowException;
import com.cg.movie.exception.TheaterNotFoundException;

public interface BookingServiceInterface {
	public double totalCost(int showId,int noOfSeats) throws ShowException;
	public List<SeatDisplayForm> getSeats(int showId) throws ShowException;
	public List<SeatsBookedForm> selectedSeats(int noOfSeats, int showId);
	public Integer countAvailableSeats(int showId) throws ShowException;
	public boolean checkAvailableSeats(int showId,int noOfSeats) throws ShowException;
	public TicketForm addBooking(BookingForm book) throws ShowException;
	public boolean unblockSeats(int showId,List<SeatsForm> seatsBooked);
	
	public boolean cancelBooking(int bookingId) throws BookingIdNotFoundException ;

	public List<ShowForm> getTheaterAndShow(Date bookingDate, int movieId) throws TheaterNotFoundException, BookingDateException;

	

	public List<Movie> getMovies() throws MovieIdNotFoundException;
	

	

	


	

}
