package com.apo.model;

import java.util.List;

import javax.transaction.Transactional;

import com.mem.model.Mem;

public interface ApoService {

	public void addApo(Apo apo);

	public void upDateApo(Apo apo);

	public List<Apo> getListByLdd(Integer lddNo);

	public Apo getOneApo(Integer apoNo);

	public List<Apo> getApoByMem(Mem mem);
	
	public List<Apo> getApoByApoStatus(List<Byte> apoStatusList);
	
	public List<Apo> getApoByMemAndApoStatus(Mem mem, List<Byte> apoStatusList);
	
	public List<Apo> getAll();

}
