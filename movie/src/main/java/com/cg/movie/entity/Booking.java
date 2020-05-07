package com.cg.movie.entity;



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
	@Column(name="booking_id")
	private int bookingid;
	@Column(name="no_of_seats")
	private int noOfSeats;
	@Column(name="total_cost")
	private double totalCost;
	@Column(name="user_name")
	private String userName;
	@Column(name="contact")
	private String contact;
	@ManyToOne
	@JoinColumn(name="show_id", referencedColumnName = "show_id")
	private Show show;
	

}
