package com.ord.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ord.dao.OrderDao;
import com.ord.service.OrderService;
import com.product.model.ProVO;

public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ProVO product;
	
	
	
	
	
	@Override
	public Integer createOrder(Integer ordNo, Integer ordPrice) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
