package com.me.bean;

public class MeRel {
    private String orignial;
    private String std;

    public MeRel() {
    }

    public MeRel(String orignial, String std) {
        this.orignial = orignial;
        this.std = std;
    }

    public String getOrignial() {
        return orignial;
    }

    public void setOrignial(String orignial) {
        this.orignial = orignial;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }
}
