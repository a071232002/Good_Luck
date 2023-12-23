package com.Rtn.service;

import java.util.List;
import java.util.Map;

import com.Rtn.model.RtnVO;


public interface RtnService {
	RtnVO addEmp(RtnVO emp);
	
	RtnVO updateEmp(RtnVO emp);
	
	void deleteEmp(Integer empno);
	
	RtnVO getEmpByEmpno(Integer empno);
	
	List<RtnVO> getAllEmps(int currentPage);
	
	int getPageTotal();
	
	List<RtnVO> getEmpsByCompositeQuery(Map<String, String[]> map);
}
