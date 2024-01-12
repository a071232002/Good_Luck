package com.empfun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.empfun.model.EmpFun;
import com.empfun.model.EmpFunService;

@Controller
@RequestMapping("/BackStage/funManager")
public class EmpFunController {
	
	//(預設有一個最高權限)
	//(預設新增員工不會給任何權限)
	
	@Autowired
	private EmpFunService empFunService;

	//前往權限管理
	@GetMapping("/funlist")
	public String funlist(ModelMap model) {
		return "BackStage/empfun/listAllEmpfun";
	}
	
	//處理權限管理
	
	
	//設置全部員工權限資料
	@ModelAttribute("allfunList")
	public List<EmpFun> empfunList(ModelMap model){
		List<EmpFun> list = empFunService.getAll();
		return list;
	}
	
}
