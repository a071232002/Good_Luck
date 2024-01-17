package com.ord.dao;

import java.util.List;

import com.dtl.model.Dtl;

public interface OrderDao {
	
	Integer createOrder(Integer userId , Integer totalAmount);
	
	void creteOrderItems(Integer orderId, List<Dtl> DtlItemList );
}
