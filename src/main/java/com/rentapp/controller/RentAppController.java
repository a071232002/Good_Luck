package com.rentapp.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rentapp.model.*;

@Controller
@RequestMapping("/BackStage/rentApp")
public class RentAppController {
	
	@Autowired
	RentAppService rentAppSvc;
	
	//前往新增頁面
	@GetMapping("addRentApp")
	public String addEmp(ModelMap model) {
		RentApp rentApp = new RentApp();
		model.addAttribute("rentApp", rentApp);
		return "BackStage/rentapp/addRentApp";
	}
	
	@PostMapping("insert")
	public String insert(@Valid RentApp rentApp, BindingResult result, ModelMap model,
			@RequestParam("upFiles") MultipartFile[] parts) throws IOException {

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		// 去除BindingResult中upFiles欄位的FieldError紀錄 --> 見第172行
		result = removeFieldError(rentApp, result, "upFiles");

		if (parts[0].isEmpty()) { // 使用者未選擇要上傳的圖片時
			model.addAttribute("errorMessage", "所有權狀: 請上傳照片");
		} else {
			for (MultipartFile multipartFile : parts) {
				byte[] buf = multipartFile.getBytes();
				rentApp.setRentAppOwn(buf);
			}
		}
		if (result.hasErrors() || parts[0].isEmpty()) {
			return "BackStage/rentapp/addRentApp";
		}
		/*************************** 2.開始新增資料 *****************************************/
		// EmpService empSvc = new EmpService();
		rentAppSvc.addRentApp(rentApp);
		/*************************** 3.新增完成,準備轉交(Send the Success view) **************/
		List<RentApp> list = rentAppSvc.getAll();
		model.addAttribute("rentAppListData", list);
		model.addAttribute("success", "- (新增成功)");
		return "redirect:/rentapp/listAllRentApp"; // 新增成功後重導至IndexController_inSpringBoot.java的第50行@GetMapping("/emp/listAllEmp")
	}
	
	@PostMapping("getOne_For_Update")
	public String getOne_For_Update(@RequestParam("rentNo") String rentNo, ModelMap model) {
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		/*************************** 2.開始查詢資料 *****************************************/
		// EmpService empSvc = new EmpService();
		RentApp rentApp = rentAppSvc.getOneRentApp(Integer.valueOf(rentNo));

		/*************************** 3.查詢完成,準備轉交(Send the Success view) **************/
		model.addAttribute("rentApp", rentApp);
		return "BackStage/rentapp/update_rentApp_input"; // 查詢完成後轉交update_emp_input.html
	}

	@PostMapping("update")
	public String update(@Valid RentApp rentApp, BindingResult result, ModelMap model,
			@RequestParam("upFiles") MultipartFile[] parts) throws IOException {

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 ************************/
		// 去除BindingResult中upFiles欄位的FieldError紀錄 --> 見第172行
		result = removeFieldError(rentApp, result, "upFiles");

		if (parts[0].isEmpty()) { // 使用者未選擇要上傳的新圖片時
			// EmpService empSvc = new EmpService();
			byte[] upFiles = rentAppSvc.getOneRentApp(rentApp.getRentAppNo()).getRentAppOwn();
			rentApp.setRentAppOwn(upFiles);
		} else {
			for (MultipartFile multipartFile : parts) {
				byte[] upFiles = multipartFile.getBytes();
				rentApp.setRentAppOwn(upFiles);
			}
		}
		if (result.hasErrors()) {
			return "BackStage/rentapp/update_rentApp_input";
		}
		/*************************** 2.開始修改資料 *****************************************/
		// EmpService empSvc = new EmpService();
		rentAppSvc.updateRentApp(rentApp);

		/*************************** 3.修改完成,準備轉交(Send the Success view) **************/
		model.addAttribute("success", "- (修改成功)");
		rentApp = rentAppSvc.getOneRentApp(Integer.valueOf(rentApp.getRentAppNo()));
		model.addAttribute("rentApp", rentApp);
		return "BackStage/rentapp/listOneRentApp"; // 修改成功後轉交listOneEmp.html
	}
	
	public BindingResult removeFieldError(RentApp rentApp, BindingResult result, String removedFieldname) {
		List<FieldError> errorsListToKeep = result.getFieldErrors().stream()
				.filter(fieldname -> !fieldname.getField().equals(removedFieldname))
				.collect(Collectors.toList());
		result = new BeanPropertyBindingResult(rentApp, "rentApp");
		for (FieldError fieldError : errorsListToKeep) {
			result.addError(fieldError);
		}
		return result;
	}

}
