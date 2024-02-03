package com.mem.model;

import java.util.List;

public interface MemService {

	// 註冊會員
	public Mem register(Mem mem);

	// 會員登入
	public Mem login(String memMail, String memPsw);

	// 編輯會員
	public Mem edit(Mem newData);

	//變更會員大頭照
	public void changePic(Mem mem, byte[] memPic);
	
	// 會員編號查詢
	public Mem findByNo(Integer memNo);

	// 查詢全部會員
	public List<Mem> findAll();

	// 信箱驗證
	public boolean verifyMail(String word, String subject, String text, String verifyID);

	// 密碼加密
	public String hashPassword(String memPsw);

	// 忘記密碼
	public boolean forgetPsw(String memMail);

	// 停權會員
	public void banMem(Integer memNo);
	
	//變更密碼
	public Mem changePsw(Mem mem, String newMemPsw);
	
	public boolean existMemPhone(String memPhone);
	
	public boolean existMemID(String memID);

	public String redisTest();

}
