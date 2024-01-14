package com.ord.service;

import com.ord.dto.CreateOrderRequest;

public interface OrderService {
	
	public Integer createOrder(Integer ordNo, CreateOrderRequest createOrderRequest);
}
