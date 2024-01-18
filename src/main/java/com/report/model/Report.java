package com.report.model;

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
import javax.validation.constraints.NotEmpty;

import com.mem.model.Mem;
import com.emp.model.Emp;

@Entity
@Table(name = "report")
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reportNo", updatable = false)
	private Integer reportNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memNo", referencedColumnName = "memNo", updatable = false)
	private Mem mem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empNo", referencedColumnName = "empNo", insertable = false)
	private Emp emp;
	
	@Column(updatable = false)
	private Date reportDate;
	
	@NotEmpty(message="投訴內容: 請勿空白")
	private String reportCon;
	
	@Column(insertable = false)
	private byte reportSt;

	public Integer getReportNo() {
		return reportNo;
	}

	public void setReportNo(Integer reportNo) {
		this.reportNo = reportNo;
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

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportCon() {
		return reportCon;
	}

	public void setReportCon(String reportCon) {
		this.reportCon = reportCon;
	}

	public byte getReportSt() {
		return reportSt;
	}

	public void setReportSt(byte reportSt) {
		this.reportSt = reportSt;
	}

	@Override
	public String toString() {
		return "Report [reportNo=" + reportNo + ", mem=" + mem + ", emp=" + emp + ", reportDate=" + reportDate
				+ ", reportCon=" + reportCon + ", reportSt=" + reportSt + "]";
	}



}
