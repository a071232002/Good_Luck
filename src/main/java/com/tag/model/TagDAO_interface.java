package com.tag.model;

import java.util.List;
import java.util.Set;

import com.product.model.*;

public interface TagDAO_interface {
	public void insert(TagVO tagVO);
	public void update(TagVO tagVO);
	public void delete(Integer tagNo);
	public TagVO findByPrimaryKey(Integer tagNo);
	public List<TagVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
	// public List<TagVO> getAll(Map<String, String[]> map);
		
	 //查詢某部門的員工(一對多)(回傳 Set)
    public Set<ProVO> getProsByTagNo(Integer tagNo);
}

