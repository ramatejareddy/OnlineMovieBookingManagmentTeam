package com.cg.movie.dao;

import java.util.List;

import com.cg.movie.entity.GenreList;
import com.cg.movie.entity.LanguageList;
import com.cg.movie.entity.Movie;
import com.cg.movie.entity.User;
/*
   @author        Javvadi Sai Krishna
   Description    It is Dao Interface which is used to manipulate movie entity
   Version         1.0
   Created Date   22-April-2020
  */



public interface MovieDao {

	
	
	public boolean addmovie(Movie movie);
	
	public List<Movie> reteriveActive();
	
	public List<Movie> reteriveInactive();
	
	public List<Movie> reteriveAll();
	
	public List<Movie> findByName(String searchMovie);
	
	public List<Movie> findById(int id);
	
	public void deletemovie(int id);
	
	public void update(int id,String movieName,String hero,String heroine,LanguageList language,String director,GenreList genre ,boolean activestatus );
		
	

}
