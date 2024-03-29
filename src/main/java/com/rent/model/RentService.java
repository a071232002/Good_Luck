package com.rent.model;

import java.util.List;
import java.util.Map;

import com.ldd.model.Ldd;


public interface RentService {
	public void addRent(Rent rent); 

	public void updateRent(Rent rent); 

	public Rent getOneRent(Integer rentNo);
	
	public List<Rent> getAll();
	
	public List<Rent> getAllByLdd(Ldd ldd);
	
	public List<Rent> getByCompositeQuery(Map<String, String[]> map);
}
