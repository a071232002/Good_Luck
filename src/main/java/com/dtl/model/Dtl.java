package com.dtl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "dtl")
@IdClass(DtiId.class) // 指定复合主键类
public class Dtl implements Serializable { // 實現 Serializable 接口

    @Id
    @Column(name = "ordNo")
    private Integer ordNo;

    @Id
    @Column(name = "proNo")
    private Integer proNo;

    @Column(name = "dtlQty", nullable = false)
    private Integer dtlQty;

    @Column(name = "dtlSell", nullable = false)
    private Integer dtlSell;
	public Integer getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(Integer ordNo) {
		this.ordNo = ordNo;
	}

	public Integer getProNo() {
		return proNo;
	}

	public void setProNo(Integer proNo) {
		this.proNo = proNo;
	}

	public Integer getDtlQty() {
		return dtlQty;
	}

	public void setDtlQty(Integer dtlQty) {
		this.dtlQty = dtlQty;
	}

	public Integer getDtlSell() {
		return dtlSell;
	}

	public void setDtlSell(Integer dtlSell) {
		this.dtlSell = dtlSell;
	}
	
	

}