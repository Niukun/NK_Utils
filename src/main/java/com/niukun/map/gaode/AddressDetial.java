package com.niukun.map.gaode;

import java.io.Serializable;
import java.util.List;

public class AddressDetial implements Serializable {
    private String formatted_address;
    private String country;
    private String province;
    private Integer citycode;
    private String city;
    private String district;
    private List township;
    private NameAndType neighborhood;
    private NameAndType building;
    private String adcode;
    private String street;
    private String number;
    private String location;
    private String level;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getCitycode() {
        return citycode;
    }

    public void setCitycode(Integer citycode) {
        this.citycode = citycode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List getTownship() {
        return township;
    }

    public void setTownship(List township) {
        this.township = township;
    }

    public NameAndType getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(NameAndType neighborhood) {
        this.neighborhood = neighborhood;
    }

    public NameAndType getBuilding() {
        return building;
    }

    public void setBuilding(NameAndType building) {
        this.building = building;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "AddressDetial{" +
                "formatted_address='" + formatted_address + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", citycode=" + citycode +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", township=" + township +
                ", neighborhood=" + neighborhood +
                ", building=" + building +
                ", adcode='" + adcode + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", location='" + location + '\'' +
                ", level='" + level + '\'' +
                '}';
    }


    class NameAndType implements Serializable{
        private List name;
        private List type;

        public List getName() {
            return name;
        }

        public void setName(List name) {
            this.name = name;
        }

        public List getType() {
            return type;
        }

        public void setType(List type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "nameAndType{" +
                    "name=" + name +
                    ", type=" + type +
                    '}';
        }
    }
}
