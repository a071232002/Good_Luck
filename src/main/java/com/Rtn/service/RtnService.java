package com.Rtn.service;

import java.util.List;
import java.util.Map;

import com.Rtn.model.Rtn;


public interface RtnService {
	Rtn addEmp(Rtn emp);
	
	Rtn updateEmp(Rtn emp);
	
	void deleteEmp(Integer empno);
	
	Rtn getEmpByEmpno(Integer empno);
	
	List<Rtn> getAllEmps(int currentPage);
	
	int getPageTotal();
	
	List<Rtn> getEmpsByCompositeQuery(Map<String, String[]> map);
}
