package com;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.emp.model.Emp;
import com.emp.service.EmpService;
import com.empfun.model.EmpFunService;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private EmpFunService empFunService;
	
	@Autowired
	private EmpService empService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		List<Emp> list = new ArrayList<>();
//		
//		empService.findAll().forEach(emp -> {
//			Hibernate.initialize(emp.getEmpFun1());
//			list.add(emp);
//			System.out.println(emp);
//		});
//		System.out.println(list.size());
		
		
//		List<Integer> funNames = empFunService.findByEmpNo(1);
//		
//		for(Integer funName : funNames) {
//			System.out.println(funName);
//		}
		
		
	}
}
