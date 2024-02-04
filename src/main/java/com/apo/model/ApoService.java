package com.apo.model;

import java.util.List;

import com.ldd.model.Ldd;
import com.mem.model.Mem;
import com.rent.model.Rent;

public interface ApoService {

	public void addApo(Apo apo);

	public void upDateApo(Apo apo);
	
	public void cancelApo(Apo apo);
	
	public void rejectApo(Apo apo);
	
	public void approveApo(Apo apo); 
	
	public void completeApo(Apo apo);	
	
	public void want(Apo apo);
	
	public void updateWantDate(Apo apo);
	
	public void cancelWant(Apo apo);
		
	public void rejectWant(Apo apo);
	
	public void approveWant(Integer apoNo);
	
	public void rejectOtherApoByRent(Rent rent);

	public List<Apo> getApoListByLdd(Ldd ldd);
	
	public List<Apo> getApoListByLdd(Integer lddNo);
	
	public List<ApoDTO> getListWithBookingByLdd(Ldd ldd);
	
	public List<ApoDTO> getListWithApproveByLdd(Ldd ldd);

	public Apo getOneApo(Integer apoNo);

	public List<Apo> getApoListByMem(Mem mem);
	
	public List<Apo> getApoByApoStatus(List<Byte> apoStatusList);
	
	public List<Apo> getApoByMemAndApoStatus(Mem mem, List<Byte> apoStatusList);
	
	public List<Apo> getAll();

}
