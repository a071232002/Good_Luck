package com.cha104g2.goodluck.product.model;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ProVO implements java.io.Serializable{
	 
	 	private int proNo;
	    private String proName;
	    private String proMean;
	    private int proPrice;
	    private int proQty;
	    private byte[] proImg;
	    private LocalDateTime proCreateTime;	    
	    private int proStatus;
	    private int tagNo;
	    private int empNo;
	    
	  
	    
	    
		public int getProNo() {
			return proNo;
		}
		public void setProNo(int proNo) {
			this.proNo = proNo;
		}
		public String getProName() {
			return proName;
		}
		public void setProName(String proName) {
			this.proName = proName;
		}
		public String getProMean() {
			return proMean;
		}
		public void setProMean(String proMean) {
			this.proMean = proMean;
		}
		public int getProPrice() {
			return proPrice;
		}
		public void setProPrice(int proPrice) {
			this.proPrice = proPrice;
		}
		public int getProQty() {
			return proQty;
		}
		public void setProQty(int proQty) {
			this.proQty = proQty;
		}
		public byte[] getProImg() {
			return proImg;
		}
		public void setProImg(byte[] proImg) {
			this.proImg = proImg;
		}
	
		
		public LocalDateTime getProCreateTime() {
			return proCreateTime;
		}
		public void setProCreateTime(LocalDateTime proCreateTime) {
			this.proCreateTime = proCreateTime;
		}
		public int getProStatus() {
			return proStatus;
		}
		public void setProStatus(int proStatus) {
			this.proStatus = proStatus;
		}
		public int getTagNo() {
			return tagNo;
		}
		public void setTagNo(int tagNo) {
			this.tagNo = tagNo;
		}
		public int getEmpNo() {
			return empNo;
		}
		public void setEmpNo(int empNo) {
			this.empNo = empNo;
		}
	    
	    
}
