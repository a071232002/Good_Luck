package com.mem.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class MemServiceImpl implements MemService {

	@Autowired
	private MemRepository memRepository;

	// 註冊會員
	@Override
	public Mem register(Mem mem) {
		
		String getMD5 = hashPassword(mem.getMemPsw()); //密碼進行加密
		mem.setMemPsw(getMD5);
		mem.setLastLoginTime(Timestamp.valueOf(LocalDateTime.now()));
		mem.setMemReg(Date.valueOf(LocalDate.now()));
		mem.setMemStatus(Byte.valueOf("0")); //0為信箱未驗證狀態
		Mem newData = memRepository.save(mem);
		return newData;
	}

	// 會員登入
	@Override
	public Mem login(String memMail, String memPsw) {
		
		Mem getMem = memRepository.findByMemMail(memMail);
		
		if(memPsw.trim() != "" && memPsw != null) {
			getMem = (hashPassword(memPsw).equals(getMem.getMemPsw())) ? getMem : null; //核對密碼
		}
		return getMem;
	}

	// 編輯會員
	@Override
	public Mem edit(Mem newData) {
		System.out.println("get memNo" + newData.getMemNo());
		String getMD5 = hashPassword(newData.getMemPsw()); //密碼進行加密
		newData.setMemPsw(getMD5);
		newData.setLastLoginTime(Timestamp.valueOf(LocalDateTime.now())); // 更新最後登入時間
		return memRepository.save(newData);
	}

	// 會員編號查詢
	@Override
	public Mem findByNo(Integer memNo) {
		return memRepository.findById(memNo).orElse(null);
	}

	// 查詢全部會員
	@Override
	public List<Mem> findAll() {
		return memRepository.findAll();
	}

	// 信箱驗證
	@Override
	public boolean verifyMail(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	// 密碼加密
	//參考網站https://jax-work-archive.blogspot.com/2015/02/java.html
	@Override
	public String hashPassword(String memPsw) {
		
		memPsw = "Good " + memPsw + " Luck"; //簡易密碼加鹽

		// 根據 MD5 演算法生成 MessageDigest 物件
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
		byte[] srcBytes = memPsw.getBytes();
		// 使用 srcBytes 更新摘要
		md5.update(srcBytes);
		// 完成哈希計算，得到 result
		byte[] resultBytes = md5.digest();
		return new String(resultBytes);
	}

	// 忘記密碼
	@Override
	public String forgetPsw(String memMail) {
		// 發送隨機密碼簡訊
		return null;
	}

	// 停權會員
	@Override
	public void banMem(Integer memNo) {
		
		//先判斷員工的權限
		
		Mem data = memRepository.findById(memNo).orElse(null);
		// 其他停權動作
		data.setMemStatus(Byte.valueOf("2")); // 2為停權狀態
		edit(data);
	}

}
