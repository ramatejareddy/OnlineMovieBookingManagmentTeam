package com.cg.movie.entity;



import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="lpu_movie_booking")
public class Booking {
	@Id
	@Column(name="booking_id",length=6)
	private int bookingid;
	@Column(name="no_of_seats",nullable=false)
	private int noOfSeats;
	@Column(name="booking_date",nullable=false)
	private LocalDate bookingDate;
	@Column(name="total_cost",nullable=false)
	private double totalCost;
	@ManyToOne
	@JoinColumn(name="show_Id", referencedColumnName = "show_id")
	private Show show;
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}


}
