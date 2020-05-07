package com.cg.movie.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.cg.movie.entity.GenreList;
import com.cg.movie.entity.LanguageList;
import com.cg.movie.entity.Movie;
import com.cg.movie.entity.Theater;
import com.cg.movie.entity.User;

/****************************
 *          @author          Javvadi Sai Krishna
 *          Description      It is a Dao implementation class that provides the methods for adding a new movie,
 *          ,delete movie,update movie,find movie,viewing all the movies  
  *         Version             1.0
  *         Created Date    19-APR-2020
 ****************************/
@Transactional
@Repository
public class MovieImp implements MovieDao{
	
	@PersistenceContext
	EntityManager entitymanagerobject;
	/**************************************************************************************************
     *Method:     addmovie
     *description:   Add the paticular record of movie class
     *@returns                 -return nothing
     *@throws MovieException   -it is raised for not entering  movie_id
     *created by               -Javvadi Sai Krishna
     *created date             -21-APR-2020
**************************************************************************************************/
	@Override
	public boolean addmovie(Movie movie) 
	{
		if(true)
		{
		
			entitymanagerobject.persist(movie);
			return true;
		}
		
		return false;

	}
	
	/**************************************************************************************************
     *Method:    reterive
     *description:   display all the records of movie
     *@returns                 -List of movies details
     *created by               -Javvadi Sai Krishna
     *created date             -21-APR-2020
**************************************************************************************************/
	


	@Override
	public List<Movie> reteriveActive() {
		String Qstr = "SELECT movie from Movie movie Where active_status=true";
		TypedQuery<Movie> query = entitymanagerobject.createQuery(Qstr,Movie.class);
		return query.getResultList();
	}
	
	@Override
	public List<Movie> reteriveInactive() {
		String Qstr = "SELECT movie from Movie movie Where active_status=false";
		TypedQuery<Movie> query = entitymanagerobject.createQuery(Qstr,Movie.class);
		return query.getResultList();
	}
	@Override
	public List<Movie> reteriveAll() {
		String Qstr = "SELECT movie from Movie movie ";
		TypedQuery<Movie> query = entitymanagerobject.createQuery(Qstr,Movie.class);
		return query.getResultList();
	}
	
	/**************************************************************************************************
     *Method:     findByName
     *description:   display the particular record by id
     *movieId                  -fetches the details of that particular Name
     *@returns                 -movie details
     *@throws MovieException   -it is raised due to invalid id or no data present
     *created by               -Javvadi Sai Krishna
     *created date             -21-APR-2020
     **************************************************************************************************/
	


	@Override
	public List<Movie> findByName(String searchMovie) {
		 searchMovie = searchMovie.toLowerCase();
		String Qstr="SELECT movie from Movie movie Where (LOWER(movie.movieName)=:name or LOWER(movie.hero)=:name or LOWER(movie.heroine)=:name or LOWER(movie.language)=:name or movie.movieName=:name or movie.hero=:name or movie.heroine=:name or movie.language=:name) And movie.activeStatus=true ";
		TypedQuery<Movie> query = entitymanagerobject.createQuery(Qstr,Movie.class);
		query.setParameter("name",searchMovie);
		return query.getResultList();
		
		
		
		
	}
	/**************************************************************************************************
     *Method:     deletemovie
     *description:   delete the paticular record by id
     *movieId                  -deletes the details of that particular id
     *@returns                 -return nothing
     *@throws movieException   -it is raised due to invalid id or no data present
     *created by               -Javvadi Sai Krishna
     *created date             -21-APR-2020
     **************************************************************************************************/
	

    @Transactional
	@Override
	public void deletemovie(int id) {
	Movie movieobject = entitymanagerobject.find(Movie.class, id);
    Query Qstr = entitymanagerobject.createQuery("UPDATE Movie SET active_status=false Where movie_id=:id");
    Qstr.setParameter("id", movieobject.getMovieId());
    Qstr.executeUpdate();	
	}
	/**************************************************************************************************
     *Method:     update
     *description:   display the paticular record by id
     *movieid                  -fetches the details of that particular id
     *@returns                 -return nothing
     *@throws MovieException   -it is raised due to invalid id
     *created by               -Javvadi Sai Krishna
     *created date             -21-APR-2020
**************************************************************************************************/
	


	@Override
	public void update(int id,String name,String hero,String heroine,LanguageList language,String director,GenreList genre,boolean activestatus) {
		Movie movieobject = entitymanagerobject.find(Movie.class, id);
		movieobject.setMovieName(name);
		movieobject.setHero(hero);
		movieobject.setHeroine(heroine);
		movieobject.setDirector(director);
		movieobject.setLanguage(language);
		
		movieobject.setGenre(genre);
		movieobject.setActiveStatus(activestatus);
		
	}

	@Override
	public List<Movie> findById(int id) {
		List<Movie> list=new ArrayList<Movie>();
		Movie movieobject = entitymanagerobject.find(Movie.class, id);
		list.add(movieobject);
		return list;
	}
	
	
}