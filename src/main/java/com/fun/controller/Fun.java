package com.fun.controller;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.empfun.controller.EmpFun;

@Entity
@Table(name="fun")
public class Fun implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="funNo", updatable = false, insertable = false)
	private Integer funNo;
	
	@Column(name="funName")
	private String funName;
	
	@OneToMany(mappedBy = "fun", cascade = CascadeType.ALL)
	private Set<EmpFun> empFun;
	
	public Fun() {
		super();
	}
	
	public Fun(Integer funNo) {
		super();
		setFunNo(funNo);
	}
	
	public Integer getFunNo() {
		return funNo;
	}
	
	public void setFunNo(Integer funNo) {
		this.funNo = funNo;
	}
	
	public String getFunName() {
		return funName;
	}
	
	public void setFunName(String funName) {
		this.funName =funName;
	}

	public Set<EmpFun> getEmpFun() {
		return empFun;
	}

	public void setEmpFun(Set<EmpFun> empFun) {
		this.empFun = empFun;
	}
	
	
}

