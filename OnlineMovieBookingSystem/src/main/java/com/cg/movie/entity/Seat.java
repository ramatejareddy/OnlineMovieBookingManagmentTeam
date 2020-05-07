package com.cg.movie.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


@Entity


@Table(name="lpu_movie_seat")
public class Seat {
	

@Id
@Column(name="seat_id")
private int seatId;
@Enumerated(EnumType.STRING)
private BookingState seatStatus;

@Column(name="seat_Price")
private double seatPrice;
@ManyToOne
@JoinColumn(name="show_id", referencedColumnName = "show_id")
private Show show;
public int getSeatId() {
	return seatId;
}
public void setSeatId(int seatId) {
	this.seatId = seatId;
}

public BookingState getSeatStatus() {
	return seatStatus;
}
public void setSeatStatus(BookingState seatStatus) {
	this.seatStatus = seatStatus;
}
public double getSeatPrice() {
	return seatPrice;
}
public void setSeatPrice(double seatPrice) {
	this.seatPrice = seatPrice;
}





}
