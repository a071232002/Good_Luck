package com.ord.dao.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ord.dao.OrderDao;

public class OrderDaoImpl implements OrderDao{
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Integer createOrder(Integer ordNo, Integer ordPrice) {
		String sql = "INSERT INTO `ord`(ordNo , memNo , ordTime , ordShip , ordShippingAds , ordPrice , ordStatus , ordDeliveryTime) " + 
					 " VALUES (:ordNo , :memNo , :ordTime , :ordShip , :ordShippingAds , :ordPrice , :ordStatus , :ordDeliveryTime)";
					 
		Map<String , Object> map = new HashMap<>();
		map.put("ordNo", ordNo);
		map.put("ordPrice", ordPrice);
		
		Date now = new Date();
		map.put("ordTime", now);
		
//		到貨時間 測試用待改
		map.put("ordDeliveryTime", now);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sql , new MapSqlParameterSource(map) , keyHolder);
		
		int ordNoId = keyHolder.getKey().intValue();
		
		
		return ordNoId;
	}
	
	
	
}
