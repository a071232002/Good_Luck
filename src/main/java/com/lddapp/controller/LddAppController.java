package com.lddapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ldd.model.LddService;
import com.lddapp.model.LddApp;
import com.lddapp.model.LddAppService;

@Controller
@RequestMapping("/lddApp")
public class LddAppController {

	@Autowired
	LddAppService lddAppSvc;
	
	@Autowired
	LddService lddSvc;
	
	@GetMapping("addLddApp")
	public String addLddApp(ModelMap model) {
		LddApp lddApp = new LddApp();
		model.addAttribute("lddApp", lddApp);
		return "backStage/lddApp/addLddApp";
	}
	
	
}
