package com.mem.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class IndexController {
	
	@Autowired
	private MemService memservice;
	
	//前往查詢頁面
	@GetMapping("/mem/memlist")
	public String showList(ModelMap model) {
		return "mem/listAllMem";
	}
	
	
	
	//設置查詢全部屬性
    @ModelAttribute("memListData")
	protected List<Mem> referenceListData() {
    	List<Mem> list = memservice.findAll();
		return list;
	}

}
