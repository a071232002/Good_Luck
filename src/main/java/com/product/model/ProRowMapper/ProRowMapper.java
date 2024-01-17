package com.product.model.ProRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.product.model.ProVO;

public class ProRowMapper implements RowMapper<ProVO> {

	@Override
	public ProVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ProVO pro = new ProVO();
		pro.setProNo(rs.getInt("proNo"));
		pro.setProName(rs.getString("proName"));
		pro.setProMean(rs.getString("proMean"));
		pro.setProPrice(rs.getInt("proPrice"));
		pro.setProQty(rs.getInt("proQty"));
		pro.setProImg(rs.getBytes("proImg"));
		
		 Timestamp timestamp = rs.getTimestamp("proCreateTime");
		    if (timestamp != null) {
		        LocalDateTime proCreateTime = timestamp.toLocalDateTime();
		        pro.setProCreateTime(proCreateTime);
		    }
		    
		 
		pro.setProNo(rs.getInt("proStatus"));
		pro.setProNo(rs.getInt("tagNo"));
		pro.setProNo(rs.getInt("empNo"));
		
		
		return pro;
	}
	
}
