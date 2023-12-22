package com.Rtn.dao;

import java.util.List;
import java.util.Map;

import com.Rtn.mdoel.RtnVO;

public interface RtnDAO {
	
	int insert(RtnVO entity);

	int update(RtnVO entity);
	
	int delete(Integer id);
	 
	RtnVO getById(Integer id);
	
	List<RtnVO> getAll();
	
	List<RtnVO> getByCompositeQuery(Map<String, String> map);
	
	List<RtnVO> getAll(int currentPage);
	
	long getTotal();
}
