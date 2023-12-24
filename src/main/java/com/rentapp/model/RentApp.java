package com.rentapp.model;

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
@Table(name = "rentapp")
public class RentApp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rentAppNo", updatable = false)
	private Integer rentAppNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lddNo", referencedColumnName = "lddNo")
	private Ldd ldd;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empNo", referencedColumnName = "empNo")
	private Emp emp;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rentNo", referencedColumnName = "rentNo")
	private Rent rent;
	
	private String rentAppCou;
	private String rentAppAr;
	private String rentAppRo;
	private String rentAppAdd;
	private byte[] rentAppOwn;
	private Integer rentAppFloor;
	private Double rentAppSize;
	private byte rentAppSt;
	
	public Integer getRentAppNo() {
		return rentAppNo;
	}
	public void setRentAppNo(Integer rentAppNo) {
		this.rentAppNo = rentAppNo;
	}
	public Ldd getLdd() {
		return ldd;
	}
	public void setLdd(Ldd ldd) {
		this.ldd = ldd;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public Rent getRent() {
		return rent;
	}
	public void setRent(Rent rent) {
		this.rent = rent;
	}
	public String getRentAppCou() {
		return rentAppCou;
	}
	public void setRentAppCou(String rentAppCou) {
		this.rentAppCou = rentAppCou;
	}
	public String getRentAppAr() {
		return rentAppAr;
	}
	public void setRentAppAr(String rentAppAr) {
		this.rentAppAr = rentAppAr;
	}
	public String getRentAppRo() {
		return rentAppRo;
	}
	public void setRentAppRo(String rentAppRo) {
		this.rentAppRo = rentAppRo;
	}
	public String getRentAppAdd() {
		return rentAppAdd;
	}
	public void setRentAppAdd(String rentAppAdd) {
		this.rentAppAdd = rentAppAdd;
	}
	public byte[] getRentAppOwn() {
		return rentAppOwn;
	}
	public void setRentAppOwn(byte[] rentAppOwn) {
		this.rentAppOwn = rentAppOwn;
	}
	public Integer getRentAppFloor() {
		return rentAppFloor;
	}
	public void setRentAppFloor(Integer rentAppFloor) {
		this.rentAppFloor = rentAppFloor;
	}
	public Double getRentAppSize() {
		return rentAppSize;
	}
	public void setRentAppSize(Double rentAppSize) {
		this.rentAppSize = rentAppSize;
	}
	public byte getRentAppSt() {
		return rentAppSt;
	}
	public void setRentAppSt(byte rentAppSt) {
		this.rentAppSt = rentAppSt;
	}
	@Override
	public String toString() {
		return "RentApp [rentAppNo=" + rentAppNo + ", rentAppCou=" + rentAppCou + ", rentAppAr=" + rentAppAr
				+ ", rentAppRo=" + rentAppRo + ", rentAppAdd=" + rentAppAdd + ", rentAppFloor=" + rentAppFloor
				+ ", rentAppSize=" + rentAppSize + ", rentAppSt=" + rentAppSt + "]";
	}
	
}
