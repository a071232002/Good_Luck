package com.report.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.emp.model.Emp;
import com.mem.model.Mem;
import com.rentapp.model.RentApp;
import com.report.model.*;

@Controller
@RequestMapping("/BackStage/report")
public class ReportController {
	
	@Autowired
	ReportServiceImpl reoprtSvc;
	
	//前往listall
    @GetMapping("/reviewReport")
	public String listAllReport(Model model) {
		return "BackStage/report/reviewReport";
	}
    
	@PostMapping("update")
	public String update(@Valid Report report, ModelMap model ,HttpSession session) throws IOException {
		Emp emp = (Emp)session.getAttribute("EmpSuccess");
		report.setEmp(emp);
		reoprtSvc.addReport(report);
		model.addAttribute("success", "- (修改成功)");
		report = reoprtSvc.getOneReport(Integer.valueOf(report.getReportNo()));
		model.addAttribute("report", report);
		return "redirect:reviewReport"; 
	}
	
	// 設置查詢全部屬性
	@ModelAttribute("reportListData")
	protected List<Report> referenceListData() {
		List<Report> list = reoprtSvc.getAll();
		return list;
	}
}
