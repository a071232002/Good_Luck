package com.ord.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ord.dao.OrderDao;
import com.ord.dto.BuyItem;
import com.ord.dto.CreateOrderRequest;
import com.ord.service.OrderService;
import com.product.model.ProDAO;
import com.product.model.ProVO;
@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ProDAO proDao;
	
//	List<>
	
	
	
	@Override
	public Integer createOrder(Integer ordNo, CreateOrderRequest createOrderRequest) {
		
		int totalPrice = 0;
		
		for(BuyItem buyItem : createOrderRequest.getBuyItemList()) {
//			TODO轉成proNo
			List<ProVO> product = proDao.getAll();
			
		}
		
		
		return totalPrice;
	}
	
}
