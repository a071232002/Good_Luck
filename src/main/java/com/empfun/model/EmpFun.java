package com.empfun.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.emp.model.Emp;
import com.fun.model.Fun;

@Entity
@Table(name="empfun")
public class EmpFun implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empfunNo")
	private Integer EmpfunNo;
	
	@ManyToOne
	@JoinColumn(name = "funNo", referencedColumnName = "funNo")
	private Fun fun;
	
	@ManyToOne
	@JoinColumn(name = "empNo", referencedColumnName = "empNo")
	private Emp emp;
	
	
	public EmpFun() {
		super();
	}

	

	public Integer getEmpfunNo() {
		return EmpfunNo;
	}

	public void setEmpfunNo(Integer empfunNo) {
		EmpfunNo = empfunNo;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Fun getFun() {
		return fun;
	}

	public void setFun(Fun fun) {
		this.fun = fun;
	}


	@Override
	public String toString() {
		return "EmpFun [EmpFunNo=" + EmpfunNo + ", emp=" + emp + ", fun=" + fun + "]";
	}


	

	
	
	
}

