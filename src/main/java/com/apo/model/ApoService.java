package com.apo.model;

import java.util.List;

import javax.transaction.Transactional;

import com.ldd.model.Ldd;
import com.mem.model.Mem;

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

	public List<Apo> getApoListByLdd(Integer lddNo);
	
//	TODO 改用房東查詢已booking時段
	public List<ApoDTO> getListWithBookingByRentNo(Integer rentNo);
	
	public List<ApoDTO> getListWithBookingByLdd(Ldd ldd);

	public Apo getOneApo(Integer apoNo);

	public List<Apo> getApoListByMem(Mem mem);
	
	public List<Apo> getApoByApoStatus(List<Byte> apoStatusList);
	
	public List<Apo> getApoByMemAndApoStatus(Mem mem, List<Byte> apoStatusList);
	
	public List<Apo> getAll();

}
