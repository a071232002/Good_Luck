package com.cha104g2.goodluck.member;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

public class Mem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer memNo;
	private String memMail;
	private String memPsw;
	private String memName;
	private Byte memSex;
	private String memPhone;
	private String memAdd;
	private String memID;
	private Date memReg;
	private Byte memStatus;
	private Timestamp lastLoginTime;
	private byte[] memPic;
	
	public Mem() {
		super();
	}
	
	
	
	public Mem(String memMail, String memPsw, String memName, Byte memSex, String memPhone,
			String memAdd, String memID, Date memReg, Byte memStatus, Timestamp lastLoginTime, byte[] memPic) {
		super();
		setMemMail(memMail);
		setMemPsw(memPsw);
		setMemName(memName);
		setMemSex(memSex);
		setMemPhone(memPhone);
		setMemAdd(memAdd);
		setMemID(memID);
		setMemReg(memReg);
		setMemStatus(memStatus);
		setLastLoginTime(lastLoginTime);
		setMemPic(memPic);
	}



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
	public Byte getMemSex() {
		return memSex;
	}
	public void setMemSex(Byte memSex) {
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
	public Byte getMemStatus() {
		return memStatus;
	}
	public void setMemStatus(Byte memStatus) {
		this.memStatus = memStatus;
	}
	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}
	
	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public byte[] getMemPic() {
		return memPic;
	}
	
	public void setMemPic(byte[] memPic) {
		this.memPic = memPic;
	}
	

	@Override
	public String toString() {
		return "Mem [memNo=" + memNo + "\n, memMail=" + memMail + "\n, memPsw=" + memPsw + "\n, memName=" + memName
				+ "\n, memSex=" + memSex + "\n, memPhone=" + memPhone + "\n, memAdd=" + memAdd + "\n, memID=" + memID
				+ "\n, memReg=" + memReg.toLocalDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")) + "\n, memStatus=" + memStatus 
				+ "\n, lastLoginTime=" + lastLoginTime.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + "]";
	}
	
	
}
