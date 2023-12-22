package com.apo.model;

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

public class Apo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "apoNo", updatable = false)
	private Integer apoNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memNo", referencedColumnName = "memNo")
	private Mem memNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rentNo", referencedColumnName = "rentNo")
	private Rent rentNo;
	
	@Column(name = "apoCreate")
	private Date apoCreate;
	
	@Column(name = "apoDate")
	private Date apoDate;
	
	@Column(name = "apoTime")
	private Byte apoTime;
	
	@Column(name = "apoStatus")
	private Byte apoStatus;
	
	@Column(name = "apoWant")
	private Byte apoWant;
	
	@Column(name = "apoWantDate")
	private Date apoWantDate;

	public Apo() {
		super();
	}

	public Integer getApoNo() {
		return apoNo;
	}

	public void setApoNo(Integer apoNo) {
		this.apoNo = apoNo;
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

	public Date getApoCreate() {
		return apoCreate;
	}

	public void setApoCreate(Date apoCreate) {
		this.apoCreate = apoCreate;
	}

	public Date getApoDate() {
		return apoDate;
	}

	public void setApoDate(Date apoDate) {
		this.apoDate = apoDate;
	}

	public Byte getApoTime() {
		return apoTime;
	}

	public void setApoTime(Byte apoTime) {
		this.apoTime = apoTime;
	}

	public Byte getApoStatus() {
		return apoStatus;
	}

	public void setApoStatus(Byte apoStatus) {
		this.apoStatus = apoStatus;
	}

	public Byte getApoWant() {
		return apoWant;
	}

	public void setApoWant(Byte apoWant) {
		this.apoWant = apoWant;
	}

	public Date getApoWantDate() {
		return apoWantDate;
	}

	public void setApoWantDate(Date apoWantDate) {
		this.apoWantDate = apoWantDate;
	}
	
	@Override
	public String toString() {
		return "apo [apoNo=" + apoNo + 
				", memNo=" + null +
				", rentNo=" + null +
				", apoCreate=" + apoCreate + 
				", apoDate=" + apoDate + 
				", apoTime=" + apoTime + 
				", apoStatus=" + apoStatus + 
				", apoWant=" + apoWant +
				", apoWantDate=" + apoWantDate +
				"]";
	}
}
