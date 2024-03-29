package com.lse.model;

import java.util.List;

import com.ldd.model.Ldd;
import com.mem.model.Mem;
import com.rent.model.Rent;

public interface LseService {
	
	public Lse addLse(Lse lse);
	
	public void updateLse(Lse lse);
	
	public Lse getOneByLseNo(Integer lseNo);
	
	//for 物件管理找到最新的合約
	public Lse getNewOneByRent(Rent rent); 
	
	public List<Lse> getListByRentNo(Integer rentNo);
	
	public List<Lse> getListInContract();
	
	public List<Lse> getListByMem(Mem mem);
	
	public List<Lse> getListByLdd(Ldd ldd);
	
}
