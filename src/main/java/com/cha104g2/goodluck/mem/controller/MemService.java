package com.mem.controller;

import com.mem.model.MemDao;
import com.mem.model.MemDaoImplements;
import com.mem.model.MemVo;

public class MemService {
	private MemDao dao;

	public MemService() {
		dao = new MemDaoImplements();
	}

	public MemVo addMem(Integer memNo, String memMail, String memPsw, Integer memSex, String memPhone,
			java.sql.Date memReg, Integer memeStatus, java.sql.Date lastLoginTime, byte[] memPic) {

		MemVo memVo = new MemVo();

		memVo.setMemNo(memNo);
		memVo.setMemMail(memMail);
		memVo.setMemPsw(memPsw);
		memVo.setMemSex(memSex);
		memVo.setMemPhone(memPhone);
		memVo.setMemReg(lastLoginTime);
		memVo.setMemStatus(memeStatus);
		memVo.setlastLoginTime(lastLoginTime);
		memVo.setMemPic(memPic);

		return memVo;
	}
}
