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
import com.emp.model.Emp;
import com.mem.model.Mem;

@SpringBootApplication
public class Test_Application_CommandLineRunner implements CommandLineRunner {
    
	@Autowired
	LddAppRepository repository ;
	
	public static void main(String[] args) {
        SpringApplication.run(Test_Application_CommandLineRunner.class);
    }

    @Override
    public void run(String...args) throws Exception {

    	//● 新增
		Mem mem = new Mem(); 
		mem.setMemNo(1);

		LddApp lddApp = new LddApp(); 
		lddApp.setMem(mem);
		lddApp.setLddAppCreate(Date.valueOf(LocalDate.now()));
		lddApp.setLddAppIDPic(null);
		repository.save(lddApp);

		//● 修改
//		Emp emp = new Emp(); 
//		emp.setEmpNo(1);
//		LddApp lddApp1 = new LddApp();
//		lddApp1.setLddAppNo(1);
//		lddApp1.setEmp(emp);
//		lddApp1.setLddAppIDPic(null);
//		lddApp1.setLddAppPayStatus(Byte.valueOf("2"));
//		lddApp1.setLddAppStatus(Byte.valueOf("2"));
		

    	//● 查詢-findByPrimaryKey (多方emp2.hbm.xml必須設為lazy="false")(優!)
//    	Optional<EmpVO> optional = repository.findById(7001);
//		EmpVO empVO3 = optional.get();
//		System.out.print(empVO3.getEmpno() + ",");
//		System.out.print(empVO3.getEname() + ",");
//		System.out.print(empVO3.getJob() + ",");
//		System.out.print(empVO3.getHiredate() + ",");
//		System.out.print(empVO3.getSal() + ",");
//		System.out.print(empVO3.getComm() + ",");
//		// 注意以下三行的寫法 (優!)
//		System.out.print(empVO3.getDeptVO().getDeptno() + ",");
//		System.out.print(empVO3.getDeptVO().getDname() + ",");
//		System.out.print(empVO3.getDeptVO().getLoc());
//		System.out.println("\n---------------------");
      
    	
		//● 查詢-getAll (多方emp2.hbm.xml必須設為lazy="false")(優!)
//    	List<EmpVO> list = repository.findAll();
//		for (EmpVO aEmp : list) {
//			System.out.print(aEmp.getEmpno() + ",");
//			System.out.print(aEmp.getEname() + ",");
//			System.out.print(aEmp.getJob() + ",");
//			System.out.print(aEmp.getHiredate() + ",");
//			System.out.print(aEmp.getSal() + ",");
//			System.out.print(aEmp.getComm() + ",");
//			// 注意以下三行的寫法 (優!)
//			System.out.print(aEmp.getDeptVO().getDeptno() + ",");
//			System.out.print(aEmp.getDeptVO().getDname() + ",");
//			System.out.print(aEmp.getDeptVO().getLoc());
//			System.out.println();
//		}
    
    }
}
