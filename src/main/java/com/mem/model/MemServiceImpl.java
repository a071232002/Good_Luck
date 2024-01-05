package com.mem.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class MemServiceImpl implements MemService{

	@Autowired
	private MemRepository memRepository;
	
	//註冊會員
	@Override
	public Integer register(Mem mem) {
		mem.setLastLoginTime(Timestamp.valueOf(LocalDateTime.now()));
		mem.setMemReg(Date.valueOf(LocalDate.now()));
		mem.setMemStatus(Byte.valueOf("0"));
		Mem newData = memRepository.save(mem);
		return newData.getMemNo();
	}

	//會員登入
	@Override
	public Mem login(String memMail, String memPsw) {
		// TODO Auto-generated method stub
		return null;
	}

	//編輯會員
	@Override
	public Mem edit(Mem newData) {
		System.out.println("get memNo" + newData.getMemNo());
		return memRepository.save(newData);
	}
	
	//會員編號查詢
	@Override
	public Mem findByNo(Integer memNo) {
		return memRepository.findById(memNo).orElse(null);
	}
	

	//查詢全部會員
	@Override
	public List<Mem> findAll() {
		return memRepository.findAll();
	}

	//信箱驗證
	@Override
	public boolean verifyMail(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	//密碼加密
	@Override
	public String hashPassword(String memPsw) {
		// TODO Auto-generated method stub
		return null;
	}

	//忘記密碼
	@Override
	public String forgetPsw(String memMail) {
		// TODO Auto-generated method stub
		return null;
	}

}
