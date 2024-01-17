package com.mem.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.mem.model.uniqueAnnotation.Create;
import com.mem.model.uniqueAnnotation.UniqueMemID;
import com.mem.model.uniqueAnnotation.UniqueMemMail;
import com.mem.model.uniqueAnnotation.UniqueMemPhone;


@Entity
@Table(name = "mem")
public class Mem implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="memNo", updatable = false)
	private Integer memNo;
	
	@Column(name="memMail", unique = true)
	@NotBlank(message = "信箱不能空白！")
	@Pattern(regexp="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$", message = "信箱格式輸入錯誤！")
	@UniqueMemMail(groups = Create.class)
	private String memMail;
	
	@Column(name="memPsw")
	@NotBlank(message = "密碼不能為空白！")
	private String memPsw;
	
	@Column(name="memName")
	@NotBlank(message="會員姓名: 請勿空白")
	@Pattern(regexp = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$", message = "會員姓名: 只能是中、英文字母、數字和_")
	private String memName;
	
	@Column(name="memSex")
	@NotNull(message = "請輸入性別")
	private Byte memSex;
	
	@Column(name="memPhone", columnDefinition = "CHAR(10)", unique = true)
	@NotBlank(message="會員手機: 請勿空白")
	@Pattern(regexp = "^[0][9]\\d{8}$", message = "手機格式錯誤")
	@UniqueMemPhone(groups = Create.class)
	private String memPhone;
	
	@Column(name="memAdd")
	@NotBlank(message="會員地址: 請勿空白")
	private String memAdd;
	
	@Column(name="memID", columnDefinition = "CHAR(10)", unique = true)
	@NotBlank(message="會員身分證: 請勿空白")
	@Pattern(regexp= "^[A-Z][12]\\d{8}$", message = "身分證格式錯誤")
	@UniqueMemID(groups = Create.class)
	private String memID;
	
	@Column(name="memReg")
//	@NotNull
	private Date memReg;
	
	@Column(name="memStatus")
	private Byte memStatus;
	
	@Column(name="lastLoginTime")
	private Timestamp lastLoginTime;
	
//	@Transient
	@Column(name="memPic")
	private byte[] memPic;
	
//	@OneToMany(mappedBy = "fix")
//	private Set<Fix> fix;
	
//	@OneToMany(mappedBy = "ldd")
//	private Set<Ldd> ldd;
	
//	@OneToMany(mappedBy = "lddApp")
//	private Set<LddApp> lddApp;
	
//	@OneToMany(mappedBy = "report")
//	private Set<Report> report;
	
//	@OneToMany(mappedBy = "ord")
//	private Set<Ord> ord;
	
//	@OneToMany(mappedBy = "myPro")
//	private Set<MyPro> myPro;
	
//	@OneToMany(mappedBy = "myRent")
//	private Set<MyRent> myRent;
	
//	@OneToMany(mappedBy = "apo")
//	private Set<Apo> apo;
	
//	@OneToMany(mappedBy = "lse")
//	private Set<Lse> lse;
	
	public Mem() {
	}

	public Integer getMemNo() {
		return memNo;
	}
	public void setMemNo(Integer memNo) {
		this.memNo = memNo;
	}
	public String getMemMail() {
		return memMail;
	}
	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}
	public String getMemPsw() {
		return memPsw;
	}
	public void setMemPsw(String memPsw) {
		this.memPsw = memPsw;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public Byte getMemSex() {
		return memSex;
	}
	public void setMemSex(Byte memSex) {
		this.memSex = memSex;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemAdd() {
		return memAdd;
	}
	public void setMemAdd(String memAdd) {
		this.memAdd = memAdd;
	}
	public String getMemID() {
		return memID;
	}
	public void setMemID(String memID) {
		this.memID = memID;
	}
	public Date getMemReg() {
		return memReg;
	}
	public void setMemReg(Date memReg) {
		this.memReg = memReg;
	}
	public Byte getMemStatus() {
		return memStatus;
	}
	public void setMemStatus(Byte memStatus) {
		this.memStatus = memStatus;
	}
	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public byte[] getMemPic() {
		return memPic;
	}
	public void setMemPic(byte[] memPic) {
		this.memPic = memPic;
	}

	@Override
	public String toString() {
		return "Mem [memNo=" + memNo + ", memMail=" + memMail + ", memPsw=" + memPsw + ", memName=" + memName
				+ ", memSex=" + memSex + ", memPhone=" + memPhone + ", memAdd=" + memAdd + ", memID=" + memID
				+ ", memReg=" + memReg + ", memStatus=" + memStatus + ", lastLoginTime=" + lastLoginTime.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + "]";
	}
}
