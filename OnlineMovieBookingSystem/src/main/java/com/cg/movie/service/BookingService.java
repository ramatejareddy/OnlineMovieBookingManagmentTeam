package com.cg.movie.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.movie.dao.BookingDAOInterface;
import com.cg.movie.dto.BookingForm;
import com.cg.movie.dto.SeatDisplayForm;
import com.cg.movie.dto.SeatsBookedForm;
import com.cg.movie.dto.SeatsForm;
import com.cg.movie.dto.ShowForm;
import com.cg.movie.dto.TicketForm;
import com.cg.movie.entity.Booking;
import com.cg.movie.entity.BookingState;
import com.cg.movie.entity.Movie;
import com.cg.movie.entity.Seat;
import com.cg.movie.entity.SeatsBooked;
import com.cg.movie.entity.Show;
import com.cg.movie.entity.Theater;
import com.cg.movie.entity.Ticket;
import com.cg.movie.exception.BookingDateException;
import com.cg.movie.exception.BookingIdNotFoundException;
import com.cg.movie.exception.MovieIdNotFoundException;
import com.cg.movie.exception.SeatException;
import com.cg.movie.exception.ShowException;
import com.cg.movie.exception.TheaterNotFoundException;

@Service
@Transactional
public class BookingService implements BookingServiceInterface {
	
	@Autowired
	BookingDAOInterface dao;
	/********************************************************************************************************************
	*       @author           Rama Teja Reddy
	*       Description       It is a service that provides service for calculating the booking cost
	*       version           1.0
	*       created date      21-APR-2020
	 * @throws ShowException 
	 * @throws SeatException 
	********************************************************************************************************************/
	
	@Override
	public double totalCost(int showId,int noOfSeats) throws ShowException {
		Show show=dao.getShow(showId);
		if(show==null) {
			throw new ShowException("Show Id is not found");				
			}
		Seat seat=dao.getSeat(showId);		
		double seatPrice=seat.getSeatPrice();
		double totalPrice= noOfSeats*seatPrice;		
		return totalPrice;
	}
	
	/********************************************************************************************************************
	*       @author           Rama Teja Reddy
	*       Description       It is a service that provides service for fetching the list of movies from database
	*       version           1.0
	*       created date      22-APR-2020
	********************************************************************************************************************/
	
	@Override
	public List<Movie> getMovies() throws MovieIdNotFoundException {
		List<Movie> movieList=dao.getMovie();
		if(movieList==null) {
			throw new MovieIdNotFoundException("movies are not present");
		}
		return movieList;
	}

	/***********************************************************************************************************************************
	*       @author           Rama Teja Reddy
	*       Description       It is a service that provides service for fetching the theater and show based on booking date and movieId
	*       version           1.0
	*       created date      22-APR-2020
	*       @throws  TheaterNotFoundException, BookingDateException
	************************************************************************************************************************************/
	
	@Override
	public List<ShowForm> getTheaterAndShow(Date bookingDate, int movieId) throws TheaterNotFoundException, BookingDateException {
		List<ShowForm> showFormList=new ArrayList<ShowForm>();
		List<Theater> theaterList=dao.getTheater(movieId);
		if(theaterList==null) {
			throw new TheaterNotFoundException("Sorry theater are not available ");
		}
		Movie movie=dao.getMovie(movieId);
		for(Theater theater:theaterList) {
			List<Show> showList=dao.getShowList(theater.getTheaterId());
			List<Show>shows=new ArrayList<Show>();
			for(Show show:showList) {					
				if(show.getShowDate().compareTo(bookingDate)==0) {								
					shows.add(show);
				}
			}
			if(!shows.isEmpty()) {
				ShowForm showForm=new ShowForm(theater.getTheaterName(),theater.getTheaterCity(),shows,movie);
				showFormList.add(showForm);				
			}
					
		}	
		if(showFormList.isEmpty()) {
			throw new BookingDateException("Sorry no shows are available on this date");
		}	
		return showFormList;		
	}
	
	/********************************************************************************************************************
	*       @author           Rama Teja Reddy
	*       Description       It is a service that provides service for fetching the seats based on showId
	*       version           1.0
	*       created date      22-APR-2020
	 * @throws ShowException 
	********************************************************************************************************************/
	
