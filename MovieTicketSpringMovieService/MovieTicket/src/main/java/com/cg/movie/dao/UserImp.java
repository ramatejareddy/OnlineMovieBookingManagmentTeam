package com.cg.movie.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.movie.entity.Movie;
import com.cg.movie.entity.User;

@Transactional
@Repository
public class UserImp implements UserDao{
	
	@PersistenceContext
	EntityManager entitymanagerobject;
	static int a1=2000;
	
	@Override
	public int signUp(User user) 
	{
		
			entitymanagerobject.persist(user);
			
			return user.getUserId();
	

	}
	

	
	

	public List<User> getUserByUserName(String name)
	{
		List<User> empList = new ArrayList<User>();
		int id = getIdByName(name);
		User customer = entitymanagerobject.find(User.class,id);
		empList.add(customer);
		return empList;
		
	}
	

	public int validateLogin(String userName,String password)
	{
	 
	
		List<User> passList = new ArrayList();
		
		String str = "select login from User login where login.userName = :name";
		TypedQuery<User> query = entitymanagerobject.createQuery(str,User.class);
		query.setParameter("name",userName);
		
		passList = query.getResultList();
		//&& passList.get(0).getLoginType().equals("employee")
		if(passList.size()>0)
		{
		if(passList.get(0).getPassword().equals(password) && passList.get(0).getIsAdmin()==false )
			
			return 1;
		else if(passList.get(0).getPassword().equals(password) && passList.get(0).getIsAdmin()==true )
			
			return 2;
		else 
		  return 0;
		}
		else
		{
			return 0;
		}
		
		
		}
	
	
	
	public User loginDetails(String name)
	{
	User login = entitymanagerobject.find(User.class,name);
	return login;
		
	}
	
	public boolean changePassword(User login)
	{
		User loginObj = entitymanagerobject.find(User.class,login.getUserName());
		loginObj.setPassword(login.getPassword());
		return true;
	}


	@Override
	public int getIdByName(String name) {
        User login = entitymanagerobject.find(User.class, name);
		
		
		return login.getUserId();
	}
        @Override
	public int generateUserId(User id) {
        	String qStr = "SELECT contact FROM User";
		
		TypedQuery<String> query = entitymanagerobject.createQuery(qStr, String.class);

		List<String> user = query.getResultList();
		String qStr1 = "SELECT userName FROM User";
		TypedQuery<String> query2 = entitymanagerobject.createQuery(qStr1, String.class);
		List<String> user1 = query2.getResultList();
		if ( !user.contains(id.getContact()) &&  (!user1.contains(id.getUserName())) && !user.isEmpty()) {
			String Str = "SELECT max(userId) FROM User";
			TypedQuery<Integer> query1 = entitymanagerobject.createQuery(Str, Integer.class);
			int num = query1.getSingleResult();
			return num; 
		} else if (user.isEmpty()) {
			return a1; 
		} else {
			return 0; 
		}
	}

        public int userExistsOrNot(String userName) {
        	
        	List<User> passList = new ArrayList();
        	String str = "select login from User login where login.userName = :name";
    		TypedQuery<User> query = entitymanagerobject.createQuery(str,User.class);
    		query.setParameter("name",userName);
    		
    		passList = query.getResultList();
    		if(passList.size()>0) {
    			return 1;
    		}
    		else 
    			return 0;
        	
        	
        }
        
        public int signUpValidate(String contact) {
        	
        	List<User> passList = new ArrayList();
        	String str = "select login from User login where login.contact = :number";
    		TypedQuery<User> query = entitymanagerobject.createQuery(str,User.class);
    		query.setParameter("number",contact);
    		passList = query.getResultList();
    	
    		
    		
    		
    		
    		if(passList.size()>0) 
    			return 1;
    		else 
    			return 0;
        	
        }





}
