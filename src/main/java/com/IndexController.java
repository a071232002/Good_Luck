package com;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emp.model.Emp;
import com.emp.service.EmpService;
import com.empfun.model.EmpFunService;
import com.rtn.service.RtnService;

@Validated
@Controller
@RequestMapping("/BackStage")
//@ComponentScan(basePackages = "com")
public class IndexController {
	@Autowired
	public RtnService rtnService;
	
	@Autowired
	private EmpService empService;
	
	@Autowired
	private EmpFunService empFunService;

//	後台登入|後台|
//	@GetMapping("/login")
//	public String login() {
//		return "BackStage/login";
//	}
	
	// 前往登入頁面
	@GetMapping("/login")
	public String login() {
		return "BackStage/login";
	}
	
	// 登入處理
	@PostMapping("/index")
	public String login(String userNo, String userPassword, Model model, HttpSession session, 
						 HttpServletResponse res) {

//		String uri = session.getAttribute("oldUri").toString();
		String projectUri = session.getServletContext().getContextPath();

		System.out.println("userName 為: " + userNo);
		System.out.println("userPassword 為: " + userPassword);
		if (userNo.isEmpty() || userPassword.isEmpty()) {
			model.addAttribute("message", "員工編號或密碼不能空白，請重新輸入！");
			return "BackStage/login";
		}
		Emp loginData = empService.empLogin(Integer.valueOf(userNo), userPassword);
		if (loginData != null && loginData.getEmpStatus() != 0) {
			String activeNavItemId = projectUri + "/icon/BackStage/indexJS";
//			String uri = session.getAttribute("goBackStageURI").toString();
			loginData.setEmpFun(empFunService.findByEmpNo(loginData.getEmpNo()));
			model.addAttribute("activeNavItemId", activeNavItemId);
			session.setAttribute("EmpSuccess", loginData); // 資料存入Session內

//			System.out.println(req.isRequestedSessionIdFromCookie());
//			System.out.println(projectUri + " <---");
//			System.out.println(req.getRequestURI());
//			System.out.println(req.getRequestURL());
			try {
				res.sendRedirect(projectUri + "/BackStage");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("message", "員工編號或密碼輸入錯誤，請重新輸入！");
		return "BackStage/login";

	}
	
	//登出
	@GetMapping("/logout")
	public String logout(ModelMap model, HttpSession session) {
		session.removeAttribute("EmpSuccess");
		System.out.println("後台成功登出！");
		return "redirect:/BackStage/login";
	}
	
	// 前往首頁
	@GetMapping("")
	public String index() {
		System.out.println("here");
		return "BackStage/index";
	}
	

//	GET導向退會單|後台|Sub
	@GetMapping("/Rtn")
	public String GoRtn(Model model) {
		model.addAttribute("activeNavItemId", "/Good_Luck/icon/BackStage/indexJS");
		return "redirect:/BackStage/RtnManage";
	}
	
	// 前往後臺管理(暫定)
	@GetMapping("/tempCenter")
	public String tempHome() {
		return "BackStage/emp/empIndex";
	}
	
	// 前往員工個人資料
	@GetMapping("/myData")
	public String empList(Model model, HttpSession session) {
//		List<Emp> datas = empService.findAll();
//		model.addAttribute("empListData", datas);
		Emp emp = (Emp) session.getAttribute("EmpSuccess");
		model.addAttribute("empData", emp);
		return "BackStage/emp/OneEmp";
//		return "BackStage/emp/selectEmp";
	}
	
	// 前往修改個人密碼
	@GetMapping("/changePsw")
	public String changePsw(ModelMap model) {
		return "BackStage/emp/updatePsw";
	}

	// 處理修改密碼
	@PostMapping("/getPsw")
	public String getPsw(@RequestParam("oldEmpPsw") String oldEmpPsw, @RequestParam("newEmpPsw") String newEmpPsw,
			ModelMap model, HttpSession session) {
		System.out.println(oldEmpPsw);
		System.out.println(newEmpPsw);
		Emp data = (Emp) session.getAttribute("EmpSuccess");

		if (oldEmpPsw.isEmpty() || newEmpPsw.isEmpty()) {
			model.addAttribute("empty", "密碼不可為空值！");
			return "BackStage/emp/updatePsw";
		} else if (!data.getEmpPsw().equals(oldEmpPsw)) {
			model.addAttribute("error", "密碼輸入錯誤，請重新輸入！");
			return "BackStage/emp/updatePsw";
		}
		//未處理完成
		data.setEmpPsw(newEmpPsw);
		empService.editEmp(data);
		return "redirect:/BackStage/logout";
	}
	
	//前往沒有權限
	@GetMapping("/noFun")
	public String noFun(ModelMap model) {
		return "BackStage/empfun/noEmpFun";
	}
}


