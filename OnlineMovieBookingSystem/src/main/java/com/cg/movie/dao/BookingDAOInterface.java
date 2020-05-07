package com.cg.movie.dao;

import java.util.List;

import com.cg.movie.entity.Booking;
import com.cg.movie.entity.Movie;
import com.cg.movie.entity.Seat;
import com.cg.movie.entity.SeatsBooked;
import com.cg.movie.entity.Show;
import com.cg.movie.entity.Theater;
import com.cg.movie.entity.Ticket;


public interface BookingDAOInterface {
	public Seat getSeat(int showId);
	
	
	public List<Theater> getTheater(int movieId);
	
	public List<Seat> getSeats(int showId);
	public Show getShow(int showId);
	public Integer getMaxBookingId(int showId);
	public boolean addBooking(Booking booking);
	public Booking getBookingDetails(int bookingId);
	public boolean removeBooking(Booking booking);

	public List<Show> getShowList(int theaterId);

	public void addSeatBooked(SeatsBooked seat);

	public Integer getMaxTicketId();

	public boolean addTicket(Ticket ticketDetails);

	public Movie getMovie(int movieId);
	public List<Movie> getMovie();
	
	

}
