package com.rentapp.model;

import java.util.List;

import com.emp.model.Emp;
import com.ldd.model.Ldd;


public interface RentAppService {
	public void addRentApp(RentApp rentApp); 

	public void updateRentApp(RentApp rentApp); 

	public RentApp getOneRentApp(Integer rentAppNo);
	
	public List<RentApp> getAll();
	
	public RentApp updateRentAppSt(Integer rentAppNo, byte rentAppSt,Emp emp);
	
	public String[] getLatAndLon(String rentAppCou, String rentAppAr, String rentAppRo, String rentAppAdd)throws Exception;

	public List<RentApp> getAllByLdd(Ldd ldd);
}
