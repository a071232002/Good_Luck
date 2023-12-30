package com.fix.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mem.model.Mem;
import com.rent.model.Rent;

public class Fix {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fixNo", updatable = false)
	private Integer fixNo;
	
	@ManyToOne
	@JoinColumn(name = "memNo", referencedColumnName = "memNo")
	private Mem memNo;
	
	@ManyToOne
	@JoinColumn(name = "rentNo", referencedColumnName = "rentNo")
	private Rent rentNo;
	
	@Column(name = "fixCreate")
	private Timestamp fixCreate;
	
	@Column(name = "fixContent")
	private String fixContent;
	
	@Column(name = "fixReply")
	private String fixReply;
	
	@Column(name = "fixStatus")
	private Byte fixStatus;

	public Fix() {
		super();
	}

	public Integer getFixNo() {
		return fixNo;
	}

	public void setFixNo(Integer fixNo) {
		this.fixNo = fixNo;
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

	public Timestamp getFixCreate() {
		return fixCreate;
	}

	public void setFixCreate(Timestamp fixCreate) {
		this.fixCreate = fixCreate;
	}

	public String getFixContent() {
		return fixContent;
	}

	public void setFixContent(String fixContent) {
		this.fixContent = fixContent;
	}

	public String getFixReply() {
		return fixReply;
	}

	public void setFixReply(String fixReply) {
		this.fixReply = fixReply;
	}

	public Byte getFixStatus() {
		return fixStatus;
	}

	public void setFixStatus(Byte fixStatus) {
		this.fixStatus = fixStatus;
	}
	
	@Override
	public String toString() {
		return "fix [fixNo=" + fixNo + 
				", memNo=" + null +
				", rentNo=" + null +
				", fixCreate=" + fixCreate + 
				", fixContent=" + fixContent + 
				", fixRepky=" + fixReply + 
				", fixStatus=" + fixStatus + 
				"]";
	}
}
