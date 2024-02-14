package com.report.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ldd.model.Ldd;
import com.mem.model.Mem;
import com.rentapp.model.RentApp;
import com.report.model.*;

@Controller
@RequestMapping("/report")
public class ReportControllerFrontEnd {
	
	@Autowired
	ReportServiceImpl reoprtSvc;
	
	//前往新增頁面
	@GetMapping("/addReport")
	public String addReport(ModelMap model) {
		Report report = new Report();
		model.addAttribute("report", report);
		return "FrontEnd/report/addReport";
	}

  //前往findAllById
    @GetMapping("/findAllReportById")
	public String findAllReportById(Model model,HttpSession session) {
		Mem mem=(Mem)session.getAttribute("logsuccess");
		List<Report> list = reoprtSvc.getAllByMem(mem);
		model.addAttribute("reportListDataById", list);
		return "FrontEnd/report/findAllReportById";
	}
    
	@PostMapping("insert")
	public String insert(@Valid Report report, BindingResult result,ModelMap model ,HttpSession session) throws IOException {
		
		System.out.println(result);
		if (result.hasErrors()) {
			return "FrontEnd/report/addReport";
		}

		Mem mem=(Mem)session.getAttribute("logsuccess");
		report.setMem(mem);
		reoprtSvc.addReport(report);
		List<Report> list = reoprtSvc.getAll();
		model.addAttribute("rentAppListData", list);
		model.addAttribute("success", "- (新增成功)");
		return "redirect:findAllReportById"; 
	}
		
	@PostMapping("update")
	public String update(@Valid Report report, ModelMap model ) throws IOException {
		reoprtSvc.addReport(report);
		model.addAttribute("success", "- (修改成功)");
		report = reoprtSvc.getOneReport(Integer.valueOf(report.getReportNo()));
		model.addAttribute("report", report);
		return "redirect:findAllReportById"; 
	}
	
	// 設置查詢全部屬性
	@ModelAttribute("reportListData")
	protected List<Report> referenceListData() {
		List<Report> list = reoprtSvc.getAll();
		return list;
	}

}
