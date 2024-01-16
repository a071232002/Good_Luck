package com.apo.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ApoDTO {
	
	
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
