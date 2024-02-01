package com.empfun.model;

import java.util.List;

import com.emp.model.Emp;
import com.fun.model.Fun;

public interface EmpFunService {
	
	//查詢全部員工擁有的功能權限
	public List<EmpFun> getAll();
	
	//用員工編號查詢單一員工擁有的功能權限
	public List<Integer> findByEmpNo(Integer empNo);
	
	//新增員工擁有的權限
	public Boolean addEmpFun(Emp emp, List<Integer> funNoList);
	
	//變更員工擁有的權限
	public Boolean editFun(Emp emp, List<Integer> funNoList);
	
	//刪除員工全部的權限
	public Boolean removeFun(Emp emp);
}
