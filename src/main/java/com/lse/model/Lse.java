package com.lse.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mem.model.Mem;
import com.rent.model.Rent;

public class Lse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lseNo", updatable = false)
	private Integer lseNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memNo", referencedColumnName = "memNo")
	private Mem memNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rentNo", referencedColumnName = "rentNo")
	private Rent rentNo;
	
	@Column(name = "lseCreate")
	private Date lseCreate;
	
	@Column(name = "lseStart")
	private Date lseStart;
	
	@Column(name = "lseEnd")
	private Date lseEnd;
	
	@Column(name = "lseSend", columnDefinition = "longblob")
	private byte[] lseSend;
	
	@Column(name = "lseSign", columnDefinition = "longblob")
	private byte[] lseSign;
	
	@Column(name = "lsePay")
	private Integer lsePay;
	
	@Column(name = "lsePayAccount")
	private String lsePayAccount;
	
	@Column(name = "lsePayStatus")
	private Byte lsePayStatus;
	
	@Column(name = "lseStatus")
	private Byte lseStatus;
	
	@Column(name = "lseRenew")
	private Byte lseRenew;
	
	public Lse() {
		super();
	}

	public Integer getLseNo() {
		return lseNo;
	}

	public void setLseNo(Integer lseNo) {
		this.lseNo = lseNo;
	}

	public Mem getMemNo() {
		return memNo;
	}

	public void setMemNo(Mem memNo) {
		this.memNo = memNo;
	}

	public Rent getRentNo() {
		return rentNo;
	}

	public void setRentNo(Rent rentNo) {
		this.rentNo = rentNo;
	}

	public Date getLseCreate() {
		return lseCreate;
	}

	public void setLseCreate(Date lseCreate) {
		this.lseCreate = lseCreate;
	}

	public Date getLseStart() {
		return lseStart;
	}

	public void setLseStart(Date lseStart) {
		this.lseStart = lseStart;
	}

	public Date getLseEnd() {
		return lseEnd;
	}

	public void setLseEnd(Date lseEnd) {
		this.lseEnd = lseEnd;
	}

	public byte[] getLseSend() {
		return lseSend;
	}

	public void setLseSend(byte[] lseSend) {
		this.lseSend = lseSend;
	}

	public byte[] getLseSign() {
		return lseSign;
	}

	public void setLseSign(byte[] lseSign) {
		this.lseSign = lseSign;
	}

	public Integer getLsePay() {
		return lsePay;
	}

	public void setLsePay(Integer lsePay) {
		this.lsePay = lsePay;
	}

	public String getLsePayAccount() {
		return lsePayAccount;
	}

	public void setLsePayAccount(String lsePayAccount) {
		this.lsePayAccount = lsePayAccount;
	}

	public Byte getLsePayStatus() {
		return lsePayStatus;
	}

	public void setLsePayStatus(Byte lsePayStatus) {
		this.lsePayStatus = lsePayStatus;
	}

	public Byte getLseStatus() {
		return lseStatus;
	}

	public void setLseStatus(Byte lseStatus) {
		this.lseStatus = lseStatus;
	}

	public Byte getLseRenew() {
		return lseRenew;
	}

	public void setLseRenew(Byte lseRenew) {
		this.lseRenew = lseRenew;
	}
	
	@Override
	public String toString() {
		return "lse [lseNo=" + lseNo + 
				", memNo=" + null +
				", rentNo=" + null +
				", lseCreate=" + lseCreate + 
				", lseStart=" + lseStart + 
				", lseEnd=" + lseEnd + 
				", lseSend=" + lseSend + 
				", lseSign=" + lseSign +
				", lsePay=" + lsePay +
				", lsePayAccount=" + lsePayAccount +
				", lsePayStatus=" + lsePayStatus +
				", lseStatus=" + lseStatus +
				", lseRenew=" + lseRenew +
				"]";
	}
}
