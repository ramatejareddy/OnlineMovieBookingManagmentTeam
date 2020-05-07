package com.cg.movie.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="lpu_movie_movie")
public class Movie {
	
	@Id
	@Column(name="movie_id")
	private int movieId;
	
	@NotEmpty(message="Movie Name should be Mandatory")
	@Column(name="movie_name", length=30,nullable=false)
	private String movieName;
	
	@NotEmpty(message="Movie hero name should be Mandatory")
	@Column(name="hero", length=25,nullable=false)
	private String hero;
	
	@NotEmpty(message="Movie herione name should be Mandatory")
	@Column(name="heroine", length=25,nullable=false)
	private String heroine;
	
	@Enumerated(EnumType.STRING)
	private LanguageList language;
	
	@NotEmpty(message="Movie director name should be Mandatory")
	@Column(name="director", length=25,nullable=false)
	private String director;
	
	@Enumerated(EnumType.STRING)
	private GenreList genre;
	
	
	@Column(name="active_status")
	
	private boolean activeStatus;


	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language + ", hero=" + hero
				+ ", heroine=" + heroine + ", director=" + director + ", genre=" + genre + ", activeStatus="
				+ activeStatus + "]";
	}


	public Movie(int movieId, @NotEmpty(message = "Movie Name should be Mandatory") String movieName,
			@NotEmpty(message = "Movie language should be Mandatory") LanguageList language,
			@NotEmpty(message = "Movie hero should be Mandatory") String hero,
			@NotEmpty(message = "Movie heroine should be Mandatory") String heroine,
			@NotEmpty(message = "Movie director should be Mandatory") String director,
			@NotEmpty(message = "Movie genre should be Mandatory") GenreList genre, boolean activeStatus) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.language = language;
		this.hero = hero;
		this.heroine = heroine;
		this.director = director;
		this.genre = genre;
		this.activeStatus = activeStatus;
	}


	public String getHero() {
		return hero;
	}


	public void setHero(String hero) {
		this.hero = hero;
	}


	public String getHeroine() {
		return heroine;
	}


	public void setHeroine(String heroine) {
		this.heroine = heroine;
	}


	public int getMovieId() {
		return movieId;
	}


	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public LanguageList getLanguage() {
		return language;
	}


	public void setLanguage(LanguageList language2) {
		this.language = language2;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public GenreList getGenre() {
		return genre;
	}


	public void setGenre(GenreList genre) {
		this.genre = genre;
	}


	public boolean isActiveStatus() {
		return activeStatus;
	}


	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}




	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	
	
	
	
	
	
}

