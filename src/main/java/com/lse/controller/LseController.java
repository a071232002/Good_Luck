package com.lse.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.apo.model.Apo;
import com.apo.model.ApoService;
import com.ldd.model.Ldd;
import com.lse.model.Lse;
import com.lse.model.LseService;
import com.mem.model.Mem;

@Controller
@RequestMapping("/lse")
public class LseController {
	
	@Autowired
	ApoService apoSvc;
	
	@Autowired
	LseService lseSvc;
	
	@GetMapping("/addLse")
	public String addLse(ModelMap model, @ModelAttribute("apoNo")String apoNo) {
		Apo apo = apoSvc.getOneApo(Integer.valueOf(apoNo));
		Lse lse = new Lse();
		// 帶apo物件資料進lse EL取值
		model.addAttribute(apo);
		// 給合約新增用的空物件
		model.addAttribute(lse);
		return "FrontEnd/lse/addLse";
	}
	
	@PostMapping("/updateLse")
	public String updateData(ModelMap model, @ModelAttribute("lseNo") String lseNo) {
		Apo dataORI = apoSvc.getOneApo(Integer.valueOf(lseNo));
		model.addAttribute("lse",dataORI);
		return "FrontEnd/apo/updateLse";
	}
	
	@GetMapping("/listAllLse")
	public String queryLseByMember(ModelMap model) {
		return "FrontEnd/lse/listAllLse";
	}
	
	@GetMapping("/reviewLse")
	public String reviewLseByLdd(ModelMap model) {
		return "FrontEnd/lse/reviewLse";
	}
	
	//TODO 新增尚未完工
	@PostMapping("insert")
	public String insert(@RequestParam("lseSend") MultipartFile part,@Valid Lse lse,
			BindingResult result, ModelMap model, @ModelAttribute("apoNo") String apoNo) {
		
		System.out.println(lse);
		System.out.println(apoNo);
		// 產生合約後才變更租屋單狀態
//		apoSvc.approveWant(Integer.valueOf(apoNo));
		return "redirect:/apo/reviewApo";
	}
	
	@ModelAttribute("lseListData")
	public List<Lse> referenceListDataByMem(HttpSession session) {
		Mem mem = (Mem)session.getAttribute("logsuccess");
		return lseSvc.getListByMem(mem);
	}
	
	@ModelAttribute("lseListDataByLdd")
	public List<Lse> referenceListDataByLdd(HttpSession session) {
		Ldd ldd = (Ldd)session.getAttribute("Ldd");
		return lseSvc.getListByLdd(ldd);
	}
	
	
}
