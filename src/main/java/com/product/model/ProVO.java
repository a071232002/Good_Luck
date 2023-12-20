package com.product.model;

import java.time.LocalDateTime;
import java.util.Base64;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "product") // 資料庫欄位名稱
public class ProVO implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proNo")
    private Integer proNo;

    @Column(name = "proName")
    private String proName;

    @Column(name = "proMean")
    private String proMean;

    @Column(name = "proPrice")
    private Integer proPrice;

    @Column(name = "proQty")
    private Integer proQty;

    @Lob
    @Column(name = "proImg", columnDefinition = "BLOB")
    private byte[] proImg;

    @Column(name = "proCreateTime")
    private LocalDateTime proCreateTime;

    @Column(name = "proStatus")
    private Integer proStatus;

    @Column(name = "tagNo")
    private Integer tagNo;

    @Column(name = "empNo")
    private Integer empNo;

    // 取得商品編號
    public Integer getProNo() {
        return proNo;
    }

    // 設定商品編號
    public void setProNo(Integer proNo) {
        this.proNo = proNo;
    }

    // 取得商品名稱
    public String getProName() {
        return proName;
    }

    // 設定商品名稱
    public void setProName(String proName) {
        this.proName = proName;
    }

    // 取得商品描述
    public String getProMean() {
        return proMean;
    }

    // 設定商品描述
    public void setProMean(String proMean) {
        this.proMean = proMean;
    }

    // 取得商品價格
    public Integer getProPrice() {
        return proPrice;
    }

    // 設定商品價格
    public void setProPrice(Integer proPrice) {
        this.proPrice = proPrice;
    }

    // 取得商品數量
    public Integer getProQty() {
        return proQty;
    }

    // 設定商品數量
    public void setProQty(Integer proQty) {
        this.proQty = proQty;
    }

    // 取得商品圖片
    public byte[] getProImg() {
        return proImg;
    }

    // 設定商品圖片
    public void setProImg(byte[] proImg) {
        this.proImg = proImg;
    }

    // 取得商品圖片的Base64編碼
    public String getProImgBase64() {
        if (proImg != null) {
            return Base64.getEncoder().encodeToString(proImg);
        } else {
            return null; // 或者返回一個默認的圖片Base64字符串
        }
    }

    // 取得商品建立時間
    public LocalDateTime getProCreateTime() {
        return proCreateTime;
    }

    // 設定商品建立時間
    public void setProCreateTime(LocalDateTime proCreateTime) {
        this.proCreateTime = proCreateTime;
    }

    // 取得商品狀態
    public Integer getProStatus() {
        return proStatus;
    }

    // 設定商品狀態
    public void setProStatus(Integer proStatus) {
        this.proStatus = proStatus;
    }

    // 取得標籤編號
    public Integer getTagNo() {
        return tagNo;
    }

    // 設定標籤編號
    public void setTagNo(Integer tagNo) {
        this.tagNo = tagNo;
    }

    // 取得員工編號
    public Integer getEmpNo() {
        return empNo;
    }

    // 設定員工編號
    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }
}