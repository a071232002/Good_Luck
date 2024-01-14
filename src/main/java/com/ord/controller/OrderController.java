//package com.ord.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//
//public class OrderController {
//
//	@Autowired
//	private OrderService orderService;
//	
//	public ResponseEntity<?> createOrder(@PathVariable Integer userId,
//										 @RequestBody CreateOrderRequest createOrderRequest){
//		
//		Integer orderId = orderService.createOrder(userId , createOrderRequest);
//		
//		return ResponseEntity.status(HttpStatus.CREATED).body(orderId);
//	}
//	
//}
