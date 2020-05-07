package com.cg.movie.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.movie.dao.UserDao;
import com.cg.movie.entity.Movie;
import com.cg.movie.exception.ContactAndUserNameExistsException;
import com.cg.movie.exception.ContactOrUserNameExistsException;
import com.cg.movie.exception.UserNamePasswordInvalidException;
import com.cg.movie.entity.User;
import com.cg.movie.exception.UserNotFoundException;

@Service
public class UserServiceImp implements UserService {
     
	@Autowired
	UserDao userDao;
	
		
	@Override
	public int signUp(User user) {
		
		int num=userDao.signUpValidate(user.getContact());
		int numN=userDao.userExistsOrNot(user.getUserName());
		if(num==1 && numN==1)
		{
			throw new ContactAndUserNameExistsException("User with this mobile number and UserName already exists,either signin or try with different userName and Contact");
		}
		else if (num==1 || numN==1)
		{
			throw new ContactOrUserNameExistsException("UserName or Contact number already exists ,try differenr one's");
		}
	
		else
		{
		
		
		int b=userDao.generateUserId(user);
		if(b!=0)
		{
			user.setUserId(b+1);
			user.setIsAdmin(false);
			userDao.signUp(user);			
//			System.out.println("User Successfully Created ");
			return 1;
		}
		else
		{
			System.out.println("Not Added");
			return 0;
		}
		}
		
	}
	
	
	
	
	public int getIdByName(String name)
	{
		return userDao.getIdByName(name);
	}
	
	public List<User> getUserByUserName(String name)
	{
		return userDao.getUserByUserName(name);
	}
	
	public int validateLogin(String userName,String password)
	{
		     int user=userDao.userExistsOrNot(userName);
		     int user1=userDao.validateLogin(userName, password);
	         if(user==0) 
	                    {
		                      throw new UserNotFoundException("User does not exist");	
	                    }
	         else
	                    {	
	        	 
	        	            if(user1==0) {

                                throw new UserNamePasswordInvalidException("UserName or Password Invalid");
	        	            }
	        	 
	        	 
		                  return userDao.validateLogin(userName, password);
	                    }
}


	public User loginDetails(String name)
	{
		return userDao.loginDetails(name);
	}
	
	@Transactional
	public boolean changePassword(User login)
	{
		return userDao.changePassword(login);
	}

	
}
