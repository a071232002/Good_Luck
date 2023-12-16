package com.cha104g2.goodluck.emp;

public class empVO {
	package testemp;
	import java.sql.Date;

	public class Emp implements java.io.Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Integer empNo;
		private String empName;
		private String empPsw;
		private Date empHireDate;
		private Double empStatus;
		private Double empSal;
		
	    public Emp(Integer empNo, String empName, String empPsw, Date empHireDate, Double empSal, Double empStatus) {
	    	super();
	    	this.empNo = empNo;
	        this.empName = empName;
	        this.empPsw = empPsw;
	        this.empHireDate = empHireDate;
	        this.empSal = empSal;
	        this.empStatus = empStatus;
	    }
		
		
		public Emp() {
			super();                             //27-29 無參數建構子  
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
		public Double getEmpSal() {
			return empSal;
		}
		public void setEmpSal(Double empSal) {
			this.empSal = empSal;
		}
		public Double getEmpStatus() {
			return empStatus;
		}
		public void setEmpStatus(Double empStatus ) {
			this.empStatus = empStatus;
		}
		
	}

}
