package com.emp.service.Impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.model.Emp;
import com.emp.model.EmpRepository;
import com.emp.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpRepository empRepository;
	
	//單一員工查詢
	@Override
	public Emp getById(Integer empNo) {
		Optional<Emp> emp = empRepository.findById(empNo);
		return emp.orElse(null);
	}

	// 員工登入
	@Override
	public Emp empLogin(Integer empNo, String empPsw) {
		System.out.println(empNo);
		Emp getEmp = getById(empNo);
		if(empPsw.equals(getEmp.getEmpPsw())) {
			return getEmp;
		}
		return null;
//		Emp getEmp = getById(empNo);
//		getEmp = getEmp == null ? null : empPsw.equals(getEmp.getEmpPsw()) ? getEmp : null;
//		return getEmp;
	}

	// 查詢員工全部資料
	@Override
	public List<Emp> findAll() {
		return empRepository.findAll();
	}

	// 員工編輯資料((有權限才可改)姓名、密碼)
	@Override
	public Emp editEmp(Emp newEmp) {
		
		//比對權限是否符合
		newEmp.setEmpPsw(hashPassword(newEmp.getEmpPsw())); //加密
		return empRepository.save(newEmp);
	}

	// 員工離職
	@Override
	public Emp resignEmp(Emp emp) {
		emp.setEmpStatus(Byte.valueOf("1")); //1為離職狀態
		//功能權限移除
		return null;
	}

	// 新增員工
	@Override
	public Emp registerEmp(Emp newEmp) {
		newEmp.setEmpStatus(Byte.valueOf("0")); //0為在職狀態
		newEmp.setEmpPsw(hashPassword(newEmp.getEmpPsw())); //加密
		return empRepository.save(newEmp);
	}

	// 密碼加密
	//參考網站https://jax-work-archive.blogspot.com/2015/02/java.html
	@Override
	public String hashPassword(String empPsw) {
		
		empPsw = "Good " + empPsw + " Luck"; //簡易密碼加鹽

		// 根據 MD5 演算法生成 MessageDigest 物件
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
		byte[] srcBytes = empPsw.getBytes();
		// 使用 srcBytes 更新摘要
		md5.update(srcBytes);
		// 完成哈希計算，得到 result
		byte[] resultBytes = md5.digest();
		return new String(resultBytes);
	}
	
}
