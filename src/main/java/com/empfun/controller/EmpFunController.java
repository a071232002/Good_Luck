package com.empfun.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emp.model.Emp;
import com.emp.service.EmpService;
import com.empfun.model.EmpFunService;

@Controller
@RequestMapping("/BackStage/funManager")
public class EmpFunController {
	
	//(預設有一個最高權限)
	//(預設新增員工不會給任何權限)
	
	@Autowired
	private EmpFunService empFunService;
	
	@Autowired
	private EmpService empService;

	//前往權限管理
	@GetMapping("/funlist")
	public String funlist(ModelMap model) {
		return "BackStage/empfun/listAllEmpfun";
	}
	
	//處理修改權限
	@PostMapping("funUpdate")
	public String fun(@ModelAttribute("empFunData") Emp emp, ModelMap model, HttpSession session) {
		System.out.println(emp);
		List<Integer> funList = emp.getEmpFun();
		emp = empService.getById(emp.getEmpNo());
		emp.setEmpFun(funList);
		empFunService.addEmpFun(emp, funList);
		return "redirect:funlist";
	}
	
	//前往修改權限
	@PostMapping("goEditFun")
	public String goEditFun(@RequestParam("oneEmpNo") String EmpNo, ModelMap model, HttpSession session) {
		
		Emp oldData = empService.getById(Integer.valueOf(EmpNo));
		oldData.setEmpFun(empFunService.findByEmpNo(oldData.getEmpNo()));
		model.addAttribute("empFunData", oldData);
//		session.setAttribute("EmpSuccess", oldData);
		return "BackStage/empfun/updateEmpFun";
	}
	
	//設置全部員工權限資料
	@ModelAttribute("allfunList")
	public List<Emp> empfunList(ModelMap model){
		List<Emp> emps = empService.findAll()
										  .stream()
										  .map(emp -> {
											  emp.setEmpFun(empFunService.findByEmpNo(emp.getEmpNo()));
											  return emp;
										  })
										  .toList();
//		for(Emp emp : emps) {
//			emp.setEmpFun(empFunService.findByEmpNo(emp.getEmpNo()));
//		}
		model.addAttribute("editFun", new Emp());
		return emps;
	}
	
	
}
