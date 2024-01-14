package com.ord.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ord.dto.CreateOrderRequest;
import com.ord.service.OrderService;


@CrossOrigin(origins = "http://127.0.0.1:5500")
@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/mems/{memNo}orders")
	public ResponseEntity<?> createOrder(@PathVariable Integer memNo,
										 @RequestBody @Valid CreateOrderRequest createOrderRequest){
		
		Integer orderId = orderService.createOrder(memNo , createOrderRequest);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(orderId);
	}
	
}
