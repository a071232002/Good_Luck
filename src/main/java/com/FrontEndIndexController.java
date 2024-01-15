package com;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ord.dto.CreateOrderRequest;
import com.rtn.service.RtnService;

@Validated
@Controller
//@RequestMapping("/BackStage")
//@ComponentScan(basePackages = "com")
public class FrontEndIndexController {
	@Autowired
	public RtnService rtnService;

//	前台首頁|前台|Supper
	@GetMapping("/")
	public String login(String userName ,
						String userPassword ,
						Model model){
//		String activeNavItemId = "/Good_Luck/icon/BackStage/indexJS";
//		model.addAttribute("activeNavItemId", activeNavItemId);
		return "FrontEnd/index";
	}
	
//	前台首頁|前台|Supper
	@GetMapping("/shop")
	public String shop(){
//		String activeNavItemId = "/Good_Luck/icon/BackStage/indexJS";
//		model.addAttribute("activeNavItemId", activeNavItemId);
		return "FrontEnd/shop/shop";
	}
	
//	@PostMapping("")
//	public ResponseEntity<?> createOrder(@PathVariable Integer usedId,
//										 @RequestBody @Valid CreateOrderRequest createOrderRequest){
//		Integer orderId = OrderService.
//	}
	
	
	
////	前台登入|前台|
//	@GetMapping("/login")
//	public String login() {
//		return "FrontEnd/login";
//	}

////	GET導向退會單|前台|Sub
//	@GetMapping("/Rtn")
//	public String GoRtn(Model model) {
//		model.addAttribute("activeNavItemId", "/Good_Luck/icon/BackStage/indexJS");
//		return "redirect:/BackStage/RtnManage";
//	}
}


