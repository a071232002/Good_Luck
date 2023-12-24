package com.report.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.rentapp.model.Emp;

public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reportNo", updatable = false)
	private Integer reportNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "memNo", referencedColumnName = "memNo")
	private Mem mem;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empNo", referencedColumnName = "empNo")
	private Emp emp;
	
	private Timestamp reportDate;
	private String reportCon;
	private byte rentAppSt;

}
