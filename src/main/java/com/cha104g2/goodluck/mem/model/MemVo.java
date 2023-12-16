package com.mem.model;

import java.sql.Date;

public class MemVo {

	private Integer memNo;
	private String memMail;
	private String memPsw;
	private String memName;
	private Integer memSex;
	private String memPhone;
	private String memAdd;
	private String memID;
	private Date memReg;
	private Integer memStatus;
	private Date lastLoginTime;
	private byte[] memPic;

	public Integer getMemNo() {
		return memNo;
	}

	public void setMemNo(Integer memNo) {
		this.memNo = memNo;
	}

	public String getMemMail() {
		return memMail;
	}

	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}

	public String getMemPsw() {
		return memPsw;
	}

	public void setMemPsw(String memPsw) {
		this.memPsw = memPsw;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public Integer getMemSex() {
		return memSex;
	}

	public void setMemSex(Integer memSex) {
		this.memSex = memSex;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public String getMemAdd() {
		return memAdd;
	}

	public void setMemAdd(String memAdd) {
		this.memAdd = memAdd;
	}

	public String getMemID() {
		return memID;
	}

	public void setMemID(String memID) {
		this.memID = memID;
	}

	public Date getMemReg() {
		return memReg;
	}

	public void setMemReg(Date memReg) {
		this.memReg = memReg;
	}

	public Integer getMemStatus() {
		return memStatus;
	}

	public void setMemStatus(Integer memStatus) {
		this.memStatus = memStatus;
	}

	public Date getlastLoginTime() {
		return lastLoginTime;
	}

	public void setlastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public byte[] getMemPic() {
		return memPic;
	}

	public void setMemPic(byte[] memPic) {
		this.memPic = memPic;
	}

}
