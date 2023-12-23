package com.mem.controller;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "mem")
public class Mem implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="memNo", updatable = false)
	private Integer memNo;
	
	@Column(name="memMail")
	private String memMail;
	
	@Column(name="memPsw")
	private String memPsw;
	
	@Column(name="memName")
	private String memName;
	
	@Column(name="memSex")
	private Byte memSex;
	
	@Column(name="memPhone", columnDefinition = "CHAR(10)")
	private String memPhone;
	
	@Column(name="memAdd")
	private String memAdd;
	
	@Column(name="memID", columnDefinition = "CHAR(10)")
	private String memID;
	
	@Column(name="memReg")
	private Date memReg;
	
	@Column(name="memStatus")
	private Byte memStatus;
	
	@Column(name="lastLoginTime")
	private Timestamp lastLoginTime;
	
	@Column(name="memPic")
	@Transient
	private byte[] memPic;
	
//	@OneToMany(mappedBy = "fix", cascade = CascadeType.ALL)
//	private Set<Fix> fix;
	
//	@OneToMany(mappedBy = "ldd", cascade = CascadeType.ALL)
//	private Set<Ldd> ldd;
	
//	@OneToMany(mappedBy = "lddApp", cascade = CascadeType.ALL)
//	private Set<LddApp> lddApp;
	
//	@OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
//	private Set<Report> report;
	
//	@OneToMany(mappedBy = "ord", cascade = CascadeType.ALL)
//	private Set<Ord> ord;
	
//	@OneToMany(mappedBy = "myPro", cascade = CascadeType.ALL)
//	private Set<MyPro> myPro;
	
//	@OneToMany(mappedBy = "myRent", cascade = CascadeType.ALL)
//	private Set<MyRent> myRent;
	
//	@OneToMany(mappedBy = "apo", cascade = CascadeType.ALL)
//	private Set<Apo> apo;
	
//	@OneToMany(mappedBy = "lse", cascade = CascadeType.ALL)
//	private Set<Lse> lse;
	
	public Mem() {
		super();
	}
	
	public Mem(String memMail, String memPsw, String memName, Byte memSex, String memPhone,
			String memAdd, String memID, Date memReg, Byte memStatus, Timestamp lastLoginTime, byte[] memPic) {
		super();
		this.memMail = memMail;
		this.memPsw = memPsw;
		this.memName = memName;
		this.memSex = memSex;
		this.memPhone = memPhone;
		this.memAdd = memAdd;
		this.memID = memID;
		this.memReg = memReg;
		this.memStatus = memStatus;
		this.lastLoginTime = lastLoginTime;
		this.memPic = memPic;
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
		return "Mem [memNo=" + memNo + ", memMail=" + memMail + ", memPsw=" + memPsw + ", memName=" + memName
				+ ", memSex=" + memSex + ", memPhone=" + memPhone + ", memAdd=" + memAdd + ", memID=" + memID
				+ ", memReg=" + memReg + ", memStatus=" + memStatus + ", lastLoginTime=" + lastLoginTime.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + "]";
	}
	
	
	
}

