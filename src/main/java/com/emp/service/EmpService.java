package com.emp.service;

import java.util.List;

import com.emp.dto.EmpRegisterRequest;
import com.emp.model.Emp;

public interface EmpService  {
	
	//單一員工查詢
	public Emp getById(Integer empNo);
	
	// 員工登入
	public Emp empLogin(Integer empNo, String empPsw);
	
	// 查詢員工全部資料
	public List<Emp> findAll();
	
	// 員工編輯資料(姓名、密碼)
	public Emp editEmp(Emp newEmp);
	
	// 員工離職
	public Emp resignEmp(Emp emp);
	
	// 新增員工
	public Emp registerEmp(Emp newEmp);
	
	// 密碼加密
	public String hashPassword(String empPsw);
}
