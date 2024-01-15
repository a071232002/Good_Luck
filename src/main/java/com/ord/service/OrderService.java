package com.ord.service;

import org.springframework.stereotype.Service;

import com.ord.dto.CreateOrderRequest;





public interface OrderService {
	
	public Integer createOrder(Integer ordNo,  CreateOrderRequest createOderRequest);
}
