package com.emp.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emp.model.Emp;
import com.emp.service.EmpService;
import com.mem.model.Mem;

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
	
	//前往首頁
	@GetMapping("/empHome")
	public String index() {
		return "BackStage/index";
	}
	
	//前往後臺管理(暫定)
	@GetMapping("/tempHome")
	public String tempHome() {
		return "BackStage/emp/empIndex";
	}
	
	//前往登入頁面
	@GetMapping("/login")
	public String login() {
		return "BackStage/login";
	}

	//前往新增員工
	@GetMapping("/addEmp")
	public String register(Model model) {
		model.addAttribute("emp", new Emp());
		return "BackStage/emp/addEmp";
	}
	
	//前往員工個人資料
	@GetMapping("/EmpSelect")
	public String empList(Model model, HttpSession session) {
//		List<Emp> datas = empService.findAll();
//		model.addAttribute("empListData", datas);
		Emp emp = (Emp)session.getAttribute("EmpSuccess");
		model.addAttribute("empData", emp);
		return "BackStage/emp/OneEmp";
//		return "BackStage/emp/selectEmp";
	}
	
	//顯示單一員工
	@PostMapping("oneEmp")
	public String oneEmp(Model model) {
//		System.out.println(empNo);
//		Emp emp = empService.getById(Integer.valueOf(empNo));
//		model.addAttribute("empData", emp);
//		return "redirect:EmpSelect";
		return "BackStage/emp/OneEmp";
	}
	
	//登入處理
	@PostMapping("/index")
	public String login(String userNo ,String userPassword ,Model model, HttpSession session) {
		
//		String uri = session.getAttribute("oldUri").toString();
		String projectUri = session.getServletContext().getContextPath();
		
		System.out.println("userName 為: " + userNo);
		System.out.println("userPassword 為: " + userPassword);
		if(userNo.isEmpty() || userPassword.isEmpty()) {
			model.addAttribute("message", "信箱或密碼不能空白，請重新輸入！");
			return "BackStage/login";
		}
		Emp loginData = empService.empLogin(Integer.valueOf(userNo), userPassword);
		if (loginData != null) {
			String activeNavItemId = projectUri + "/icon/BackStage/indexJS";
			model.addAttribute("activeNavItemId", activeNavItemId);
			session.setAttribute("EmpSuccess", loginData); //資料存入Session內
			
//			System.out.println(uri.replace(projectUri, "") + " <---");
			System.out.println(projectUri + " <---");
			return "redirect:/BackStage/empHome";
		}
		model.addAttribute("message", "信箱或密碼輸入錯誤，請重新輸入！");
		return "BackStage/login";

	}
	
	//新增員工
	@PostMapping("empRegister")
	public String empRegister(@Valid Emp emp, BindingResult result, ModelMap model, HttpSession session) {
		System.out.println("Mem：" + emp);
		if(emp.getEmpHireDate() == null) {
			model.addAttribute("errorDate", "請輸入入職日期！");
		}
		if(result.hasErrors()) {
			return "BackStage/emp/addEmp";
		}
		
		empService.registerEmp(emp);
		
		return "redirect:/BackStage/login";
	}
	
}