	@Override
	public List<SeatDisplayForm> getSeats(int showId) throws ShowException {
		Show show=dao.getShow(showId);
		if(show==null) {
			throw new ShowException("Show id is not available");
		}
		List<Seat> seat=dao.getSeats(showId);
		List<SeatDisplayForm> seatFormList = new ArrayList<SeatDisplayForm>();		
		for(int seatCheck=0;seatCheck<(seat.size());seatCheck++)
		{		
			String number = String.format("%02d" , (seatCheck+1));
			if(seat.get(seatCheck).getSeatStatus()==BookingState.Available)
			{			
				SeatDisplayForm seatForm=new SeatDisplayForm((seatCheck+1),""+number+"*");
				seatFormList.add(seatForm);				
			}
			if(seat.get(seatCheck).getSeatStatus()==BookingState.Blocked)
			{			
				SeatDisplayForm seatForm=new SeatDisplayForm((seatCheck+1),""+number+"%");
				seatFormList.add(seatForm);				
			}
			if(seat.get(seatCheck).getSeatStatus()==BookingState.Booked)
			{			
				SeatDisplayForm seatForm=new SeatDisplayForm((seatCheck+1),""+number+"@");
				seatFormList.add(seatForm);				
			}			
		}
		return seatFormList;
	}
	/********************************************************************************************************************
	*       @author           Rama Teja Reddy
	*       Description       It is a service that provides service for updating the seat status from booked to blocked
	*       version           1.0
	*       created date      22-APR-2020
	********************************************************************************************************************/
	
	@Override
	public List<SeatsBookedForm> selectedSeats(int noOfSeats, int showId) {
		List<Seat> seats=dao.getSeats(showId);
		List<SeatsBookedForm> seatsBookedList= new ArrayList<SeatsBookedForm>();
		int count=0;
		for(Seat seatList:seats) {
			if(count<noOfSeats) {
			if(seatList.getSeatStatus()==BookingState.Available) {
				seatList.setSeatStatus(BookingState.Blocked);
				SeatsBookedForm seatBooked=new SeatsBookedForm(seatList.getSeatId()%100);
				seatsBookedList.add(seatBooked);
				count++;
			}
			}			
		}	
		return seatsBookedList;
	}
	
	/********************************************************************************************************************
	*       @author           Rama Teja Reddy
	*       Description       It is a service that provides service for counting the available seats.
	*       version           1.0
	*       created date      23-APR-2020
	 * @throws ShowException 
	********************************************************************************************************************/
	
	@Override
	public Integer countAvailableSeats(int showId) throws ShowException {
		Show show=dao.getShow(showId);
		if(show==null) {
			throw new ShowException("Show id is not available");
		}
		List<Seat> seats=dao.getSeats(showId);		
		int count=0;
		for(Seat seatList:seats) {
			if(seatList.getSeatStatus()==BookingState.Available) {
				count++;
			}			
		}		
		return count;
	}
	/*************************************************************************************************************************
	*       @author           Rama Teja Reddy
	*       Description       It is a service that provides service for comparing the available seats and the tickets booked
	*       version           1.0
	*       created date      23-APR-2020
	 * @throws ShowException 
	**************************************************************************************************************************/
	
	@Override
	public boolean checkAvailableSeats(int showId,int noOfSeats ) throws ShowException {
		int availableSeats=countAvailableSeats(showId);
		if (availableSeats>=noOfSeats) {
			return true;
		}
		return false;
	}
	/********************************************************************************************************************
	*       @author           Rama Teja Reddy
	*       Description       It is a service that provides service for adding booking details
	*       version           1.0
	*       created date      24-APR-2020
	 * @throws ShowException 
	********************************************************************************************************************/
	
