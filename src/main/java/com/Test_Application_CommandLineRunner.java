package com;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lddapp.model.LddApp;
import com.lddapp.model.LddAppRepository;
import com.lddapp.model.LddAppService;
import com.emp.model.Emp;
import com.mem.model.Mem;

@SpringBootApplication
public class Test_Application_CommandLineRunner implements CommandLineRunner {
    
	@Autowired
	LddAppRepository repository ;
	
	@Autowired
	LddAppService lddAppService;  
	
	public static void main(String[] args) {
        SpringApplication.run(Test_Application_CommandLineRunner.class);
    }

    @Override
    public void run(String...args) throws Exception {

    	//● 新增
		Mem mem = new Mem(); 
		mem.setMemNo(3);

		LddApp lddApp = new LddApp(); 
		lddApp.setMem(mem);
		lddApp.setLddAppCreate(Date.valueOf(LocalDate.now()));
		lddApp.setLddAppIDPic(null);
//		repository.save(lddApp);
		lddAppService.addLddApp(lddApp);

		//● 修改
		Emp emp = new Emp(); 
		emp.setEmpNo(3);
		
		LddApp lddApp1 = new LddApp();
		lddApp1.setLddAppNo(1);
		lddApp1.setMem(mem);
		lddApp1.setEmp(emp);
		lddApp1.setLddAppIDPic(null);
		lddApp1.setLddAppPayStatus(Byte.valueOf("2"));
		lddApp1.setLddAppStatus(Byte.valueOf("2"));
//		repository.save(lddApp1);
		lddAppService.upDateLddApp(lddApp1);

    	//● 查詢-findByPrimaryKey (多方必須設為lazy="false")(優!)
//    	Optional<LddApp> optional = repository.findById(1);
//    	LddApp lddApp2 = optional.get();
    	LddApp lddApp2 = lddAppService.getOneLddApp(1);
    	System.out.println(lddApp2);
      
    	
		//● 查詢-getAll (多方必須設為lazy="false")(優!)
//		List<LddApp> list = repository.findAll();
		List<LddApp> list = lddAppService.getAll();
		for (LddApp aLddApp : list) {
			System.out.println(aLddApp);
		}
    }
}
