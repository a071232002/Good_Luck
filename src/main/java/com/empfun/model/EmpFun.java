package com.empfun.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.emp.model.Emp;
import com.empfun.model.EmpFun.Composite;
import com.fun.model.Fun;

@Entity
@Table(name="empfun")
public class EmpFun implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private Composite compositeKey;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empNo", referencedColumnName = "empNo", insertable = false, updatable = false)
	private Emp emp;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "funNo", referencedColumnName = "funNo", insertable = false, updatable = false)
	private Fun fun;
	
	public EmpFun() {
		super();
	}
	
	public EmpFun(Integer empNo, Integer funNo) {
		compositeKey = new Composite(empNo, funNo);
	}
	
	
	public Composite getCompositeKey() {
		return compositeKey;
	}

	public void setCompositeKey(Composite compositeKey) {
		this.compositeKey = compositeKey;
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




	@Embeddable
	public static class Composite implements Serializable{
		private static final long serialVersionUID = 1L;
		
		private Integer empNo;
		private Integer funNo;
		
		public Composite() {
			super();
		}
		
		public Composite(Integer empNo, Integer funNo) {
			super();
			setEmpNo(empNo);
			setFunNo(funNo);
		}
		
		
		public Integer getEmpNo() {
			return empNo;
		}
		public void setEmpNo(Integer empNo) {
			this.empNo = empNo;
		}
		public Integer getFunNo() {
			return funNo;
		}
		public void setFunNo(Integer funNo) {
			this.funNo = funNo;
		}
		
		

		@Override
		public String toString() {
			return "Composite [empNo=" + empNo + ", funNo=" + funNo + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(empNo, funNo);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Composite other = (Composite) obj;
			return Objects.equals(empNo, other.empNo) && Objects.equals(funNo, other.funNo);
		}
	}




	@Override
	public String toString() {
		return "EmpFun [compositeKey=" + compositeKey + ", emp=" + emp.getEmpName() + ", fun=" + fun.getFunName() + "]";
	}
	
	
	
}


