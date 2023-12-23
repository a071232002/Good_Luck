package com.Rtn.dao;

import java.util.List;
import java.util.Map;

import com.Rtn.model.Rtn;

public interface RtnDAO {
	
	int insert(Rtn entity);

	int update(Rtn entity);
	
	int delete(Integer id);
	 
	Rtn getById(Integer id);
	
	List<Rtn> getAll();
	
	List<Rtn> getByCompositeQuery(Map<String, String> map);
	
	List<Rtn> getAll(int currentPage);
	
	long getTotal();
}
