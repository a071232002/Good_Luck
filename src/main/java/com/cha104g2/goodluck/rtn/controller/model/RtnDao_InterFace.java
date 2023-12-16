package com.rtn.controller.model;

import java.util.List;

public interface RtnDao_InterFace {
	public RtnVo findByPrimaryKey(Integer rtnNo);

	public void insert(RtnVo rtnvo);

	public void update(RtnVo rtnvo);

	public void delete(Integer rtnNo);

//	管理員使用
	public List<RtnVo> getAll();

}
