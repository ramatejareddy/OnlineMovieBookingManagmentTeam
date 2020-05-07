package com.cg.movie.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movie.entity.Movie;
import com.cg.movie.entity.User;
import com.cg.movie.exception.MovieException;
import com.cg.movie.exception.UserNamePasswordNotProvidedException;
import com.cg.movie.service.UserService;
import com.cg.movie.service.MovieService;
//import com.cg.springbootjpa.model.Users;





@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MovieController {
	
	@Autowired
	MovieService movieservice;
	@Autowired
	UserService userService;
	
	@PostMapping("/Admin/AddMovie")
	public ResponseEntity<String> addMovie(@RequestBody Movie movieobject) {
		if(movieobject.getMovieName().contentEquals("null")) throw new MovieException("Empty Name not allowed");
        movieservice.addmovie(movieobject);
        
		return new ResponseEntity<String>("Movie Added",HttpStatus.OK);
	}
	
	@GetMapping("/User/Active-Movies")
    public ResponseEntity<List<Movie>> getActiveMovieList() {
			List<Movie> list = movieservice.reteriveActive();
			return new ResponseEntity<List<Movie>>(list,HttpStatus.OK);
	}
	@GetMapping("/User/Inactive-Movies")
    public ResponseEntity<List<Movie>> getInactiveMovieList() {
			List<Movie> list = movieservice.reteriveInactive();
			return new ResponseEntity<List<Movie>>(list,HttpStatus.OK);
	}
	@GetMapping("/Admin/Movies")
    public ResponseEntity<List<Movie>> getAllMovieList() {
			List<Movie> list = movieservice.reteriveAll();
			return new ResponseEntity<List<Movie>>(list,HttpStatus.OK);
	}
	@DeleteMapping("/Admin/DeleteMovie/{id}")
	public ResponseEntity<String> deleteMovie(@PathVariable int id)
	{
		
		Boolean status = movieservice.deletemovie(id);
		if(!status)throw new MovieException("Movie not found.");
		
		return new ResponseEntity<String>("Movie Deleted", HttpStatus.OK);
//	return new ResponseEntity<>(HttpStatus.OK);	
	}
	@GetMapping("/Admin/Movie/{id}")
	public ResponseEntity <List<Movie>> getById(@PathVariable int id)
	{
		List<Movie> movieList=movieservice.findById(id);
		return new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/User/SearchMovie/{name}")
	public ResponseEntity <List<Movie>> viewMovie(@PathVariable String name)
	{
		List<Movie> list = movieservice.findByName(name);
		return new ResponseEntity<List<Movie>>(list,HttpStatus.OK);
		/*Movie movieobject=movieservice.findByName(movieName);
		return new ResponseEntity<Movie>(movieobject,HttpStatus.OK);*/
		
	}
	@PutMapping("/Admin/UpdateMovie/{id}")
	public ResponseEntity<Object> updateMovie(@PathVariable("id") int id, @RequestBody Movie movieobject)
	{
		movieservice.update(id, movieobject.getMovieName(),movieobject.getHero(),movieobject.getHeroine(), movieobject.getLanguage(), movieobject.getDirector(), movieobject.getGenre(),movieobject.isActiveStatus());
		return new ResponseEntity<>("Movie Updated",HttpStatus.OK);
	}
	

	@GetMapping("/Login/Validate/{name}/{password}")
	public int validateLogin(@PathVariable String name,@PathVariable String password)
	{
		if(name.contentEquals("null") || password.contentEquals("null"))
		{ 
			throw new UserNamePasswordNotProvidedException("UserName or Password Should Not be Empty");
		}
		else
		return userService.validateLogin(name, password);
	}
	
	@PostMapping("/SignUp/Register")
	public ResponseEntity<String> signUp(@RequestBody User userobject) {
//		if(userobject.getName().contentEquals("null")) throw new MovieException("Empty Name not allowed");
        userService.signUp(userobject);
        
		return new ResponseEntity<String>("User Successfully Created",HttpStatus.OK);
	}
	
	/*
	 * @GetMapping("/User/UserName/{name}") public List<Customer>
	 * getEmployeeByUserName(@PathVariable String name) { return
	 * userService.getUserByUserName(name); }
	 */

//	@GetMapping("/User/custId/{name}")
//	public int getIdByName(@PathVariable String name)
//	{
//		return userService.getIdByName(name);
//	}
	
	@GetMapping("/Login/LoginDetails/{name}")
	public User loginDetails(@PathVariable String name)
	{
		return userService.loginDetails(name);
	}


	@PutMapping("/Login/ChangePassword")
	public boolean changePassword(@RequestBody User login)
	{
	return userService.changePassword(login);	
	}


}
