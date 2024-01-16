package com;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ord.dto.CreateOrderRequest;
import com.ord.service.OrderService;
import com.rtn.service.RtnService;

@Validated
@Controller
//@RequestMapping("/BackStage")
//@ComponentScan(basePackages = "com")
public class FrontEndIndexController {
	@Autowired
	public RtnService rtnService;
	
	
	
	@Autowired
	private OrderService orderService;
	
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
		
	
	@PostMapping("/mems/{memNo}/orders")
//	@GetMapping("/mems/{memNo}/orders")
//	@PostMapping("/orders") //test
//	@GetMapping("/orders")
	public ResponseEntity<?> createOrder(@PathVariable Integer memNo,
//	public String createOrder(@PathVariable Integer memNo,
							  @RequestBody CreateOrderRequest createOrderRequest){
//										@RequestBody @Valid CreateOrderRequest createOrderRequest){
	
		
//		Mem mem = new Mem().setMemNo(1);
		
		System.out.println("memNo: " + memNo);
//		System.out.println(createOrderRequest);
		
		Integer orderId = orderService.createOrder(memNo , createOrderRequest);
		
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(orderId);
//		return "123";
	}
	
	
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


