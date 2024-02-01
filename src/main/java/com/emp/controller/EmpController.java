package com.emp.controller;

import java.util.List;

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

@Controller
@RequestMapping("/BackStage/emp")
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

	// 前往首頁
//	@GetMapping("/empHome")
//	public String index() {
//		return "BackStage/index";
//	}

	// 前往後臺管理(暫定)
//	@GetMapping("")
//	public String tempHome() {
//		return "BackStage/emp/empIndex";
//	}

	// 前往登入頁面
//	@GetMapping("/login")
//	public String login() {
//		return "BackStage/login";
//	}
	
	//前往查詢全部員工基本資料
	@GetMapping("/listAllEmp")
	public String listAll(ModelMap model) {
		return "BackStage/emp/listAllEmp";
	}
	
	@ModelAttribute("allEmpList")
	protected List<Emp> allEmpList() {
		return empService.findAll();
	}

	// 前往員工個人資料
//	@GetMapping("/myData")
//	public String empList(Model model, HttpSession session) {
////		List<Emp> datas = empService.findAll();
////		model.addAttribute("empListData", datas);
//		Emp emp = (Emp) session.getAttribute("EmpSuccess");
//		model.addAttribute("empData", emp);
//		return "BackStage/emp/OneEmp";
////		return "BackStage/emp/selectEmp";
//	}

	// 登入處理
//	@PostMapping("/index")
//	public String login(String userNo, String userPassword, Model model, HttpSession session) {
//
////		String uri = session.getAttribute("oldUri").toString();
//		String projectUri = session.getServletContext().getContextPath();
//
//		System.out.println("userName 為: " + userNo);
//		System.out.println("userPassword 為: " + userPassword);
//		if (userNo.isEmpty() || userPassword.isEmpty()) {
//			model.addAttribute("message", "信箱或密碼不能空白，請重新輸入！");
//			return "BackStage/login";
//		}
//		Emp loginData = empService.empLogin(Integer.valueOf(userNo), userPassword);
//		if (loginData != null) {
//			String activeNavItemId = projectUri + "/icon/BackStage/indexJS";
//			String uri = session.getAttribute("goBackStageURI").toString();
//			model.addAttribute("activeNavItemId", activeNavItemId);
//			session.setAttribute("EmpSuccess", loginData); // 資料存入Session內
//			System.out.println("取得儲存路徑：" + uri);
//
//			System.out.println(projectUri + " <---");
//			return "redirect:" + uri;
//		}
//		model.addAttribute("message", "信箱或密碼輸入錯誤，請重新輸入！");
//		return "BackStage/login";
//
//	}
	
	// 前往新增員工
	@GetMapping("/addEmp")
	public String register(Model model) {
		model.addAttribute("emp", new Emp());
		return "BackStage/emp/addEmp";
	}

	// 新增員工
	@PostMapping("empRegister")
	public String empRegister(@Valid Emp emp, BindingResult result, ModelMap model, HttpSession session) {
		System.out.println("Mem：" + emp);
		if (emp.getEmpHireDate() == null) {
			model.addAttribute("errorDate", "請輸入入職日期！");
		}
		if (result.hasErrors()) {
			return "BackStage/emp/addEmp";
		}

		empService.registerEmp(emp);

		return "redirect:/BackStage/emp/listAllEmp";
	}
	
	//前往修改員工基本資料
	@GetMapping("/updateEmp")
	public String updateEmp(Model model, String updateNo) {
		Emp emp = empService.getById(Integer.valueOf(updateNo));
		model.addAttribute("empData", emp);
		return "BackStage/emp/updateEmp";
	}
	
	//處理修改資料
	@PostMapping("/changeEmp")
	public String changeEmp(@Valid Emp emp, ModelMap model, BindingResult result) {
		System.out.println(emp + "test");
		if(result.hasErrors()) {
			return "BackStage/emp/updateEmp";
		}
		
		empService.editEmp(emp);
		return "redirect:/BackStage/emp/listAllEmp";
	}
	
	//處理員工離職
	@PostMapping("/resign")
	public String resign(String resignEmp) {
		Emp emp = empService.getById(Integer.valueOf(resignEmp));
		empService.resignEmp(emp);
		return "redirect:/BackStage/emp/listAllEmp";
	}
	
	//重製密碼
	@PostMapping("/rePsw")
	public String rePsw(String rePswEmpNo) {
		Emp emp = empService.reSetPsw(Integer.valueOf(rePswEmpNo));
		System.out.println(rePswEmpNo + "ff");
		return "redirect:/BackStage/emp/listAllEmp";
	}
	
//	@ModelAttribute("goodluckPsw")
//	public String goodluckPsw() {
//		Emp emp = empService.getById(null)
//	}

//	// 前往修改個人密碼
//	@GetMapping("/changePsw")
//	public String changePsw(ModelMap model) {
//		return "BackStage/emp/updatePsw";
//	}
//
//	// 處理修改密碼
//	@PostMapping("/getPsw")
//	public String getPsw(@RequestParam("oldEmpPsw") String oldEmpPsw, @RequestParam("newEmpPsw") String newEmpPsw,
//			ModelMap model, HttpSession session) {
//		System.out.println(oldEmpPsw);
//		System.out.println(newEmpPsw);
//		Emp data = (Emp) session.getAttribute("EmpSuccess");
//
//		if (oldEmpPsw.isEmpty() || newEmpPsw.isEmpty()) {
//			model.addAttribute("empty", "密碼不可為空值！");
//			return "redirect:/BackStage/changePsw";
//		} else if (!data.getEmpPsw().equals(oldEmpPsw)) {
//			model.addAttribute("error", "密碼輸入錯誤，請重新輸入！");
//			return "redirect:/BackStage/emp/changePsw";
//		}
//		return "redirect:/BackStage/emp/login";
//	}
	
//	@GetMapping("/logout")
//	public String logout(ModelMap model, HttpSession session) {
//		session.removeAttribute("EmpSuccess");
//		return "redirect:/BackStage/login";
//	}

}
