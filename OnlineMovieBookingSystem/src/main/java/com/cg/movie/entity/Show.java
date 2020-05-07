package com.cg.movie.entity;


import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="lpu_movie_show")
public class Show {
	@Id
	@Column(name="show_id")
	private int showId;
	@Column(name="show_name", length=25)
	private String showName;
	@Column(name="seats")
	private int seats;
	@Column(name="screen_name", length=25)
	private String screenName;
	@Column(name="show_start_time")
	private LocalDateTime showstartTime;
	@Column(name="show_date")
	private Date showDate;
	
	
	
	@ManyToOne
	@JoinColumn(name="theaterId", referencedColumnName = "theaterId")
	private Theater theater;

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public LocalDateTime getShowstartTime() {
		return showstartTime;
	}

	public void setShowstartTime(LocalDateTime showstartTime) {
		this.showstartTime = showstartTime;
	}

	

	
	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public Show(int showId, String showName, int seats, String screenName, LocalDateTime showstartTime, Date showDate,
			Theater theater) {
		super();
		this.showId = showId;
		this.showName = showName;
		this.seats = seats;
		this.screenName = screenName;
		this.showstartTime = showstartTime;
		this.showDate = showDate;
		this.theater = theater;
	}

	public Show() {
		
	}

}