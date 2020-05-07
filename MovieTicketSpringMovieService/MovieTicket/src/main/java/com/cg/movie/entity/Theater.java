package com.cg.movie.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="lpu_movie_theater")
public class Theater{
	@Id
	@Column(name="theaterId")
	private int theaterId;
	@Column(name="theaterName",length=25,nullable=false)
	private String theaterName;
	@Column(name="theaterCity",length=25,nullable=false)
	private String theaterCity;
	@Column(name ="managerName",length=25,nullable=false)
	private String managerName;
	@Column(name ="managerContact",length=10,nullable=false)
	private int managerContact;
	@ManyToOne
	@JoinColumn(name="movieId", referencedColumnName = "movie_Id")
	private Movie movie;
	
	
	public String getTheaterCity() {
		return theaterCity;
	}
	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public int getManagerContact() {
		return managerContact;
	}
	public void setManagerContact(int managerContact) {
		this.managerContact = managerContact;
	}
	public int getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	
	
	
}
