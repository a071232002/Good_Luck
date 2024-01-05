package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.emp.model.Emp;
import com.emp.model.EmpRepository;
import com.mem.model.Mem;
import com.mem.model.MemRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com")
public class TestApplication implements CommandLineRunner{
	
	@Autowired
	private MemRepository memRepository;
	
	@Autowired
	private EmpRepository empRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Mem> datas = memRepository.findAll();
		
		List<Emp> empDatas = empRepository.findAll();
		
		for(Mem data : datas) {
			System.out.println(data);
		}
		
		for(Emp data : empDatas) {
			System.out.println(data);
		}
	}

}
