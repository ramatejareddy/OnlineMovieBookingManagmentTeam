package com.cg.movie.service;

import java.util.List;

import com.cg.movie.entity.GenreList;
import com.cg.movie.entity.LanguageList;
import com.cg.movie.entity.Movie;
import com.cg.movie.entity.User;



public interface MovieService {
	
	public boolean addmovie(Movie movie);

	public List<Movie> reteriveActive();
	
	public List<Movie> reteriveInactive();
	
	public List<Movie> reteriveAll();
	
	public List<Movie> findById(int id);
	
	public List<Movie> findByName(String searchMovie);

	public Boolean deletemovie(int id);


	void update(int id, String movieName, String hero, String heroineName, LanguageList language, String director,
			GenreList genre, boolean activestatus);
    
  

}