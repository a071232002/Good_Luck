package com.notice.model;

import java.sql.Date;
import java.sql.Timestamp;

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
@Table(name = "notice")
public class Notice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "noticeNo", updatable = false)
	private Integer noticeNo;
	
	@Column(name = "empNo")
	private Integer empNo;
	
	@Column(name = "noticeTime")
	private Timestamp noticeTime;
	
	@Column(name = "noticeContent")
	private String noticeContent;
	
	@Column(name = "noticeStatus")
	private Integer noticeStatus;

	    
	
	    // Many-to-One relationship with Employee entity
	    
	    public Notice() {
	    }
		
		
	    public Integer getNoticeno() {
			return noticeNo;
		}

		public void setNoticeno(Integer noticeNo) {
			this.noticeNo = noticeNo;
		}

		public Integer getEmpno() {
			return empNo;
		}

		public void setEmpno(Integer empNo) {
			this.empNo = empNo;
		}

		public Timestamp getNoticetime() {
			return noticeTime;
		}

		public void setNoticetime(Timestamp noticeTime) {
			this.noticeTime = noticeTime;
		}

		public String getNoticecontent() {
			return noticeContent;
		}

		public void setNoticecontent(String noticeContent) {
			this.noticeContent = noticeContent;
		}

		public Integer getNoticeStatus() {
			return noticeStatus;
		}

		public void setNoticestatus(Integer noticeStatus) {
			this.noticeStatus = noticeStatus;
		}

		@Override
		public String toString() {
			return "Notice [noticeNo=" + noticeNo + ", empNo=" + empNo + ", noticeTime=" + noticeTime + ",noticeContent =" + noticeContent + ", noticeContent=" + noticeStatus
					+ "]";
		}	
}
		
