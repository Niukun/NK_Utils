package business.com.fzhong.service.kg.dao;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Values;

import base.com.fzhong.service.db.neo4j.impl.BaseNeo4jImpl;
import business.com.fzhong.service.kg.dto.BuildingDto;
import business.com.fzhong.service.kg.utils.FZhongConsts;

public class BuildingDao {

	private static Driver driver = BaseNeo4jImpl.getDriver();
	
	/**
	 * 模糊查询楼宇
	 * 
	 * @param buildingName
	 * @return
	 */
	public List<BuildingDto> getEntityListByFuzzyBuildingName(
			String buildingName) {
		Session session = driver.session();
		String str = FZhongConsts.GETENTITYLISTBYFUZZYBUILDINGNAME;
		StatementResult result = session.run(str,
				Values.parameters("buildingName", buildingName));
		List<BuildingDto> list = new ArrayList<BuildingDto>();
		BuildingDto building = null;
		while (result.hasNext()) {
			Record record = result.next();
			building = new BuildingDto();
			building.setBuildingName(record.get("buildingName").asString());
			building.setBuildingType(record.get("buildingType").asString());
			building.setOtherInfo(record.get("otherInfo").asString());
			building.setId(record.get("id").asString());
			list.add(building);
		}
		session.close();
		return list;
	}
	
	/**
	 * 通过楼宇id查询楼宇信息
	 */
	public List<BuildingDto> getBuildingInfoByBuildingId(String id) {
		Session session = driver.session();
		String str = FZhongConsts.GETBUILDINGINFOBYBUILDINGID;
		StatementResult result = session.run(str, Values.parameters("id", id));
		List<BuildingDto> list = new ArrayList<BuildingDto>();
		BuildingDto building = new BuildingDto();
		while (result.hasNext()) {
			Record record = result.next();
			building.setBuildingName(record.get("buildingName").asString());
			building.setBuildingType(record.get("buildingType").asString());
			building.setOtherInfo(record.get("otherInfo").asString());
			list.add(building);
		}

		session.close();
		return list;
	}

	/**
	 * 通过项目查询楼宇
	 */
	public List<BuildingDto> getBuildingListByProject(String id) {
		Session session = driver.session();
		String str = FZhongConsts.GETBUILDINGLISTBYPROJECT;
		StatementResult result = session.run(str, Values.parameters("id", id));
		List<BuildingDto> list = new ArrayList<BuildingDto>();
		BuildingDto building = new BuildingDto();
		while (result.hasNext()) {
			Record record = result.next();
			building.setBuildingName(record.get("buildingName").asString());
			building.setBuildingType(record.get("buildingType").asString());
			building.setOtherInfo(record.get("otherInfo").asString());
			list.add(building);
		}
		session.close();
		return list;
	}
	
	/**
	 * 通过地址查询楼宇
	 */
	public List<BuildingDto> getBuildingListByAddress(String id) {
		Session session = driver.session();
		String str = FZhongConsts.GETBUILDINGINFOBYADDRESS;
		StatementResult result = session.run(str, Values.parameters("id", id));
		List<BuildingDto> list = new ArrayList<BuildingDto>();
		BuildingDto building = new BuildingDto();
		while (result.hasNext()) {
			Record record = result.next();
			building.setBuildingName(record.get("buildingName").asString());
			building.setBuildingType(record.get("buildingType").asString());
			building.setOtherInfo(record.get("otherInfo").asString());
			list.add(building);
		}
		session.close();
		return list;

	}
}
