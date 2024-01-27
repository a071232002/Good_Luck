package com.empfun.model;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;



public interface EmpFunRepository extends JpaRepository<EmpFun, Integer>{
	
	@Transactional
	public List<EmpFun> findByEmpEmpNoIn(List<Integer> empNoList);
	
}
