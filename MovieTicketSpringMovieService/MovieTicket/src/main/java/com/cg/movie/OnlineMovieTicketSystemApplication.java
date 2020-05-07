package com.cg.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.movie.service.MovieService;
import com.cg.movie.service.UserService;

@SpringBootApplication

public class OnlineMovieTicketSystemApplication implements CommandLineRunner{

	@Autowired
	MovieService movieservice ;
	@Autowired
	UserService user;
	public static void main(String[] args) {
		SpringApplication.run(OnlineMovieTicketSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(movieservice.findByName("bahubali"));
	}

}
