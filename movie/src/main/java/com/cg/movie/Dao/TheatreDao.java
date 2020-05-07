package com.cg.movie.Dao;

import java.util.List;
import com.cg.movie.entity.Theatre;




public interface TheatreDao {
	
	public boolean create(Theatre theatre);
	
	public List<Theatre> reterive();

	public Theatre findById(int id);

	public void delete(int id);
	
	public void update(int id,String name,String city,String managerName,Long managerContact);

	public int getMaxTheatreId(int theatreId);
}
