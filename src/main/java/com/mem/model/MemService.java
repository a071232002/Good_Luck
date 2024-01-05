package com.mem.model;

import java.util.List;

public interface MemService {
	
	//註冊會員
	public Integer register(Mem mem);
	
	//會員登入
	public Mem login(String memMail, String memPsw);
	
	//編輯會員
	public Mem edit(Mem newData);
	
	//會員編號查詢
	public Mem findByNo(Integer memNo);
	
	//查詢全部會員
	public List<Mem> findAll();
	
	//信箱驗證
	public boolean verifyMail(String word);
	
	//密碼加密
	public String hashPassword(String memPsw);
	
	//忘記密碼
	public String forgetPsw(String  memMail);
	
	
}
