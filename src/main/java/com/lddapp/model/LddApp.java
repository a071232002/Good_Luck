package com.lddapp.model;

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
import com.emp.model.Emp;

@Entity
@Table(name = "lddapp")
public class LddApp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lddAppNo", updatable = false)
	private Integer lddAppNo;
	
	@ManyToOne
	@JoinColumn(name = "memNo", referencedColumnName = "memNo")
	private Mem mem;
	
	@ManyToOne
	@JoinColumn(name = "empNo", referencedColumnName = "empNo", insertable = false)
	private Emp emp;
	
	@Column(name = "lddAppCreate", updatable = false)
	private Date lddAppCreate;
	
	@Column(name = "lddAppIDPic", columnDefinition = "longblob")
	private byte[] lddAppIDPic;
	
	@Column(name = "lddAppPayStatus", insertable = false)
	private Byte lddAppPayStatus;
	
	@Column(name = "lddAppStatus", insertable = false)
	private Byte lddAppStatus;

	
	public Integer getLddAppNo() {
		return lddAppNo;
	}

	public void setLddAppNo(Integer lddAppNo) {
		this.lddAppNo = lddAppNo;
	}

	public Mem getMem() {
		return mem;
	}

	public void setMem(Mem mem) {
		this.mem = mem;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
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
