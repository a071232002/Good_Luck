package com.apo.controller;

import java.util.List;

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

import com.apo.model.Apo;
import com.apo.model.ApoDTO;
import com.apo.model.ApoService;
import com.google.gson.Gson;
import com.mem.model.Mem;

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
	
	@PostMapping("/updateApo")
	public String updateData(ModelMap model, @ModelAttribute("apoNo") String apoNo) {
		Apo dataORI = apoSvc.getOneApo(Integer.valueOf(apoNo));
		model.addAttribute("apo",dataORI);
		return "FrontEnd/apo/updateApo";
	}
	
	@GetMapping("/listAllApo")
	public String queryApoByMember(ModelMap model) {
		return "FrontEnd/apo/listAllApo";
	}
	
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
	
	@ModelAttribute("apoListData")
	public List<Apo> referenceListData() {
		Mem mem = new Mem();
		mem.setMemNo(1);
		return apoSvc.getApoByMem(mem);
	}
	
	@PostMapping("/apoStatus/{rentNo}")
	public ResponseEntity<String> alreadyApoData(@PathVariable String rentNo){

		List<ApoDTO> apoList = apoSvc.getListByRentNoWithBooking(Integer.valueOf(rentNo));

		Gson gson = new Gson();
	    String response = gson.toJson(apoList);
	    
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
