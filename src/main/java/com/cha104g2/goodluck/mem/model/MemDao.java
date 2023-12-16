package com.mem.model;

public interface MemDao {
	public void insert(MemVo memvo);

	public void update(MemVo memvo);

	public void delete(MemVo memvo);

	public MemVo findByPrmaryKey(Integer memvo);

}
