package com.apo.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class ApoDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private static final SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-M-dd");
	private Integer apoNo;
	private String apoDate;
	private Byte apoTime;
	
	public ApoDTO() {
		
	}
	
	public ApoDTO(Integer apoNo, Date apoDate, Byte apoTime) {
		this.apoNo = apoNo;
	    this.apoDate =  formatApoDate(apoDate);
	    this.apoTime = apoTime;
	}
	
    public Integer getApoNo() {
		return apoNo;
	}

	public void setApoNo(Integer apoNo) {
		this.apoNo = apoNo;
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
