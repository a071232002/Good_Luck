package com.empfun.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.model.Emp;
import com.fun.model.Fun;
import com.fun.model.FunService;

@Service
public class EmpFunServiceImpl implements EmpFunService{

	@Autowired
	private EmpFunRepository empFunRepository;
	
	@Autowired
	private FunService funService;
	
	//查詢全部員工擁有的功能權限
	@Override
	public List<EmpFun> getAll() {
		return empFunRepository.findAll();
	}

	//用員工編號查詢單一員工擁有的功能權限
	@Override
	public List<Integer> findByEmpNo(Integer empNo) {
		List<EmpFun> allFun = empFunRepository.findByEmpEmpNoIn(Arrays.asList(empNo));
		List<Integer> datas = new ArrayList<>();
		for(EmpFun empfun : allFun) {
			datas.add(empfun.getFun().getFunNo());
		}
		return datas;
	}

	//新增或變更員工擁有的權限
	@Override
	public Boolean addEmpFun(Emp emp, List<Integer> funNoList) {
		
		List<EmpFun> empfuns = empFunRepository.findByEmpEmpNoIn(Arrays.asList(emp.getEmpNo()));
		for(EmpFun oldFun : empfuns) {
			empFunRepository.delete(oldFun);			
		}
		
		for(Integer data : funNoList) {
			Fun fun = funService.findByFunNo(data); //之後改redis存取
			EmpFun empfun = new EmpFun();
			empfun.setEmp(emp);
			empfun.setFun(fun);
			empFunRepository.save(empfun);
		}
		return true;
	}

	//變更員工擁有的權限
	@Override
	public Boolean editFun(Emp emp, List<Integer> funNoList) {
		

		return null;
	}

}
