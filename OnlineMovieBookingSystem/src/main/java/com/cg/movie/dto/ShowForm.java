package com.cg.movie.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.movie.entity.Movie;
import com.cg.movie.entity.Show;

public class ShowForm {

	 private String theaterName;
	 private String theaterCity;
	 
	 private List<Show> show;
	 private Movie movie;
	 public List<Show> getShow() {
		return show;
	}
	public void setShow(List<Show> show) {
		this.show = show;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getTheaterCity() {
		return theaterCity;
	}
	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}
	public ShowForm(String theaterName, String theaterCity, List<Show> show, Movie movie) {
		
		this.theaterName = theaterName;
		this.theaterCity = theaterCity;
		this.show = show;
		this.movie = movie;
	}

	
	
	
	
	

}
