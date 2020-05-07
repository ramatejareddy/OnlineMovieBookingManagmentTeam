package com.cg.movie.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;



public class TicketForm {
	int noOfTickets;
	List<SeatsForm> seatsBooked;
	double totalCost;
	
	String movieName;
	String theaterName;
	int ticketId;
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	String genere;
	@JsonFormat(pattern="yyyy-MM-dd")
	LocalDate bookingDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	LocalDate ticketsBookedDate;
	String language;
	LocalDateTime showStartTime;
	
	
	
	public LocalDateTime getShowStartTime() {
		return showStartTime;
	}
	public void setShowStartTime(LocalDateTime showStartTime) {
		this.showStartTime = showStartTime;
	}
	public int getNoOfTickets() {
		return noOfTickets;
	}
	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	
	
	public List<SeatsForm> getSeatsBooked() {
		return seatsBooked;
	}
	public void setSeatsBooked(List<SeatsForm> seatsBooked) {
		this.seatsBooked = seatsBooked;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public LocalDate getTicketsBookedDate() {
		return ticketsBookedDate;
	}
	public void setTicketsBookedDate(LocalDate ticketsBookedDate) {
		this.ticketsBookedDate = ticketsBookedDate;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public TicketForm(int noOfTickets, List<SeatsForm> seatsBooked, String movieName, String theaterName, int ticketId,
			String genere, LocalDate bookingDate, LocalDate ticketsBookedDate, String language,
			LocalDateTime showStartTime,double totalCost) {
	
		this.noOfTickets = noOfTickets;
		this.seatsBooked = seatsBooked;
		this.movieName = movieName;
		this.theaterName = theaterName;
		this.ticketId = ticketId;
		this.genere = genere;
		this.bookingDate = bookingDate;
		this.ticketsBookedDate = ticketsBookedDate;
		this.language = language;
		this.showStartTime = showStartTime;
		this.totalCost=totalCost;
	}
	
	
}
