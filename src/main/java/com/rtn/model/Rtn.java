package com.Rtn.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Rtn")
public class Rtn {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rtnNo", updatable = false)
	private Integer rtnNo;

	@Column(name = "rtnDate")
	private Timestamp rtnDate;

	@Column(name = "rtnWhy")
	private String rtnWhy;

	@Column(name = "refundAmount")
	private int refundAmount;

	@Column(name = "rtnStatus")
	private int rtnStatus;
	// FK員工
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empNo", referencedColumnName = "empNo")
	private Emp empNo;
	// FK訂單
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderNo", referencedColumnName = "ordNo")
	private Order orderNo;

	public Integer getRtnNo() {
		return rtnNo;
	}

	public void setRtnNo(Integer rtnNo) {
		this.rtnNo = rtnNo;
	}

	public Timestamp getRtnDate() {
		return rtnDate;
	}

	public void setRtnDate(Timestamp rtnDate) {
		this.rtnDate = rtnDate;
	}

	public String getRtnWhy() {
		return rtnWhy;
	}

	public void setRtnWhy(String rtnWhy) {
		this.rtnWhy = rtnWhy;
	}

	public int getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(int refundAmount) {
		this.refundAmount = refundAmount;
	}

	public int getRtnStatus() {
		return rtnStatus;
	}

	public void setRtnStatus(int rtnStatus) {
		this.rtnStatus = rtnStatus;
	}

	public Emp getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Emp empNo) {
		this.empNo = empNo;
	}

	public Order getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Order orderNo) {
		this.orderNo = orderNo;
	}

}
