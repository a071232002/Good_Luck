package com.product.model.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.product.model.ProDAO_interface;
import com.product.model.ProVO;
import com.product.model.ProRowMapper.ProRowMapper;

@Component
public class ProJDBCDAO implements ProDAO_interface {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public void insert(ProVO proVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ProVO proVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer proNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProVO findByPrimaryKey(Integer proNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProVO> getAll() {
		String sql = "SELECT * FROM `pro`";
		
//		Map<String , Object> map = new HashMap<>();
		
		List<ProVO> ProList = namedParameterJdbcTemplate.query(sql, new ProRowMapper());
		
//		if(ProList.size() > 0) {
//			return ProList.get(0);
//		}else {
//			return null;
//		}
		return null;
	}
}
