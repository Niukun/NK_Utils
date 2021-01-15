package com.luckybag.bean;

public class PersonInfo {

    private String id;
    private String name;
    private String phone;
    private String company;
    private String amount;
    private String level1;
    private String level2;
    private String level3;
    private String level4;
    private String departmentid;
    private final String strNull = "——";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        if (!strNull.equalsIgnoreCase(level1)) {
            this.level1 = level1;
        }
    }

    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        if (!strNull.equalsIgnoreCase(level2)) {
            this.level2 = level2;
        }
    }

    public String getLevel3() {
        return level3;
    }

    public void setLevel3(String level3) {
        if (!strNull.equalsIgnoreCase(level3)) {
            this.level3 = level3;
        }
    }

    public String getLevel4() {
        return level4;
    }

    public void setLevel4(String level4) {
        if (!strNull.equalsIgnoreCase(level4)) {
            this.level4 = level4;
        }
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }
}
