package com.ord.dao;

public interface OrderDao {
	
	Integer createOrder(Integer userId , Integer totalAmount);
}
