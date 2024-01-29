package com.ldd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lse.model.LseService;
import com.rent.model.RentService;

@Controller
@RequestMapping("/ldd")
public class lddController {
	
	@Autowired
	RentService rentSvc;
	
	@Autowired
	LseService lseSvc;
	
	
}
