package com.apo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apo.model.Apo;
import com.apo.model.ApoService;
import com.lddapp.model.LddApp;

@Controller
@RequestMapping("/apo")
public class ApoController {

	@Autowired
	ApoService apoSvc;
	
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
	
	@PostMapping("insert")
	public String insert (@Valid Apo apo,
			BindingResult result, ModelMap model) {
		apoSvc.addApo(apo);
		return "";
	}
}
