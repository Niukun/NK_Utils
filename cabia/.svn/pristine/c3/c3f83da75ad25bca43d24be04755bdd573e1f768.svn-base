package business.com.fzhong.service.kg.dto.req;

import business.com.fzhong.service.kg.enums.BuildingTypeEnums;
import business.com.fzhong.service.kg.enums.DataSourceEnums;

/**
 * 用于存储楼宇相关信息
 * @author Revan
 *
 */
public class BuildingReqDto extends EntityReqDto {
	private String buildingName; // 楼宇名
	private BuildingTypeEnums buildingType; // 楼宇类型
	private String updateTime; // 更新时间
	private String projectName; // 项目名（ERP楼宇数据存，PC数据不存）
	private String projectID; // 项目id

	// constructor
	public BuildingReqDto() {
		super();
	}

	public BuildingReqDto(String buildingName, DataSourceEnums dataSource, String sourceAddress) {
		super();
		this.buildingName = buildingName;
		this.setDataSource(dataSource);
		this.setSourceAddress(sourceAddress);
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public BuildingTypeEnums getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(BuildingTypeEnums buildingType) {
		this.buildingType = buildingType;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	@Override
	public String toString() {
		return "buildingName:" + this.getBuildingName() + ", dataSource:" + this.getDataSource().getName()
				+ ", sourceAddress:" + this.getSourceAddress() + ", " + this.mapToString(this.getOtherMaps());
	}
}
