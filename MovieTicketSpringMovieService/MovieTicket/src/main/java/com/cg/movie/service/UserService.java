package com.cg.movie.service;

import java.util.List;

import com.cg.movie.entity.Movie;
import com.cg.movie.entity.User;

public interface UserService {
	
	    public int signUp(User user);

	    public List<User> getUserByUserName(String name);
		
		public int validateLogin(String userName,String password);
			
		public User loginDetails(String name);
		
		public boolean changePassword(User login);
		
		public int getIdByName(String name);

}
