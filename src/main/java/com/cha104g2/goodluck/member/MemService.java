package com.cha104g2.goodluck.member;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class MemService {
	private MemDAO dao = null;
	
	public MemService() {
		dao = new MemDAOImp();
	}
	
	//�s�W
	public Mem insert(String memMail, String memPsw, String memName, Byte memSex, String memPhone, 
			String memAdd, String memID, Date memReg, Byte memStatus, Timestamp lastLoginTime, 
			byte[] memPic) {
		Mem memData = new Mem();
		memData.setMemMail(memMail);
		memData.setMemPsw(memPsw);
		memData.setMemName(memName);
		memData.setMemSex(memSex);
		memData.setMemPhone(memPhone);
		memData.setMemAdd(memAdd);
		memData.setMemID(memID);
		memData.setMemReg(memReg);
		memData.setMemStatus(memStatus);
		memData.setLastLoginTime(lastLoginTime);
		memData.setMemPic(memPic);
		dao.insert(memData);
		
		return memData;
	}

	//�s���d��
	public Mem getOneByNo(Integer memNo) {
		return dao.findByPrimaryKey(memNo);
	}
	
	//�d�ߥ���
	public List<Mem> getAll(){
		return dao.findAll();
	}
	
	
}
