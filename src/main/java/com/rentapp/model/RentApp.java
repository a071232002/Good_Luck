package com.rentapp.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.ldd.model.Ldd;
import com.rent.model.Rent;
import com.emp.model.Emp;

@Entity
@Table(name = "rentapp")
public class RentApp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rentAppNo", updatable = false)
	private Integer rentAppNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lddNo", referencedColumnName = "lddNo", updatable = false)
	private Ldd ldd;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empNo", referencedColumnName = "empNo", insertable = false)
	private Emp emp;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rentNo", referencedColumnName = "rentNo")
	private Rent rent;
	@NotEmpty(message="縣市名: 請勿空白")
	private String rentAppCou;
	@NotEmpty(message="鄉鎮市區名: 請勿空白")
	private String rentAppAr;
	@NotEmpty(message="路街名: 請勿空白")
	@Pattern(regexp = "^[(\u4e00-\u9fa5)]{2,15}$", message = "路街名: 只能是中文字, 且長度必需在2到15之間")
	private String rentAppRo;
	
	@NotEmpty(message="詳細地址: 請勿空白")
	private String rentAppAdd;
	
	private byte[] rentAppOwn;
	
	@NotNull(message="樓層: 請勿空白")
	@Min(value = 1, message = "樓層: 不能小於{value}")
	private Integer rentAppFloor;
	
	@NotNull(message="坪數: 請勿空白")
	@DecimalMin(value = "0.00", message = "坪數: 不能小於{value}")
	private Double rentAppSize;
	
	@Column(insertable = false)
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
		return "RentApp [rentAppNo=" + rentAppNo + ", ldd=" + ldd + ", emp=" + emp + ", rent=" + rent + ", rentAppCou="
				+ rentAppCou + ", rentAppAr=" + rentAppAr + ", rentAppRo=" + rentAppRo + ", rentAppAdd=" + rentAppAdd
				+  ", rentAppFloor=" + rentAppFloor + ", rentAppSize="
				+ rentAppSize + ", rentAppSt=" + rentAppSt + "]";
	}
	
	
}
