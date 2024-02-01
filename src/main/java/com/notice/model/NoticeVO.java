package com.notice.model;

import java.util.Date;

//import java.sql.Timbestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "notice")
public class NoticeVO implements java.io.Serializable{
	private static final long serialVersionUID=1L;
	//new 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "noticeNo", updatable = false)
	private Integer noticeNo;
	
//	@ManyToOne
//	@JoinColumn(name = "empNo", referencedColumnName = "empNo")
	@Column(name = "empNo")
	private Integer empNo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Column(name = "noticeTime")
	private Date noticeTime;
	
	@Column(name = "noticeContent")
	private String noticeContent;
	
	@Column(name = "noticeStatus")
	private Byte noticeStatus;

	    // Many-to-One relationship with Employee entity
	    
	    public NoticeVO() {
	    }
	    public Integer getNoticeNo() {
			return noticeNo;
		}
		public void setNoticeNo(Integer noticeNo) {
			this.noticeNo = noticeNo;
		}
		public Integer getEmpNo() {
			return empNo;
		}

		public void setEmpNo(Integer empNo) {
			this.empNo = empNo;
		}
		public Date getNoticeTime() {
			return noticeTime;
		}
		public void setNoticeTime(Date noticeTime) {
			this.noticeTime = noticeTime;
		}
		public String getNoticeContent() {
			return noticeContent;
		}

		public void setNoticeContent(String noticeContent) {
			this.noticeContent = noticeContent;
		}

		public Byte getNoticeStatus() {
			return noticeStatus;
		}

		public void setNoticeStatus(Byte noticeStatus) {
			this.noticeStatus = noticeStatus;
		}
		
		@Override
		public String toString() {
			return "NoticeVO [noticeNo=" + noticeNo + ", empNo=" + empNo + ", noticeTime=" + noticeTime
					+ ", noticeContent=" + noticeContent + ", noticeStatus=" + noticeStatus + "]";
		}
}
		
