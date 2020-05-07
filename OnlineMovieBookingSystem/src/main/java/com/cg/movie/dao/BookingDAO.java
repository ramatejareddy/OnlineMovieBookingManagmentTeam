package com.cg.movie.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.movie.entity.Booking;
import com.cg.movie.entity.Movie;
import com.cg.movie.entity.Seat;
import com.cg.movie.entity.SeatsBooked;
import com.cg.movie.entity.Show;
import com.cg.movie.entity.Theater;
import com.cg.movie.entity.Ticket;
import com.cg.movie.exception.MovieIdNotFoundException;

@Repository
public class BookingDAO implements BookingDAOInterface{
	@PersistenceContext
	EntityManager entityManager;
	
	/**************************************************************************************************
     *Method:getPrice
     *description:To fetch the seats  from database.
     *seatId                -fetches the details of that particular id
     *@returns                 -the seat  details
     *@throws SeatException -it is raised due to invalid id
     *created by               -Rama Teja Reddy
     *created date             -21-APR-2020
**************************************************************************************************/
	@Override
	public Seat getSeat(int showId) {		
		String jpql="from Seat seat inner join fetch seat.show s where s.showId=:mid";
		TypedQuery<Seat> query=entityManager.createQuery(jpql, Seat.class);
		query.setParameter("mid", showId);
		List<Seat> seatList=query.getResultList();
		return seatList.get(1);
	}
	/**************************************************************************************************
     *Method:                   getTheater
     *description:              To fetch the theater list from the database based on the movie id
     *@returns                 -the theater list 
     *@throws MovieIdNotFoundException -it is raised due to invalid movieId
     *created by               -Rama Teja Reddy
     *created date             -21-APR-2020
**************************************************************************************************/
	
	@Override
	public List<Theater> getTheater(int movieId) {
		String jpql = "from Theater t inner join fetch t.movie m where m.movieId=:mid";
		TypedQuery<Theater> query = entityManager.createQuery(jpql, Theater.class);
		
		query.setParameter("mid", movieId);
				return query.getResultList();
	}
	/**************************************************************************************************
     *Method:                   getMovie
     *description:              To fetch the Movie from the database based on the movie id
     *@returns                 -the movie 
     *@throws MovieIdNotFoundException -it is raised due to invalid  movieId
     *created by               -Rama Teja Reddy
     *created date             -21-APR-2020
**************************************************************************************************/
	

	@Override
	public Movie getMovie(int movieId) {
       Movie movie=entityManager.find(Movie.class, movieId);		
		return movie;		
	}
	/**************************************************************************************************
     *Method:                   getMovie
     *description:              To fetch the Movie from the database based 
     *@returns                 -the movie 
     *@throws MovieIdNotFoundException -it is raised due to invalid  movieId
     *created by               -Rama Teja Reddy
     *created date             -21-APR-2020
**************************************************************************************************/
	
	
	@Override
	public List<Movie> getMovie() {
		String jpql="from Movie movie";
		TypedQuery<Movie> query=entityManager.createQuery(jpql,Movie.class);
		return query.getResultList();
	}
	
	/**************************************************************************************************
     *Method:                   getShowList
     *description:              To fetch the show list from the database based on the theater id
     *@returns                 -the show list 
     *@throws theaterIdNotFoundException -it is raised due to invalid theater Id
     *created by               -Rama Teja Reddy
     *created date             -21-APR-2020
**************************************************************************************************/
	

	@Override
	public List<Show> getShowList(int theaterId) {
		String jquery="from Show show inner join fetch show.theater theater where theater.theaterId=:mid";
		TypedQuery<Show> query=entityManager.createQuery(jquery,Show.class);
		query.setParameter("mid",theaterId);
		return query.getResultList();
	}
		

	/**************************************************************************************************
     *Method:                   getSeats
     *description:              To fetch the seat list from the database based on the show id
     *@returns                 -the seat list 
     *@throws ShowException -it is raised due to invalid showId
     *created by               -Rama Teja Reddy
     *created date             -22-APR-2020
**************************************************************************************************/
		

