package com.cg.movie.dao;

import java.util.List;

import com.cg.movie.entity.User;

public interface UserDao {
	
	public int signUp(User user);	

	public int generateUserId(User Id);
	
    public List<User> getUserByUserName(String name);
	
	public int validateLogin(String userName,String password);
		
	public User loginDetails(String name);
	
	public boolean changePassword(User login);
	
	public int getIdByName(String name);
	
	public int userExistsOrNot(String userName); 
	
	public int signUpValidate(String contact);

}
