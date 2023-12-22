package com.Rtn.mdoel;

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
@Table(name = "rtnvo")
public class RtnVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rtnvo", updatable = false)
	private Integer rtnNo;
	
	@Column(name = "empNo")
	private Integer empNo;
	
	@Column(name = "orderNo")
	private Integer orderNo;
	
	@Column(name = "rtnDate")
	private String rtnDate;
	
	@Column(name = "rtnWhy")
	private String rtnWhy;
	
	@Column(name = "refundAmount")
	private Integer refundAmount;
	
	@Column(name = "rtnStatus")
	private Integer rtnStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)//	多對一，延遲載入

	@JoinColumn(name = "rtnvo", referencedColumnName = "ordno")
//	FK訂單
	@JoinColumn(name = "rtnvo", referencedColumnName = "empNo")
//	FK員工
	
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
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public String getRtnDate() {
		return rtnDate;
	}
	public void setRtnDate(String rtnDate) {
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
