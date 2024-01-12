package com.rentapp.model;

import java.util.List;
import java.util.Optional;

public interface RentAppService {
	public void addRentApp(RentApp rentApp); 

	public void updateRentApp(RentApp rentApp); 

	public RentApp getOneRentApp(Integer rentAppNo);
	
	public List<RentApp> getAll();

}
