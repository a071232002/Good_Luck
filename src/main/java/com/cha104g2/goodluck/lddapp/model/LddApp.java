package com.cha104g2.goodluck.lddapp.model;

import java.io.Serializable;
import java.sql.Date;

public class LddApp implements Serializable{
	private Integer lddAppNo;
	private Integer memNo;
	private Integer empNo;
	private Date lddAppCreate;
	private byte[] lddAppIDPic;
	private Integer lddAppPayStatus;
	private Integer lddAppStatus;
	
	public LddApp() {
	}

	
	
	public Integer getLddAppNo() {
		return lddAppNo;
	}



	public void setLddAppNo(Integer lddAppNo) {
		this.lddAppNo = lddAppNo;
	}



	public Integer getMemNo() {
		return memNo;
	}



	public void setMemNo(Integer memNo) {
		this.memNo = memNo;
	}



	public Integer getEmpNo() {
		return empNo;
	}



	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}



	public Date getLddAppCreate() {
		return lddAppCreate;
	}



	public void setLddAppCreate(Date lddAppCreate) {
		this.lddAppCreate = lddAppCreate;
	}



	public byte[] getLddAppIDPic() {
		return lddAppIDPic;
	}



	public void setLddAppIDPic(byte[] lddAppIDPic) {
		this.lddAppIDPic = lddAppIDPic;
	}



	public Integer getLddAppPayStatus() {
		return lddAppPayStatus;
	}



	public void setLddAppPayStatus(Integer lddAppPayStatus) {
		this.lddAppPayStatus = lddAppPayStatus;
	}



	public Integer getLddAppStatus() {
		return lddAppStatus;
	}



	public void setLddAppStatus(Integer lddAppStatus) {
		this.lddAppStatus = lddAppStatus;
	}



	@Override
	public String toString() {
		return "lddApp [lddAppNo=" + lddAppNo + ", memNo=" + memNo + ", empNo=" + empNo + ", lddAppCreate=" + lddAppCreate + ", lddAppIDPic=" + lddAppIDPic + ", lddAppPayStatus=" + lddAppPayStatus + ", lddAppStatus=" + lddAppStatus + "]";
	}
	
	
}
