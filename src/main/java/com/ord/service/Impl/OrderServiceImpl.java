package com.ord.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtl.model.Dtl;
import com.ord.dao.OrderDao;
import com.ord.dto.BuyItem;
import com.ord.dto.CreateOrderRequest;
import com.ord.service.OrderService;
import com.product.model.ProVO;
import com.product.model.Impl.ProJDBCDAO;
@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
//	private ProDAO proDao;
	private ProJDBCDAO proDao;
	
	List<Dtl> DtlItemList = new ArrayList<>(); 

	
	
	@Override
	public Integer createOrder(Integer ordNo, CreateOrderRequest createOrderRequest) {
		
		int totalPrice = 0;
		
		for(BuyItem buyItem : createOrderRequest.getBuyItemList()) {
//			TODO轉成proNo
			List<ProVO> product = proDao.getAll();
			
			for(ProVO productItem : product) {
				Integer proNo = productItem.getProNo();
				System.out.println("proNo: " + proNo);
			}
			
			totalPrice += buyItem.getOrdPrice();
			
			Dtl DtlVO = new Dtl();
			DtlVO.setOrdNo(buyItem.getOrdNo()); //訂單編號 Not Null(PK,FK)
//			DtlVO.setProNo(buyItem); //商品編號 Not Null(PK,FK)
			DtlVO.setDtlQty(buyItem.getOrdPrice()); //商品訂購數量
//			DtlVO.setDtlSell(ordNo); //訂購單價
			
			System.out.println(buyItem.getOrdNo());
			System.out.println(buyItem.getOrdPrice());
			
			DtlItemList.add(DtlVO);
		}
		
		Integer orderId = orderDao.createOrder(ordNo, totalPrice);
		
		orderDao.creteOrderItems(orderId, DtlItemList);
				
		return totalPrice;
	}
	
}
