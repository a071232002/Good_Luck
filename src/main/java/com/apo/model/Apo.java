package com.apo.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.mem.model.Mem;
import com.rent.model.Rent;

@Entity
@Table(name = "apo")
public class Apo implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "apoNo", updatable = false)
	private Integer apoNo;
	
	@ManyToOne
	@JoinColumn(name = "memNo", referencedColumnName = "memNo", updatable = false)
	private Mem mem;
	
	@ManyToOne
	@JoinColumn(name = "rentNo", referencedColumnName = "rentNo", updatable = false)
	private Rent rent;
	
	@Column(name = "apoCreate", updatable = false)
	private Date apoCreate;
	
	@Column(name = "apoDate")
	private Date apoDate;
	
	@Column(name = "apoTime")
	private Byte apoTime;
	
	@Column(name = "apoStatus", insertable = false)
	private Byte apoStatus;
	
	@Column(name = "apoWant", insertable = false)
	private Byte apoWant;
	
	@Column(name = "apoWantDate", insertable = false)
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
				", memNo=" + (mem == null? null :mem.getMemNo()) +
				", rentNo=" + (rent == null? null :rent.getRentNo()) +
				", apoCreate=" + apoCreate + 
				", apoDate=" + apoDate + 
				", apoTime=" + apoTime + 
				", apoStatus=" + apoStatus + 
				", apoWant=" + apoWant +
				", apoWantDate=" + apoWantDate +
				"]";
	}
}
