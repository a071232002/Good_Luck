package com.apo.model;

import java.util.List;

import javax.transaction.Transactional;

import com.mem.model.Mem;

public interface ApoService {

	public void addApo(Apo apo);

	public void upDateApo(Apo apo);
	
	public void cancelApo(Apo apo);
	
	public void rejectApo(Apo apo);
	
	public void approveApo(Apo apo); 
	
	public void completeApo(Apo apo);	

	public List<Apo> getApoListByLdd(Integer lddNo);
	
	public List<ApoDTO> getListWithBookingByRentNo(Integer rentNo);

	public Apo getOneApo(Integer apoNo);

	public List<Apo> getApoListByMem(Mem mem);
	
	public List<Apo> getApoByApoStatus(List<Byte> apoStatusList);
	
	public List<Apo> getApoByMemAndApoStatus(Mem mem, List<Byte> apoStatusList);
	
	public List<Apo> getAll();

}