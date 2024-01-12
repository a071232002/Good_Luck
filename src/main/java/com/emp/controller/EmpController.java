package com.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emp.model.Emp;
import com.emp.service.EmpService;

@Controller
@RequestMapping("/BackStage")
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
//	@PostMapping("Emp/register")
//	public ResponseEntity<Emp> register(@RequestBody @Valid EmpRegisterRequest empRegisterRequest){
//		
//		Emp empName = empService.getById(empRegisterRequest);
//
//		return ResponseEntity.status(HttpStatus.CREATED).body(empName);
//	}
	
	//前往登入頁面
	@GetMapping("/login")
	public String login() {
		return "BackStage/login";
	}
	
	//登入處理
	@PostMapping("/index")
	public String login(String userNo ,String userPassword ,Model model) {
		
		
		System.out.println("userName 為: " + userNo);
		System.out.println("userPassword 為: " + userPassword);
		if(userNo.isEmpty() || userPassword.isEmpty()) {
			model.addAttribute("message", "信箱或密碼不能空白，請重新輸入！");
			return "BackStage/login";
		}
		Emp loginData = empService.empLogin(Integer.valueOf(userNo), userPassword);
		if (loginData != null) {
			String activeNavItemId = "/Good_Luck/icon/BackStage/indexJS";
			model.addAttribute("activeNavItemId", activeNavItemId);
			return "BackStage/index";
		}
		model.addAttribute("message", "信箱或密碼輸入錯誤，請重新輸入！");
		return "BackStage/login";

		

	}
	
}
