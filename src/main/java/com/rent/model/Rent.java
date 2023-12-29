package com.rent.model;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.rentapp.model.Ldd;

public class Rent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rentNo", updatable = false)
	private Integer rentNo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lddNo", referencedColumnName = "lddNo")
	private Ldd ldd;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lseNo", referencedColumnName = "lseNo")
	private Lse lse;
	
	private Timestamp rentUpTime;
	private byte rentSt;
	private byte rentRefrigerator;
	private byte rentAC;
	private byte rentTV;
	private byte rentWashMachine;
	private byte rentHeater;
	private byte rentBed;
	private byte rentWardrobe;
	private byte rentInternet;
	private byte rentCableTV;
	private byte rentSofa;
	private byte rentBalcony;
	private byte rentElev;
	private byte rentParking;
	private byte rentWaterBill;
	private byte rentElectricityBill;
	private Integer rentRent;
	private String rentPostTitle;
	private String rentIntr;
	private byte rentLayout;
	private byte[] rentImg;
	private String rentAppCou;
	private String rentAppAr;
	private String rentAppRo;
	private String rentAppAdd;
	private byte[] rentAppOwn;
	private Integer rentAppFloor;
	private Double rentAppSize;
	private Double rentLat;
	private Double rentLon;
	
	public Integer getRentNo() {
		return rentNo;
	}
	public void setRentNo(Integer rentNo) {
		this.rentNo = rentNo;
	}
	public Ldd getLdd() {
		return ldd;
	}
	public void setLdd(Ldd ldd) {
		this.ldd = ldd;
	}
	public Lse getLse() {
		return Lse;
	}
	public void setLse(Lse lse) {
		Lse = lse;
	}
	public Timestamp getRentUpTime() {
		return rentUpTime;
	}
	public void setRentUpTime(Timestamp rentUpTime) {
		this.rentUpTime = rentUpTime;
	}
	public byte getRentSt() {
		return rentSt;
	}
	public void setRentSt(byte rentSt) {
		this.rentSt = rentSt;
	}
	public byte getRentRefrigerator() {
		return rentRefrigerator;
	}
	public void setRentRefrigerator(byte rentRefrigerator) {
		this.rentRefrigerator = rentRefrigerator;
	}
	public byte getRentAC() {
		return rentAC;
	}
	public void setRentAC(byte rentAC) {
		this.rentAC = rentAC;
	}
	public byte getRentTV() {
		return rentTV;
	}
	public void setRentTV(byte rentTV) {
		this.rentTV = rentTV;
	}
	public byte getRentWashMachine() {
		return rentWashMachine;
	}
	public void setRentWashMachine(byte rentWashMachine) {
		this.rentWashMachine = rentWashMachine;
	}
	public byte getRentHeater() {
		return rentHeater;
	}
	public void setRentHeater(byte rentHeater) {
		this.rentHeater = rentHeater;
	}
	public byte getRentBed() {
		return rentBed;
	}
	public void setRentBed(byte rentBed) {
		this.rentBed = rentBed;
	}
	public byte getRentWardrobe() {
		return rentWardrobe;
	}
	public void setRentWardrobe(byte rentWardrobe) {
		this.rentWardrobe = rentWardrobe;
	}
	public byte getRentInternet() {
		return rentInternet;
	}
	public void setRentInternet(byte rentInternet) {
		this.rentInternet = rentInternet;
	}
	public byte getRentCableTV() {
		return rentCableTV;
	}
	public void setRentCableTV(byte rentCableTV) {
		this.rentCableTV = rentCableTV;
	}
	public byte getRentSofa() {
		return rentSofa;
	}
	public void setRentSofa(byte rentSofa) {
		this.rentSofa = rentSofa;
	}
	public byte getRentBalcony() {
		return rentBalcony;
	}
	public void setRentBalcony(byte rentBalcony) {
		this.rentBalcony = rentBalcony;
	}
	public byte getRentElev() {
		return rentElev;
	}
	public void setRentElev(byte rentElev) {
		this.rentElev = rentElev;
	}
	public byte getRentParking() {
		return rentParking;
	}
	public void setRentParking(byte rentParking) {
		this.rentParking = rentParking;
	}
	public byte getRentWaterBill() {
		return rentWaterBill;
	}
	public void setRentWaterBill(byte rentWaterBill) {
		this.rentWaterBill = rentWaterBill;
	}
	public byte getRentElectricityBill() {
		return rentElectricityBill;
	}
	public void setRentElectricityBill(byte rentElectricityBill) {
		this.rentElectricityBill = rentElectricityBill;
	}
	public Integer getRentRent() {
		return rentRent;
	}
	public void setRentRent(Integer rentRent) {
		this.rentRent = rentRent;
	}
	public String getRentPostTitle() {
		return rentPostTitle;
	}
	public void setRentPostTitle(String rentPostTitle) {
		this.rentPostTitle = rentPostTitle;
	}
	public String getRentIntr() {
		return rentIntr;
	}
	public void setRentIntr(String rentIntr) {
		this.rentIntr = rentIntr;
	}
	public byte getRentLayout() {
		return rentLayout;
	}
	public void setRentLayout(byte rentLayout) {
		this.rentLayout = rentLayout;
	}
	public byte[] getRentImg() {
		return rentImg;
	}
	public void setRentImg(byte[] rentImg) {
		this.rentImg = rentImg;
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
	public Double getRentLat() {
		return rentLat;
	}
	public void setRentLat(Double rentLat) {
		this.rentLat = rentLat;
	}
	public Double getRentLon() {
		return rentLon;
	}
	public void setRentLon(Double rentLon) {
		this.rentLon = rentLon;
	}
	@Override
	public String toString() {
		return "Rent [rentNo=" + rentNo + ", rentUpTime=" + rentUpTime + ", rentSt=" + rentSt + ", rentRefrigerator="
				+ rentRefrigerator + ", rentAC=" + rentAC + ", rentTV=" + rentTV + ", rentWashMachine="
				+ rentWashMachine + ", rentHeater=" + rentHeater + ", rentBed=" + rentBed + ", rentWardrobe="
				+ rentWardrobe + ", rentInternet=" + rentInternet + ", rentCableTV=" + rentCableTV + ", rentSofa="
				+ rentSofa + ", rentBalcony=" + rentBalcony + ", rentElev=" + rentElev + ", rentParking=" + rentParking
				+ ", rentWaterBill=" + rentWaterBill + ", rentElectricityBill=" + rentElectricityBill + ", rentRent="
				+ rentRent + ", rentPostTitle=" + rentPostTitle + ", rentIntr=" + rentIntr + ", rentLayout="
				+ rentLayout + ", rentAppCou=" + rentAppCou + ", rentAppAr=" + rentAppAr + ", rentAppRo=" + rentAppRo
				+ ", rentAppAdd=" + rentAppAdd + ", rentAppFloor=" + rentAppFloor + ", rentAppSize=" + rentAppSize
				+ ", rentLat=" + rentLat + ", rentLon=" + rentLon + "]";
	}

	
}
