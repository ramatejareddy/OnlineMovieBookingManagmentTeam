package com.cg.movie.service;

import java.util.List;


import com.cg.movie.entity.Theatre;

public interface TheatreService {
	
	public void create(Theatre theatre);
	
	public List<Theatre> reterive();
	
	public Theatre findById(int id);

	public void delete(int id);
	
	public void update(int id,String name,String city,String managerName,Long managerContact);
}
