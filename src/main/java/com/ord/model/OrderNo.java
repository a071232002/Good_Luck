package com.ord.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ordNo") 
public class OrderNo {

	 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordNo") 
    private Integer ordNo;

    @Column(name = "mem_no") 
    private Integer memNo;

    @Column(name = "ord_time") 
    private Date ordTime;

    @Column(name = "ord_ship") 
    private String ordShip;

    @Column(name = "ord_shipping_ads") 
    private String ordShippingAds;

    @Column(name = "ord_price") 
    private Integer ordPrice;

    @Column(name = "ord_status") 
    private Integer ordStatus;

    @Column(name = "ord_delivery_time") 
    private Date ordDeliveryTime;

	public Integer getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(Integer ordNo) {
		this.ordNo = ordNo;
	}

	public Integer getMemNo() {
		return memNo;
	}

	public void setMemNo(Integer memNo) {
		this.memNo = memNo;
	}

	public Date getOrdTime() {
		return ordTime;
	}

	public void setOrdTime(Date ordTime) {
		this.ordTime = ordTime;
	}

	public String getOrdShip() {
		return ordShip;
	}

	public void setOrdShip(String ordShip) {
		this.ordShip = ordShip;
	}

	public String getOrdShippingAds() {
		return ordShippingAds;
	}

	public void setOrdShippingAds(String ordShippingAds) {
		this.ordShippingAds = ordShippingAds;
	}

	public Integer getOrdPrice() {
		return ordPrice;
	}

	public void setOrdPrice(Integer ordPrice) {
		this.ordPrice = ordPrice;
	}

	public Integer getOrdStatus() {
		return ordStatus;
	}

	public void setOrdStatus(Integer ordStatus) {
		this.ordStatus = ordStatus;
	}

	public Date getOrdDeliveryTime() {
		return ordDeliveryTime;
	}

	public void setOrdDeliveryTime(Date ordDeliveryTime) {
		this.ordDeliveryTime = ordDeliveryTime;
	}
    
    
    
}