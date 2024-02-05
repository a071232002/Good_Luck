package com.notice.model;

import java.util.Date;

//import java.sql.Timbestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
	@NotNull(message="員工編號: 請勿空白!")
	private Integer empNo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@NotNull(message="最新消息時間:請勿空白!")
	@Column(name = "noticeTime")
	private Date noticeTime;
	
	@Column(name = "noticeContent")
	@NotEmpty(message="最新消息內容: 請勿空白!")
	@Pattern(regexp = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$", message = "最新消息內容: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間")
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
		
//		@Column(name = "EMPNO")
		
//		@Pattern(regexp = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$", message = "員工編號: 只能是數字 , 且長度必需在2到10之間")
		public Integer getEmpNo() {
			return this.empNo;
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
	
//		@Column(name = "NOTICECONTENT")

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
		
//		@Override
//		public String toString() {
//			return "NoticeVO [noticeNo=" + noticeNo + ", empNo=" + empNo + ", noticeTime=" + noticeTime
//					+ ", noticeContent=" + noticeContent + ", noticeStatus=" + noticeStatus + "]";
//		}
}
		