	@Override
	public TicketForm addBooking(BookingForm book) throws ShowException {
		Show show = dao.getShow(book.getShowId());
		if(show==null)
		{
			throw new ShowException("show id is not found");
		} 
		int bookingId;
		if(dao.getMaxBookingId(show.getShowId())==null) {
			bookingId= 5000+1;
		}
		else {
			bookingId =dao.getMaxBookingId(show.getShowId())+1;
		}
		Booking booking = new Booking();
		booking.setBookingid(bookingId);
		booking.setNoOfSeats(book.getTkts());
		booking.setBookingDate(LocalDate.now());
		booking.setTicketsBookedDate(book.getTicketsBookedDate());
		booking.setShow(show);
		booking.setTotalCost(book.getTotalCost());
		for(SeatsForm seats:book.getSeatsBooked())
		{
			SeatsBooked seat=new SeatsBooked(bookingId,seats.getSeatNo());
			dao.addSeatBooked(seat);
		}
		TicketForm ticket=generateTicket(book,booking);
		dao.addBooking(booking);
		bookSeats(book.getShowId(),book.getSeatsBooked());
		return ticket;
	}
	/********************************************************************************************************************
	*       @author           Rama Teja Reddy
	*       Description       It is a service that provides service for generating tickets automatically once the booking 
	*                         is done. 
	*       version           1.0
	*       created date      24-APR-2020
	 * @throws ShowException 
	********************************************************************************************************************/
	
	public TicketForm generateTicket(BookingForm booking,Booking bookingDetails)
	{
		int ticketId;
		if(dao.getMaxTicketId()==null) {
			ticketId=6000+1;
		}
		else {
			ticketId=dao.getMaxTicketId()+1;
		}		
		int status=0;
		if(LocalDate.now().compareTo(booking.getTicketsBookedDate())<0) {
			status=1;
		}
		Ticket ticketDetails=new Ticket(ticketId,booking.getTkts(),booking.getCustomerId(),status,bookingDetails);
		dao.addTicket(ticketDetails);		
		Show show=bookingDetails.getShow();
		Theater theater=show.getTheater();
		Movie movie=theater.getMovie();		
		TicketForm ticket=new TicketForm(booking.getTkts(),booking.getSeatsBooked(),movie.getMovieName(),
				theater.getTheaterName(),ticketId,movie.getGenre(),LocalDate.now(),
				booking.getTicketsBookedDate(),movie.getLanguage(),show.getShowstartTime(),booking.getTotalCost());
		return ticket;		
	}
	/********************************************************************************************************************
	*       @author           Rama Teja Reddy
	*       Description       It is a service that provides service for changing the seats status to booked
	*       version           1.0
	*       created date      24-APR-2020
	********************************************************************************************************************/
	
	
	public boolean bookSeats(int showId,List<SeatsForm> seatsBooked) {
		List<Seat> seats=dao.getSeats(showId);
		for(Seat seatList:seats) {
			for(SeatsForm seatNo:seatsBooked) {
			if((seatList.getSeatId()%100)==seatNo.getSeatNo()&&seatList.getSeatStatus()==BookingState.Blocked) {
				seatList.setSeatStatus(BookingState.Booked);
			}
			}
		}
		return true;
	}
	/********************************************************************************************************************
	*       @author           Rama Teja Reddy
	*       Description       It is a service that provides service for canceling the booking details
	*       version           1.0
	*       created date      24-APR-2020
	********************************************************************************************************************/
	
	@Override
	public boolean cancelBooking(int bookingId) throws BookingIdNotFoundException {
		Booking booking = dao.getBookingDetails(bookingId);
		if(booking==null)
		{
			throw new BookingIdNotFoundException("booking id "+bookingId+" is not found");
		}
		dao.removeBooking(booking);
		return true;
	}
	

	/********************************************************************************************************************
	*       @author           Rama Teja Reddy
	*       Description       It is a service that provides service for changing the seats status to Available
	*       version           1.0
	*       created date      24-APR-2020
	********************************************************************************************************************/
		
	@Override
	public boolean unblockSeats(int showId,List<SeatsForm> seatsBooked) {
		List<Seat> seatsList=dao.getSeats(showId);
		for(Seat seatList:seatsList) {
			for(SeatsForm seatNo:seatsBooked)
			if((seatList.getSeatId()%100)==seatNo.getSeatNo()&&seatList.getSeatStatus()==BookingState.Blocked) {
				seatList.setSeatStatus(BookingState.Available);
			}			
		}
		return true;		
	}

	}
