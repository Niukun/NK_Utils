package business.com.fzhong.service.kg.dto.req;

import java.math.BigDecimal;

import business.com.fzhong.service.kg.enums.BuildingSuffixEnums;
import business.com.fzhong.service.kg.enums.CountyTypeEnums;
import business.com.fzhong.service.kg.enums.DoorplateCombinationEnums;
import business.com.fzhong.service.kg.enums.RoadTypeEnums;
import business.com.fzhong.service.kg.enums.TownTypeEnums;
import business.com.fzhong.service.kg.enums.UptownTypeEnums;

/**
 * 用于地址标准化过程中存储地址及其提取信息
 * @author Revan
 *
 */
public class AddressReqDto {
	private String address; // 拆分后的单地址
	private boolean correctAddress; // 是否为正确地址
	private String addressFront; // 地址划分的前半部分（仅标准化处理流程中使用）
	private String addressLatter; // 地址划分的后半部分（仅标准化处理流程中使用）
	private String province; // 省名
	private String city; // 城市名
	private String countyName; // 区名
	private CountyTypeEnums countyType; // 区类型
	private String townName; // 镇名
	private TownTypeEnums townType; // 镇的类型
	private String roadName; // 路名
	private RoadTypeEnums roadType; // 路类型
	private String uptownName; // 住宅区名
	private UptownTypeEnums uptownType; // 住宅区类型
	private DoorplateCombinationEnums dcType; // 门牌号组合类型
	private String dcFirst; // 门牌号组合第一位
	private String dcSecond; // 门牌号组合第二位
	private String buildingNum; // 楼宇序号
	private BuildingSuffixEnums baType; // 楼宇序号类型（号，号楼，幢，栋）
	private String zuo; // 座名
	private String floor; // 公司所在层数
	private BigDecimal lat; // 地址经纬度
	private BigDecimal lng; // 地址经纬度

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

	// 构造函数
	public AddressReqDto(String address) {
		this.address = address;
		this.correctAddress = false;
	}

	public AddressReqDto() {
		super();
	}

	// get set方法
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isCorrectAddress() {
		return correctAddress;
	}

	public void setCorrectAddress(boolean correctAddress) {
		this.correctAddress = correctAddress;
	}

	public String getAddressFront() {
		return addressFront;
	}

	public void setAddressFront(String addressFront) {
		this.addressFront = addressFront;
	}

	public String getAddressLatter() {
		return addressLatter;
	}

	public void setAddressLatter(String addressLatter) {
		this.addressLatter = addressLatter;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public CountyTypeEnums getCountyType() {
		return countyType;
	}

	public void setCountyType(CountyTypeEnums countyType) {
		this.countyType = countyType;
	}

	public String getTownName() {
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public TownTypeEnums getTownType() {
		return townType;
	}

	public void setTownType(TownTypeEnums townType) {
		this.townType = townType;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public RoadTypeEnums getRoadType() {
		return roadType;
	}

	public void setRoadType(RoadTypeEnums roadType) {
		this.roadType = roadType;
	}

	public String getUptown() {
		return uptownName;
	}

	public void setUptown(String uptown) {
		this.uptownName = uptown;
	}

	public UptownTypeEnums getUptownType() {
		return uptownType;
	}

	public void setUptownType(UptownTypeEnums uptownType) {
		this.uptownType = uptownType;
	}

	public DoorplateCombinationEnums getDcType() {
		return dcType;
	}

	public void setDcType(DoorplateCombinationEnums dcType) {
		this.dcType = dcType;
	}

	public String getDcFirst() {
		return dcFirst;
	}

	public void setDcFirst(String dcFirst) {
		this.dcFirst = dcFirst;
	}

	public String getDcSecond() {
		return dcSecond;
	}

	public void setDcSecond(String dcSecond) {
		this.dcSecond = dcSecond;
	}

	public String getBuildingNum() {
		return buildingNum;
	}

	public void setBuildingNum(String buildingNum) {
		this.buildingNum = buildingNum;
	}

	public BuildingSuffixEnums getBaType() {
		return baType;
	}

	public void setBaType(BuildingSuffixEnums baType) {
		this.baType = baType;
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

	@Override
	public String toString() {
		return "AddressDto [address=" + address + ", correctAddress=" + correctAddress + ", addressFront="
				+ addressFront + ", addressLatter=" + addressLatter + ", province=" + province + ", city=" + city
				+ ", countyName=" + countyName + ", countyType=" + countyType + ", townName=" + townName + ", townType="
				+ townType + ", roadName=" + roadName + ", roadType=" + roadType + ", uptownName=" + uptownName
				+ ", uptownType=" + uptownType + ", dcType=" + dcType + ", dcFirst=" + dcFirst + ", dcSecond="
				+ dcSecond + ", buildingNum=" + buildingNum + ", baType=" + baType + ", zuo=" + zuo + ", floor=" + floor
				+ ", lat=" + lat + ", lng=" + lng + "]";
	}

}
