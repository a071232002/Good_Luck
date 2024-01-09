package com;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.emp.model.Emp;
import com.ldd.model.Ldd;
import com.lddapp.model.LddApp;
import com.lddapp.model.LddAppService;
import com.mem.model.Mem;
import com.rent.model.Rent;
import com.rentapp.model.RentApp;
import com.rentapp.model.RentAppService;

@SpringBootApplication
public class Test_Application_RentApp implements CommandLineRunner{

	@Autowired
	RentAppService rentAppService;  
	
	public static void main(String[] args) {
        SpringApplication.run(Test_Application_RentApp.class);
    }
	@Override
	public void run(String... args) throws Exception {

		//● 新增
		
//		Ldd ldd=new Ldd();
//		ldd.setLddNo(1);
//
//		RentApp rentApp = new RentApp(); 
//		rentApp.setLdd(ldd);
//		
//		rentAppService.addRentApp(rentApp);
		
		//● 修改
		
//		Emp emp = new Emp(); 
//		emp.setEmpNo(2);
//		Rent rent =new Rent();
//		rent.setRentNo(1);
//		RentApp rentApp1 = new RentApp(); 
//		rentApp1.setRentAppNo(4);
//		rentApp1.setEmp(emp);
//		rentApp1.setRent(rent);
//		rentApp1.setRentAppCou("市");
//		rentApp1.setRentAppAr("區");
//		rentApp1.setRentAppRo("路");
//		rentApp1.setRentAppAdd("詳細");
//		rentApp1.setRentAppOwn(null);
//		rentApp1.setRentAppFloor(3);
//		rentApp1.setRentAppSize(3.5);
//		rentApp1.setRentAppSt((byte) 1);
//		
//		rentAppService.updateRentApp(rentApp1);
		

    	//● 查詢-findByPrimaryKey (多方必須設為lazy="false")(優!)

//		RentApp rentApp2 = rentAppService.getOneRentApp(1);
//    	System.out.println(rentApp2);
      
    	
		//● 查詢-getAll (多方必須設為lazy="false")(優!)
    	
//		List<RentApp> list = rentAppService.getAll();
//		for (RentApp aRentApp : list) {
//			System.out.println(aRentApp);
//		}
	}
	

}
