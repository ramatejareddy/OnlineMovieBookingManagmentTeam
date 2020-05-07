package com.cg.movie.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.movie.dao.MovieDao;
import com.cg.movie.exception.MovieException;
import com.cg.movie.exception.MovieNotFoundException;
import com.cg.movie.exception.NoActiveMoviesFoundException;
import com.cg.movie.exception.NoInactiveMoviesFoundException;
import com.cg.movie.exception.NoMoviesFoundException;
import com.cg.movie.entity.GenreList;
import com.cg.movie.entity.LanguageList;
import com.cg.movie.entity.Movie;
import com.cg.movie.entity.User;


@Transactional
@Service
public class MovieServiceImp implements MovieService{
	
	@Autowired
	MovieDao moviedao;
	
	/********************************************************************************************************************
	*       @author           javvadi Sai Krishna
	*       Description       It is a service that provides service for manipulating movie details
	*       version           1.0
	*       created date      21-APR-2020
	********************************************************************************************************************/
	
	
	@Override
	public boolean addmovie(Movie movie) {
		boolean b=moviedao.addmovie(movie);
		if(b==true)
		{
			System.out.println("Added SucessFully");
		    return true;
		}
		else
		{
			System.out.println("Not Added");
			return false;
		}
		
	}

	@Override
	public List<Movie> reteriveActive() {
		if(moviedao.reteriveActive().size()>0) 
		return moviedao.reteriveActive();
		else
		throw new NoActiveMoviesFoundException("No Movies Available");
	}
	
	@Override
	public List<Movie> reteriveInactive() {
		if(moviedao.reteriveInactive().size()>0) {
			List<Movie> movielist=moviedao.reteriveInactive();
			return movielist;}
			throw new NoInactiveMoviesFoundException("No Movies Missed");
	}
	
	@Override
	public List<Movie> reteriveAll() {
		if(moviedao.reteriveAll().size()>0) {
			List<Movie> movielist=moviedao.reteriveAll();
			return movielist;}
			throw new NoMoviesFoundException("No Movies Found");
	}

	@Override
	public List<Movie> findByName(String searchMovie) {
		
		if(moviedao.findByName(searchMovie).size()==0)
			throw new MovieNotFoundException("Movie with Name "+searchMovie+" not found");
	   else
		return moviedao.findByName(searchMovie);
	}

	@Override
	public Boolean deletemovie(int id) {
		moviedao.deletemovie(id);
		return null;
		
	}

	@Override
	public void update(int id,String movieName,String hero,String heroineName,LanguageList language,String director,GenreList genre,boolean activestatus) {
		moviedao.update(id,movieName,hero,heroineName,language,director,genre,activestatus);
		
	}

	@Override
	public List<Movie> findById(int id) {
		
		return moviedao.findById(id);
	}
	
	
}
