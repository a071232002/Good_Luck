package com.emp.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="emp")
public class Emp implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="empNo", updatable = false)
	private Integer empNo;
	
	@Column(name="empName")
	@NotBlank(message = "姓名不能空白！")
	@Pattern(regexp = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$", message = "員工姓名: 只能是中、英文字母、數字和_")
	private String empName;
	
	@Column(name="empPsw", columnDefinition = "CHAR(45)")
	private String empPsw;
	
	@Column(name="empHireDate")
	private Date empHireDate;
	
	@Column(name="empStatus")
	private Byte empStatus;
	
	@Column(name="empSex")
	@NotNull(message= "請輸入性別！")
	private Byte empSex;
	

//	@OneToMany(mappedBy = "emp")
	@Transient
	private List<Integer> empFun;
	
//	@OneToMany(mappedBy = "emp")
//	private Set<EmpFun> empFun1;
	
//	@OneToMany(mappedBy = "notice")
//	private Set<Notice> notice;
	
//	@OneToMany(mappedBy = "rentApp")
//	private Set<RentApp> rentApp;
	
//	@OneToMany(mappedBy = "lddApp")
//	private Set<LddApp> lddApp;
	
//	@OneToMany(mappedBy = "report")
//	private Set<Report> report;
	
//	@OneToMany(mappedBy = "rtn")
//	private Set<Rtn> rtn;
	
//	@OneToMany(mappedBy = "pro")
//	private Set<Pro> pro;
	
	public Emp() {
		super();
	}
	
	
	
	public Emp(String empName, String empPsw, Date empHireDate, Byte empStatus, Byte empSex) {
		super();
		setEmpName(empName);
		setEmpPsw(empPsw);
		setEmpHireDate(empHireDate);
		setEmpStatus(empStatus);
		setEmpSex(empSex);
	}



	public Integer getEmpNo() {
		return empNo;
	}
	
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getEmpPsw() {
		return empPsw;
	}
	
	public void setEmpPsw(String empPsw) {
		this.empPsw = empPsw;
	}
	
	public Date getEmpHireDate() {
		return empHireDate;
	}
	
	public void setEmpHireDate(Date empHireDate) {
		this.empHireDate = empHireDate;
	}
	
	public Byte getEmpStatus() {
		return empStatus;
	}
	
	public void setEmpStatus(Byte empStatus) {
		this.empStatus = empStatus;
	}
	
	public Byte getEmpSex() {
		return empSex;
	}
	
	public void setEmpSex(Byte empSex) {
		this.empSex = empSex;
	}
	
	
//	public Set<EmpFun> getEmpFun1() {
//		return empFun1;
//	}
//
//	public void setEmpFun1(Set<EmpFun> empFun1) {
//		this.empFun1 = empFun1;
//	}



	public List<Integer> getEmpFun() {
		return empFun;
	}

	public void setEmpFun(List<Integer> empFun) {
		this.empFun = empFun;
	}



	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", empName=" + empName + ", empPsw=" + empPsw + ", empHireDate=" + empHireDate
				+ ", empStatus=" + empStatus + ", empSex=" + empSex + ", empFun=" + empFun + "]";
	}


//	@Override
//	public String toString() {
//		return "Emp [empNo=" + empNo + ", empName=" + empName + ", empPsw=" + empPsw + ", empHireDate=" + empHireDate
//				+ ", empStatus=" + empStatus + ", empSal=" + empSal + ", empFun=" + empFun + "]";
//	}
//
//
//	public Set<EmpFun> getEmpFun() {
//		return empFun;
//	}
//
//	public void setEmpFun(Set<EmpFun> empFun) {
//		this.empFun = empFun;
//	}







//	@Override
//	public String toString() {
//		return "Emp [empNo=" + empNo + ", empName=" + empName + ", empPsw=" + empPsw + ", empHireDate=" + empHireDate
//				+ ", empStatus=" + empStatus + ", empSal=" + empSal + "]";
//	}
	
	

}
