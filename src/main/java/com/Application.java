package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.empfun.model.EmpFunService;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private EmpFunService empFunService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Integer> funNames = empFunService.findByEmpNo(1);
		
		for(Integer funName : funNames) {
			System.out.println(funName);
		}
	}
}
