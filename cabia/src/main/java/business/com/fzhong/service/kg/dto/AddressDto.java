package business.com.fzhong.service.kg.dto;

import java.math.BigDecimal;

public class AddressDto {

	private String id; //id
	private String address; //地址
	private String province; // 省名
	private AreaDto cityName;
	private AreaDto countyName; // 区名
	private AreaDto townName; // 镇名
	private AreaDto roadName; // 路名
	private AreaDto cun;   //村名
	private String buildingNum; // 楼号
	private String zuo; // 座名
	private String floor; // 公司所在层数
	private BigDecimal lat; // 地址经纬度
	private BigDecimal lng; // 地址经纬度
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public AreaDto getCityName() {
		return cityName;
	}
	public void setCityName(AreaDto cityName) {
		this.cityName = cityName;
	}
	public AreaDto getCountyName() {
		return countyName;
	}
	public void setCountyName(AreaDto countyName) {
		this.countyName = countyName;
	}
	public AreaDto getTownName() {
		return townName;
	}
	public void setTownName(AreaDto townName) {
		this.townName = townName;
	}
	public AreaDto getRoadName() {
		return roadName;
	}
	public void setRoadName(AreaDto roadName) {
		this.roadName = roadName;
	}
	public AreaDto getCun() {
		return cun;
	}
	public void setCun(AreaDto cun) {
		this.cun = cun;
	}
	public String getBuildingNum() {
		return buildingNum;
	}
	public void setBuildingNum(String buildingNum) {
		this.buildingNum = buildingNum;
	}
	public String getZuo() {
		return zuo;
	}
	public void setZuo(String zuo) {
		this.zuo = zuo;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public BigDecimal getLat() {
		return lat;
	}
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	public BigDecimal getLng() {
		return lng;
	}
	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}
	
	
	
}
