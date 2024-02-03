package com.apo.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class ApoDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private static final SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-M-dd");
	private Integer apoNo;
	private Integer rentNo;
	private String rentAddr;
	
	private String memName;
	private String memPhone;
	
	private String apoDate;
	private Byte apoTime;
	private Byte apoStatus;
	
	public ApoDTO() {
		
	}
	
	public ApoDTO(Integer apoNo, Date apoDate, Byte apoTime) {
		this.apoNo = apoNo;
	    this.apoDate = formatApoDate(apoDate);
	    this.apoTime = apoTime;
	}
	
    public ApoDTO(Integer apoNo, Integer rentNo, String rentAddr, String memName, String memPhone, Date apoDate, Byte apoTime, Byte apoStatus) {
		super();
		this.apoNo = apoNo;
		this.rentNo = rentNo;
		this.rentAddr = rentAddr;		
		this.memName = memName;
		this.memPhone = memPhone;
		this.apoDate = formatApoDate(apoDate);
		this.apoTime = apoTime;
		this.apoStatus = apoStatus;
	}
    
	public Integer getApoNo() {
		return apoNo;
	}

	public void setApoNo(Integer apoNo) {
		this.apoNo = apoNo;
	}

	public Integer getRentNo() {
		return rentNo;
	}

	public void setRentNo(Integer rentNo) {
		this.rentNo = rentNo;
	}
	
	public String getRentAddr() {
		return rentAddr;
	}

	public void setRentAddr(String rentAddr) {
		this.rentAddr = rentAddr;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public String getApoDate() {
		return apoDate;
	}

	public void setApoDate(String apoDate) {
		this.apoDate = apoDate;
	}

	public Byte getApoTime() {
		return apoTime;
	}

	public void setApoTime(Byte apoTime) {
		this.apoTime = apoTime;
	}
	
	public Byte getApoStatus() {
		return apoStatus;
	}

	public void setApoStatus(Byte apoStatus) {
		this.apoStatus = apoStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static SimpleDateFormat getSqldateformat() {
		return sqlDateFormat;
	}

	private String formatApoDate(Date apoDate) {
        return sqlDateFormat.format(apoDate);
    }
	
	@Override
	public String toString() {
		return "apoDTO [apoNo=" + apoNo + 
				", apoDate=" + apoDate + 
				", apoTime=" + apoTime + 
				"]";
	}
	
}
