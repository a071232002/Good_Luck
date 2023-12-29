package com.tag.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tag") // 實際的表名
public class TagVO implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tagNo")
    private Integer tagNo;

    @Column(name = "tagName")
    private String tagName;

    public Integer getTagNo() {
        return tagNo;
    }

    public void setTagNo(Integer tagNo) {
        this.tagNo = tagNo;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
