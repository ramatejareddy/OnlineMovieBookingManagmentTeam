package com.cg.movie.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookingForm {
	private int showId;
	private int tkts;
	private int customerId;
	private double totalCost;
	List<SeatsForm> seatsBooked;
	@JsonFormat(pattern="yyyy-MM-dd")
	LocalDate ticketsBookedDate;
	public LocalDate getTicketsBookedDate() {
		return ticketsBookedDate;
	}
	public void setTicketsBookedDate(LocalDate ticketsBookedDate) {
		this.ticketsBookedDate = ticketsBookedDate;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	public List<SeatsForm> getSeatsBooked() {
		return seatsBooked;
	}
	public void setSeatsBooked(List<SeatsForm> seatsBooked) {
		this.seatsBooked = seatsBooked;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public int getTkts() {
		return tkts;
	}
	public void setTkts(int tkts) {
		this.tkts = tkts;
	}
	public BookingForm(int showId,int tkts,int customerId)
	{
		this.showId=showId;
		this.tkts=tkts;
		this.customerId=customerId;
	}

}