	@Override
	public List<Seat> getSeats(int showId) {
		String jpql="from Seat seat inner join fetch seat.show s where s.showId=:mid";
		TypedQuery<Seat> query = entityManager.createQuery(jpql,Seat.class);
		query.setParameter("mid", showId);
		return query.getResultList();
	}

	/**************************************************************************************************
     *Method:                   getShow
     *description:              To fetch the particular show from the database based on the show id
     *@returns                 -show 
     *@throws ShowException -it is raised due to invalid showId
     *created by               -Rama Teja Reddy
     *created date             -22-APR-2020
**************************************************************************************************/
		
	@Override
	public Show getShow(int showId) {
		Show show=entityManager.find(Show.class, showId);
		
		
		return show;
	}
	/**************************************************************************************************
     *Method:                   getMaxBookingId
     *description:              To max booking id of bookings till now  done
     *@returns                 -max of booking
     *@throws ShowException -it is raised due to invalid showId
     *created by               -Rama Teja Reddy
     *created date             -23-APR-2020
**************************************************************************************************/
	

	@Override
	public Integer getMaxBookingId(int showId) {
		String jpql = "select max(bookingid) from Booking b ";
		TypedQuery<Integer> query = entityManager.createQuery(jpql, Integer.class);
		return query.getSingleResult();
	}
	/**************************************************************************************************
     *Method:                   addBooking
     *description:              To inset the booking details into the database
     *@returns                 -boolean
     *created by               -Rama Teja Reddy
     *created date             -23-APR-2020
**************************************************************************************************/
	


	@Override
	public boolean addBooking(Booking booking) {
		entityManager.persist(booking);
		return true;
		
	}

	/**************************************************************************************************************
     *Method:                   getBookingDetails
     *description:              To fetch the particular booking details from the database based on the booking id
     *@returns                 -Booking 
     *@throws BookingIdNotFoundException -it is raised due to invalid bookingId
     *created by               -Rama Teja Reddy
     *created date             -24-APR-2020
*******************************************************************************************************************/
	
	@Override
	public Booking getBookingDetails(int bookingId) {
		Booking booking=entityManager.find(Booking.class, bookingId);
		return booking;
	}

	/**************************************************************************************************
     *Method:                   removeBooking
     *description:              To remove the particular booking details  
     *@returns                 -boolean 
     *created by               -Rama Teja Reddy
     *created date             -24-APR-2020
**************************************************************************************************/
	
	@Override
	public boolean removeBooking(Booking booking) {
		entityManager.remove(booking);
	
		return true;
	}

	/**************************************************************************************************
     *Method:                   getseatBooked
     *description:              To insert the seats booked into the database 
     *@returns                 -void 
     *created by               -Rama Teja Reddy
     *created date             -24-APR-2020
**************************************************************************************************/
	

	@Override
	public void addSeatBooked(SeatsBooked seat) {
		entityManager.persist(seat);
	
	}
	
	/**************************************************************************************************
     *Method:                   getMaxTicketId
     *description:              To max Ticket id of bookings till now  done
     *@returns                 -max of ticket Id
     *created by               -Rama Teja Reddy
     *created date             -24-APR-2020
**************************************************************************************************/
	


	@Override
	public Integer getMaxTicketId() {
		String jpql = "select max(ticketId) from Ticket ticket ";
		TypedQuery<Integer> query = entityManager.createQuery(jpql, Integer.class);
		return query.getSingleResult();
		
	}

	/**************************************************************************************************
     *Method:                   addTicket
     *description:              To insert the tickets generated into the database 
     *@returns                 -boolean 
     *created by               -Rama Teja Reddy
     *created date             -24-APR-2020
**************************************************************************************************/
	

	@Override
	public boolean addTicket(Ticket ticketDetails) {
		entityManager.persist(ticketDetails);
		return true;
	}
		
}
