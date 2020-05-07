package com.cg.movie.Dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.movie.Dao.TheatreDao;
import com.cg.movie.Exception.TheatreIdNotFoundException;
import com.cg.movie.entity.Theatre;

@Repository
public class TheatreDaoimpl implements TheatreDao{
	@PersistenceContext
	EntityManager entitymanager;
	static int id= 2000;
	Theatre theatre = new Theatre();
/**************************************************************************************************
     *Method:                   create
     *description:              Adds new theatre 
     *@returns                 -theatre details
     *@throws TheatreIdNotFoundException -it is raised due to invalid id
     *created by               -Hemanth Reddy
     *created date             -21-APR-2020
**************************************************************************************************/
	@Override
	public boolean create(Theatre theatre) { 
		if(true)
		{
			int theatreId =getMaxTheatreId(theatre.getTheatreId())+1;
			theatre.setTheatreId(theatreId);
			entitymanager.persist(theatre); 
			return true; 	
		}
		return false;
	}
/**************************************************************************************************
     *Method:                   reterive
     *description:              displays all the records
     *
     *@returns                 -theatre details
     *created by               -Hemanth Reddy
     *created date             -21-APR-2020
**************************************************************************************************/
	@Override
	public List<Theatre> reterive() {
		String Qstr="SELECT theatre from Theatre theatre";
		TypedQuery<Theatre> query=entitymanager.createQuery(Qstr,Theatre.class);
		return query.getResultList();
	}
/**************************************************************************************************
     *Method:                   findById
     *description:              display the paticular record by id
     *theatreId                -fetches the details of that particular id
     *@returns                 -theatre details
     *@throws TheatreIdNotFoundException -it is raised due to invalid id
     *created by               -Hemanth Reddy
     *created date             -21-APR-2020
**************************************************************************************************/
	@Override
	public Theatre findById(int id) {
		  
		Theatre th = entitymanager.find(Theatre.class, id);
		return th;
		
	}
/**************************************************************************************************
     *Method:                   delete
     *description:              delete the paticular record by id
     *theatreId                -fetches the details of that particular id
     *@returns                 -theatre details
     *@throws TheatreIdNotFoundException -it is raised due to invalid id
     *created by               -Hemanth Reddy
     *created date             -21-APR-2020
**************************************************************************************************/
	@Override
	public void delete(int id) {
	Theatre theatre=entitymanager.find(Theatre.class, id);//this method will which id to remove
	
	System.out.println(theatre.getTheatreId() +" "+theatre.getTheatreName() + " "+theatre.getTheatreCity()+" "+theatre.getManagerName()+""+theatre.getManagerContact()+"is removed");
	
	entitymanager.remove(theatre);//this is object from the database
	
	}
	/**************************************************************************************************
     *Method:                   update
     *description:              update the paticular record by id
     *theatreId                -fetches the details of that particular id
     *@returns                 -theatre details
     *@throws TheatreIdNotFoundException -it is raised due to invalid id
     *created by               -Hemanth Reddy
     *created date             -21-APR-2020
**************************************************************************************************/
	@Override
	public void update(int id,String name,String city,String managerName,Long managerContact) {
		Theatre theatre=entitymanager.find(Theatre.class, id);
		theatre.setTheatreName(name);
		theatre.setTheatreCity(city);
		theatre.setManagerName(managerName);
		theatre.setManagerContact(managerContact);
}
	@Override
	public int getMaxTheatreId(int theatreId) {
		String jpql = "select theatre from Theatre theatre ";
		TypedQuery<Theatre> query = entitymanager.createQuery(jpql, Theatre.class);
	    List<Theatre> theatreList= query.getResultList();
	    if(!theatreList.isEmpty())
	    {
	    	String str = "SELECT max(theatreId) from Theatre";
	    	TypedQuery<Integer> theatreid = entitymanager.createQuery(str,Integer.class);
	    	int num = theatreid.getSingleResult();
	    	return num;
	    	
	    }
	    else
	    	return id;
	}
}

