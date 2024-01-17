package com.ord.dao.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.dtl.model.Dtl;
import com.ord.dao.OrderDao;


@Repository
public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Integer createOrder(Integer ordNo, Integer ordPrice ) {
		String sql = "INSERT INTO `ord`( memNo , ordTime , ordShip , ordShippingAds , ordPrice , ordStatus , ordDeliveryTime) " + 
					 " VALUES (:memNo , :ordTime , :ordShip , :ordShippingAds , :ordPrice , :ordStatus , :ordDeliveryTime)";
					 
		Map<String , Object> map = new HashMap<>();
//		map.put("ordNo", ordNo);
		
		map.put("memNo", ordNo);
		map.put("ordTime", "2023-12-26 17:43:39");
		map.put("ordShip", "郵遞4");
		map.put("ordShippingAds", "shipAdd3");
				
		map.put("ordPrice", ordPrice);

		map.put("ordStatus", 2);

		map.put("ordDeliveryTime", ordPrice);
		
		Date now = new Date();
		map.put("ordTime", now);
		
//		到貨時間 測試用待改
		map.put("ordDeliveryTime", now);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sql , new MapSqlParameterSource(map) , keyHolder);
		
		int ordNoId = keyHolder.getKey().intValue();
		
		
		return ordNoId;
	}

	@Override
	public void creteOrderItems(Integer orderId, List<Dtl> DtlItemList) {
		
		for(Dtl DtlItem : DtlItemList) {
			String sql = "INSERT INTO `dtl` (ordNo , proNo , dtlQty, dtlPrice) VALUE " +
						 " (:ordNo , :proNo , :dtlQty, :dtlPrice)";
			
			Map<String , Object> map = new HashMap<>();
			map.put("ordNo", orderId);
//			map.put("proNo", DtlItem.getProNo());
			map.put("proNo", 1);//要從會員來
			
			map.put("dtlQty", DtlItem.getDtlQty());
			map.put("dtlPrice", DtlItem.getDtlQty());
			
			KeyHolder keyHolder = new GeneratedKeyHolder();
			namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder, new String[]{"dtlId"});
			
			 if (keyHolder.getKey() != null) {
		            int generatedDtlId = keyHolder.getKey().intValue();
		            // 在這裡可以使用 generatedDtlId
		        }
		}
		
	}
	
	
	
}
