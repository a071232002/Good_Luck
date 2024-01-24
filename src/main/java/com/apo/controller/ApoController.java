package com.apo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.apo.model.Apo;
import com.apo.model.ApoDTO;
import com.apo.model.ApoService;
import com.google.gson.Gson;
import com.mem.model.Mem;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/apo")
public class ApoController {

	@Autowired
	ApoService apoSvc;
	
	//TODO for測試index 頁面沒做
	@GetMapping("")
	public String indexOfApo(ModelMap model) {
		return "";
	}
	
	@GetMapping("/addApo")
	public String addApo(ModelMap model) {
		Apo apo = new Apo();
		model.addAttribute(apo);
		return "FrontEnd/apo/addApo";
	}
	
	@PostMapping("/updateApo")
	public String updateData(ModelMap model, @ModelAttribute("apoNo") String apoNo) {
		Apo dataORI = apoSvc.getOneApo(Integer.valueOf(apoNo));
		model.addAttribute("apo",dataORI);
		return "FrontEnd/apo/updateApo";
	}
	
	//會員瀏覽
	@GetMapping("/listAllApo")
	public String queryApoByMember(ModelMap model) {
		return "FrontEnd/apo/listAllApo";
	}

	//房東瀏覽
	@GetMapping("/reviewApo")
	public String reviewApoByLdd(ModelMap model) {
		return "FrontEnd/apo/reviewApo";
	}
	
	//會員-預約操作
	@PostMapping("insert")
	public String insert (@Valid Apo apo,
			BindingResult result, ModelMap model) {
		apoSvc.addApo(apo);
		return "redirect:/apo/listAllApo";
	}
	
	@PostMapping("update")
	public String update(@Valid Apo apo,
			BindingResult result, ModelMap model) {
		apoSvc.upDateApo(apo);
		return "redirect:/apo/listAllApo";
	}
	
	@PostMapping("cancel")
	public String cancel(ModelMap model, @ModelAttribute("apoNo")String apoNo) {
		Apo apo = apoSvc.getOneApo(Integer.valueOf(apoNo)); 
		apoSvc.cancelApo(apo);
		return "redirect:/apo/listAllApo";
	}
	
	@PostMapping("want")
	public String want(@Valid Apo apo, BindingResult result, ModelMap model) {
		Apo data = apoSvc.getOneApo(Integer.valueOf(apo.getApoNo()));
		data.setApoWantDate(apo.getApoWantDate());
		apoSvc.want(data);
		return "redirect:/apo/listAllApo";
	}
	
	@PostMapping("updateWantDate")
	public String updateWantDate(@Valid Apo apo, BindingResult result, ModelMap model) {
		Apo data = apoSvc.getOneApo(Integer.valueOf(apo.getApoNo()));
		data.setApoWantDate(apo.getApoWantDate());
		apoSvc.want(data);
		return "redirect:/apo/listAllApo";
	}
	
	@PostMapping("cancelWant")
	public String cancelWant(ModelMap model, @ModelAttribute("apoNo")String apoNo) {
		Apo apo = apoSvc.getOneApo(Integer.valueOf(apoNo)); 
		apoSvc.cancelWant(apo);
		return "redirect:/apo/listAllApo";
	}
	
	//房東-預約操作
	@PostMapping("reject")
	public String reject(ModelMap model, @ModelAttribute("apoNo")String apoNo) {
		Apo apo = apoSvc.getOneApo(Integer.valueOf(apoNo)); 
		apoSvc.rejectApo(apo);
		return "redirect:/apo/reviewApo";
	}
	
	@PostMapping("approve")
	public String approve(ModelMap model, @ModelAttribute("apoNo")String apoNo) {
		Apo apo = apoSvc.getOneApo(Integer.valueOf(apoNo)); 
		apoSvc.approveApo(apo);
		return "redirect:/apo/reviewApo";
	}
	
	@PostMapping("complete")
	public String complete(ModelMap model, @ModelAttribute("apoNo")String apoNo) {
		Apo apo = apoSvc.getOneApo(Integer.valueOf(apoNo));
		apoSvc.completeApo(apo);
		return "redirect:/apo/reviewApo";
	}
	
	@PostMapping("approveWant")
	public String approveWant(RedirectAttributes redirect, @ModelAttribute("apoNo")String apoNo) {
		redirect.addAttribute("apoNo", apoNo);
		return "redirect:/lse/addLse";
	}
	
	@PostMapping("rejectWant")
	public String rejiectWant(ModelMap model, @ModelAttribute("apoNo")String apoNo) {
		Apo apo = apoSvc.getOneApo(Integer.valueOf(apoNo));
		apoSvc.rejectWant(apo);
		return "redirect:/apo/reviewApo";
	}
	
	//TODO 根據會員編號取得對應的預約單 之後要從登入user取得
	@ModelAttribute("apoListData")
	public List<Apo> referenceListData(HttpSession session) {
		Mem mem = new Mem();
		mem.setMemNo(1);
		return apoSvc.getApoListByMem(mem);
	}
	
	//TODO 根據會員編號取得對應的預約單 之後要從登入user取得
	@ModelAttribute("apoListDataByLdd")
	public List<Apo> referenceListDataByLdd(HttpSession session) {
		return apoSvc.getApoListByLdd(1);
	}
	
	//接收ajax 以JSON回傳物件已booking的時段 查出物件被booking的時段
//	@PostMapping("/apoStatus/{rentNo}")
//	public ResponseEntity<String> alreadyApoData(@PathVariable String rentNo){
//		List<ApoDTO> apoList = apoSvc.getListWithBookingByRentNo(Integer.valueOf(rentNo));
//		Gson gson = new Gson();
//	    String response = gson.toJson(apoList);
//		return new ResponseEntity<>(response, HttpStatus.OK);
//	}
	
	@PostMapping("/apoStatus/{rentNo}")
	public @ResponseBody List<ApoDTO> alreadyApoData(@PathVariable String rentNo){
//		List<ApoDTO> apoList = apoSvc.getListWithBookingByRentNo(Integer.valueOf(rentNo));
//		Gson gson = new Gson();
//		String response = gson.toJson(apoList);
		System.out.println(apoSvc.getListWithBookingByRentNo(Integer.valueOf(rentNo)));
		return apoSvc.getListWithBookingByRentNo(Integer.valueOf(rentNo));
	}

	//接收ajax 以JSON回傳物件已booking的時段 查出房東已被booking的時段
	//TODO rentSvc getone to find lddnodno
//	@PostMapping("/apoStatus/{rentNo}")
//	public ResponseEntity<String> alreadyApoData(@PathVariable String rentNo){
//		
//		
//		List<ApoDTO> apoList = apoSvc.getListWithBookingByRentNo(Integer.valueOf(rentNo));
//		Gson gson = new Gson();
//	    String response = gson.toJson(apoList);
//		return new ResponseEntity<>(response, HttpStatus.OK);
//	}
	
}
