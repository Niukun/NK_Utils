package com.niukun.map.gaode;

import java.io.Serializable;
import java.util.List;

public class Address implements Serializable {
    private Integer status;
    private String info;
    private Integer infocode;
    private Integer count;
    private List<AddressDetial> geocodes;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getInfocode() {
        return infocode;
    }

    public void setInfocode(Integer infocode) {
        this.infocode = infocode;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<AddressDetial> getGeocodes() {
        return geocodes;
    }

    public void setGeocodes(List<AddressDetial> geocodes) {
        this.geocodes = geocodes;
    }

    @Override
    public String toString() {
        return "Address{" +
                "status=" + status +
                ", info='" + info + '\'' +
                ", infocode=" + infocode +
                ", count=" + count +
                ", geocodes=" + geocodes +
                '}';
    }
}
