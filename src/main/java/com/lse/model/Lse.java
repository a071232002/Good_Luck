package com.lse.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mem.model.Mem;
import com.rent.model.Rent;


@Entity
@Table(name = "lse")
public class Lse implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lseNo", updatable = false)
	private Integer lseNo;
	
	@ManyToOne
	@JoinColumn(name = "memNo", referencedColumnName = "memNo", updatable = false)
	private Mem mem;
	
	@ManyToOne
	@JoinColumn(name = "rentNo", referencedColumnName = "rentNo", updatable = false)
	private Rent rent;
	
	@Column(name = "lseCreate", updatable = false)
	private Date lseCreate;
	
	@Column(name = "lseStart")
	private Date lseStart;
	
	@Column(name = "lseEnd")
	private Date lseEnd;
	
	@Column(name = "lseSend", columnDefinition = "longblob")
	private byte[] lseSend;
	
	@Column(name = "lseSign", columnDefinition = "longblob", insertable = false)
	private byte[] lseSign;
	
	@Column(name = "lsePay")
	private Integer lsePay;
	
	@Column(name = "lsePayAccount")
	private String lsePayAccount;
	
	@Column(name = "lsePayStatus", insertable = false)
	private Byte lsePayStatus;
	
	@Column(name = "lseStatus", insertable = false)
	private Byte lseStatus;
	
	@Column(name = "lseRenew", insertable = false)
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

	public Mem getMem() {
		return mem;
	}

	public void setMem(Mem mem) {
		this.mem = mem;
	}

	public Rent getRent() {
		return rent;
	}

	public void setRent(Rent rent) {
		this.rent = rent;
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
				", memNo=" + (mem == null? null :mem.getMemNo())+
				", rentNo=" + (rent == null? null :rent.getRentNo()) +
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
