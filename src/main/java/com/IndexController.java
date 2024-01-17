package com;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emp.dto.EmpRegisterRequest;
import com.emp.model.Emp;
import com.emp.service.EmpService;
import com.rtn.contant.RtnCateGory;
import com.rtn.dto.RtnQueryParams;
import com.rtn.dto.RtnRequest;
import com.rtn.model.Rtn;
import com.rtn.service.RtnService;

@Validated
@Controller
@RequestMapping("/BackStage")
//@ComponentScan(basePackages = "com")
public class IndexController {
	@Autowired
	public RtnService rtnService;

//	後台登入|後台|
//	@GetMapping("/login")
//	public String login() {
//		return "BackStage/login";
//	}
//	後台首頁|後台|Supper
	@PostMapping("/index")
	public String login(String userName ,
						String userPassword ,
						Model model) 
	{
		
		System.out.println("userName 為: " + userName);
		System.out.println("userPassword 為: " + userPassword);
		
		String activeNavItemId = "/Good_Luck/icon/BackStage/indexJS";
		model.addAttribute("activeNavItemId", activeNavItemId);
		return "BackStage/index";
	}
	

//	GET導向退會單|後台|Sub
	@GetMapping("/Rtn")
	public String GoRtn(Model model) {
		model.addAttribute("activeNavItemId", "/Good_Luck/icon/BackStage/indexJS");
		return "redirect:/BackStage/RtnManage";
	}
}


