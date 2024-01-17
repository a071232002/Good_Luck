package com.dtl.model;

import java.io.Serializable;
import java.util.Objects;

public class DtiId implements Serializable {

    private Integer ordNo;
    private Integer proNo;

    public DtiId() {

    }

    public DtiId(Integer ordNo, Integer proNo) {
        this.ordNo = ordNo;
        this.proNo = proNo;
    }

    // getters 和 setters
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DtiId)) return false;
        DtiId dtlId = (DtiId) o;
        return Objects.equals(getOrdNo(), dtlId.getOrdNo()) &&
               Objects.equals(getProNo(), dtlId.getProNo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrdNo(), getProNo());
    }
}
