package com.lddapp.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mem.model.Mem;
import com.emp.model.Emp;


public class LddApp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lddAppNo", updatable = false)
	private Integer lddAppNo;
	
	@ManyToOne
	@JoinColumn(name = "memNo", referencedColumnName = "memNo")
	private Mem memNo;
	
	@ManyToOne
	@JoinColumn(name = "empNo", referencedColumnName = "empNo")
	private Emp empNo;
	
	@Column(name = "lddAppCreate")
	private Date lddAppCreate;
	
	@Column(name = "lddAppIDPic", columnDefinition = "longblob")
	private byte[] lddAppIDPic;
	
	@Column(name = "lddAppPayStatus")
	private Byte lddAppPayStatus;
	
	@Column(name = "lddAppStatus")
	private Byte lddAppStatus;

	
	public Integer getLddAppNo() {
		return lddAppNo;
	}

	public void setLddAppNo(Integer lddAppNo) {
		this.lddAppNo = lddAppNo;
	}

	public Mem getMemNo() {
		return memNo;
	}

	public void setMemNo(Mem memNo) {
		this.memNo = memNo;
	}

	public Emp getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Emp empNo) {
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

	public Byte getLddAppPayStatus() {
		return lddAppPayStatus;
	}

	public void setLddAppPayStatus(Byte lddAppPayStatus) {
		this.lddAppPayStatus = lddAppPayStatus;
	}

	public Byte getLddAppStatus() {
		return lddAppStatus;
	}

	public void setLddAppStatus(Byte lddAppStatus) {
		this.lddAppStatus = lddAppStatus;
	}
	
	@Override
	public String toString() {
		return "lddApp [lddAppNo=" + lddAppNo + 
				", memNo=" + null +
				", empNo=" + null +
				", lddAppCreate=" + lddAppCreate + 
				", lddAppIDPic=" + lddAppIDPic + 
				", lddAppPayStatus=" + lddAppPayStatus+ 
				", lddAppStatus=" + lddAppStatus + 
				"]";
	}
}
