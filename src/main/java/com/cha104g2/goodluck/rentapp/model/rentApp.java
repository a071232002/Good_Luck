package com.cha104g2.goodluck.rentapp.model;

import java.util.Arrays;

public class rentApp {

	private Integer rentAppNo;
	private Integer lddNo;
	private Integer empNo;
	private Integer rentNo;
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
	public Integer getLddNo() {
		return lddNo;
	}
	public void setLddNo(Integer lddNo) {
		this.lddNo = lddNo;
	}
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public Integer getRentNo() {
		return rentNo;
	}
	public void setRentNo(Integer rentNo) {
		this.rentNo = rentNo;
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
	public rentApp(Integer lddNo, Integer empNo, Integer rentNo, String rentAppCou, String rentAppAr, String rentAppRo,
			String rentAppAdd, byte[] rentAppOwn, Integer rentAppFloor, Double rentAppSize, byte rentAppSt) {
		super();
		this.lddNo = lddNo;
		this.empNo = empNo;
		this.rentNo = rentNo;
		this.rentAppCou = rentAppCou;
		this.rentAppAr = rentAppAr;
		this.rentAppRo = rentAppRo;
		this.rentAppAdd = rentAppAdd;
		this.rentAppOwn = rentAppOwn;
		this.rentAppFloor = rentAppFloor;
		this.rentAppSize = rentAppSize;
		this.rentAppSt = rentAppSt;
	}
	public rentApp() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "rentApp [rentAppNo=" + rentAppNo + ", lddNo=" + lddNo + ", empNo=" + empNo + ", rentNo=" + rentNo
				+ ", rentAppCou=" + rentAppCou + ", rentAppAr=" + rentAppAr + ", rentAppRo=" + rentAppRo
				+ ", rentAppAdd=" + rentAppAdd + ", rentAppFloor=" + rentAppFloor + ", rentAppSize=" + rentAppSize
				+ ", rentAppSt=" + rentAppSt + "]";
	}
	
	


	
	
}
