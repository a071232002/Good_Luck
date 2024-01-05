package com.ldd.model;

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

@Entity
@Table(name = "ldd")
public class Ldd {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lddNo", updatable = false)
	private Integer lddNo;
	
	@ManyToOne
	@JoinColumn(name = "memNo", referencedColumnName = "memNo", updatable = false)
	private Mem memNo;
	
	@Column(name = "lddStatus", insertable = false)
	private Byte lddStatus;

	public Ldd() {
		super();
	}

	public Integer getLddNo() {
		return lddNo;
	}

	public void setLddNo(Integer lddNo) {
		this.lddNo = lddNo;
	}

	public Mem getMemNo() {
		return memNo;
	}

	public void setMemNo(Mem memNo) {
		this.memNo = memNo;
	}

	public Byte getLddStatus() {
		return lddStatus;
	}

	public void setLddStatus(Byte lddStatus) {
		this.lddStatus = lddStatus;
	}
	
	@Override
	public String toString() {
		return "ldd [lddNo=" + lddNo + 
				", memNo=" + null + 
				", lddStatus=" + lddStatus + 
				"]";
	}
}
