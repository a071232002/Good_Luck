package com.lse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apo.model.Apo;
import com.apo.model.ApoService;
import com.lse.model.Lse;
import com.lse.model.LseService;

@Controller
@RequestMapping("lse")
public class LseController {
	
	@Autowired
	ApoService apoSvc;
	
	@Autowired
	LseService lseSvc;
	
	//TODO for test
	public String indexOfLse(ModelMap model) {
		return"";
	}
	
	@GetMapping("/addLse")
	public String addLse(ModelMap model, @ModelAttribute("apoNo")String apoNo) {
		Apo apo = apoSvc.getOneApo(Integer.valueOf(apoNo));
		Lse lse = new Lse();
		model.addAttribute(apo);
		model.addAttribute(lse);
		return "FrontEnd/apo/addApo/";
	}
	
	@PostMapping("/updateLse")
	public String updateData(ModelMap model, @ModelAttribute("lseNo") String lseNo) {
		Apo dataORI = apoSvc.getOneApo(Integer.valueOf(lseNo));
		model.addAttribute("lse",dataORI);
		return "FrontEnd/apo/updateLse";
	}
	
	@GetMapping("/listAllLse")
	public String getAll(ModelMap model) {
		return "FrontEnd/apo/listAllLse";
	}
	
	
	
}
