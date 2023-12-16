package com.rtn.controller.model;

import java.sql.Date;

public class RtnVo {
	private Integer rtnNo;
	private Integer empNo;
	private Integer orderNo;
	private Date rtnDate;
	private String rtnWhy;
	private Integer refundAmount;
	private Integer rtnStatus;

	public Integer getRtnNo() {
		return rtnNo;
	}

	public void setRtnNo(Integer rtnNo) {
		this.rtnNo = rtnNo;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public Integer getorderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Date getRtnDate() {
		return rtnDate;
	}

	public void setRtnDate(Date rtnDate) {
		this.rtnDate = rtnDate;
	}

	public String getRtnWhy() {
		return rtnWhy;
	}

	public void setRtnWhy(String rtnWhy) {
		this.rtnWhy = rtnWhy;
	}

	public Integer getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(Integer refundAmount) {
		this.refundAmount = refundAmount;
	}

	public Integer getRtnStatus() {
		return rtnStatus;
	}

	public void setRtnStatus(Integer rtnStatus) {
		this.rtnStatus = rtnStatus;
	}
}
