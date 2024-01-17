package com.emp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	//前往單一員工查詢
	@GetMapping("/EmpSelect")
	public String empList(Model model) {
		List<Emp> datas = empService.findAll();
		model.addAttribute("empListData", datas);
		return "BackStage/emp/selectEmp";
	}
	
	//前往新增員工
	@GetMapping("/addEmp")
	public String register(Model model) {
		model.addAttribute("newData", new Emp());
		return "";
	}
	
	//顯示單一員工
	@PostMapping("oneEmp")
	public String oneEmp(@RequestParam("getEmpNo") String empNo, Model model) {
		System.out.println(empNo);
		Emp emp = empService.getById(Integer.valueOf(empNo));
		model.addAttribute("empData", emp);
//		return "redirect:EmpSelect";
		return "BackStage/emp/OneEmp";
	}
	
	//登入處理
	@PostMapping("/index")
	public String login(String userNo ,String userPassword ,Model model, HttpSession session) {
		
		
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
			session.setAttribute("EmpSuccess", loginData);
			return "BackStage/index";
		}
		model.addAttribute("message", "信箱或密碼輸入錯誤，請重新輸入！");
		return "BackStage/login";

		

	}
	
}
