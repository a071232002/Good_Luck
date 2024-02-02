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
	
	
	// 測試索引頁
	@GetMapping("")
	public String indexOfReport(ModelMap model) {
		return "BackStage/report/select";
	}
	
	//前往新增頁面
//	@GetMapping("/addReport")
//	public String addReport(ModelMap model) {
//		Report report = new Report();
//		model.addAttribute("report", report);
//
//		return "BackStage/report/addReport";
//	}
	//前往listall
    @GetMapping("/reviewReport")
	public String listAllReport(Model model) {

		return "BackStage/report/reviewReport";
	}
    
    
  //前往findAllById
//    @PostMapping("/findAllReportById")
//	public String findAllReportById(Model model, Integer memNo) {
//		Mem mem=new Mem();
//		mem.setMemNo(memNo);
//		List<Report> list = reoprtSvc.getAllByMem(mem);
//		model.addAttribute("reportListDataById", list);
//
//		return "BackStage/report/findAllReportById";
//	}
    
//	@PostMapping("insert")
//	public String insert(@Valid Report report, BindingResult result,ModelMap model ,HttpSession session) throws IOException {
//		
//		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
//		// 去除BindingResult中upFiles欄位的FieldError紀錄 --> 見第172行
//		if (result.hasErrors() ) {
//			return "BackStage/report/addReport";
//		}
//		/*************************** 2.開始新增資料 *****************************************/
//		// EmpService empSvc = new EmpService();
//		reoprtSvc.addReport(report);
//		/*************************** 3.新增完成,準備轉交(Send the Success view) **************/
//		List<Report> list = reoprtSvc.getAll();
//		model.addAttribute("rentAppListData", list);
//		model.addAttribute("success", "- (新增成功)");
//
//		return "redirect:listAllReport"; // 新增成功後重導至IndexController_inSpringBoot.java的第50行@GetMapping("/emp/listAllEmp")
//	}
	
//	@PostMapping("getOne_For_Update")
//	public String getOne_For_Update(@RequestParam("reportNo") String reportNo, ModelMap model) {
//		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
//		/*************************** 2.開始查詢資料 *****************************************/
//		// EmpService empSvc = new EmpService();
//
//		Report report = reoprtSvc.getOneReport(Integer.valueOf(reportNo));
//
//		/*************************** 3.查詢完成,準備轉交(Send the Success view) **************/
//		model.addAttribute("report", report);
//		return "BackStage/rentapp/update_report_input"; // 查詢完成後轉交update_emp_input.html
//	}
	
	
	@PostMapping("update")
	public String update(@Valid Report report, ModelMap model ,HttpSession session) throws IOException {
		
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		// 去除BindingResult中upFiles欄位的FieldError紀錄 --> 見第172行
		/*************************** 2.開始新增資料 *****************************************/
		// EmpService empSvc = new EmpService();

//		System.out.println(report.getReportSt());
		Emp emp = (Emp)session.getAttribute("EmpSuccess");
		report.setEmp(emp);
		reoprtSvc.addReport(report);
		/*************************** 3.新增完成,準備轉交(Send the Success view) **************/
		model.addAttribute("success", "- (修改成功)");
		report = reoprtSvc.getOneReport(Integer.valueOf(report.getReportNo()));
		model.addAttribute("report", report);
		return "redirect:reviewReport"; // 修改成功後轉交listOneEmp.html
	}
	
	// 設置查詢全部屬性
	@ModelAttribute("reportListData")
	protected List<Report> referenceListData() {
		List<Report> list = reoprtSvc.getAll();
		return list;
	}
	
//	@ModelAttribute("reportListDataById")
//	protected List<Report> findAllReportById(Integer memNo ) {
//		Mem mem=new Mem();
//		mem.setMemNo(memNo);
//		List<Report> list = reoprtSvc.getAllByMem(mem);
//		return list;
//	}
	

}
