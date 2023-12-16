package com.cha104g2.goodluck.member;

import java.util.List;

public interface MemDAO {
	public void insert(Mem mem);
	public Mem findByPrimaryKey(Integer memno);
	public List<Mem> findAll();
}
