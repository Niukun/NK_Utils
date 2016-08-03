package business.com.fzhong.service.kg.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Values;

import base.com.fzhong.service.db.neo4j.impl.BaseNeo4jImpl;
import business.com.fzhong.service.kg.dto.req.AddressReqDto;
import business.com.fzhong.service.kg.dto.req.BuildingReqDto;
import business.com.fzhong.service.kg.dto.req.CompanyReqDto;
import business.com.fzhong.service.kg.dto.req.DataReqDto;
import business.com.fzhong.service.kg.utils.FZhongConsts;

public class GraphDao {

	private static Driver driver = BaseNeo4jImpl.getDriver();

	/**
	 * 通过实体及类别进行模糊查询
	 */
	public List<?> getEntityListByFuzzyEntityName(String entityName, int classId) {
		List<?> list = new ArrayList<>();
		switch (classId) {
		case 1:
			list = new CompanyDao().getEntityListByFuzzyCompanyName(entityName);
			break;
		case 2:
			list = new BuildingDao().getEntityListByFuzzyBuildingName(entityName);
			break;
		case 3:
			list = new IndustryDao().getEntityListByFuzzyIndustry(entityName);
		}
		return list;
	}
	
	/**
	 * 添加实体及实体间的关系
	 */
	public void addNodeAndRelationship(List<DataReqDto> list) {
		Session session = driver.session();
		Iterator<DataReqDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			DataReqDto data = dataIt.next();
			String str = data.getEntity().getDataSource().toString();
			if (str.equals("ERP_COMPANY") || str.equals("PC_COMPANY")) {
				addCompanyNode(data);
			}
			if (str.equals("PC_BUILDING") || str.equals("ERP_BUILDING")) {
				addBuildingNode(data);
			}
		}
		session.close();
	}

	/**
	 * 添加企业实体关系
	 * 
	 * @param data
	 */
	public void addCompanyNode(DataReqDto data) {
		Session session = driver.session();
		CompanyReqDto companyDto = (CompanyReqDto) data.getEntity();
		Iterator<AddressReqDto> addressIt = data.getAddress().iterator();
		while (addressIt.hasNext()) {
			AddressReqDto add = addressIt.next();
			String str;
			if (companyDto.getIndustry() == null) {
				str = FZhongConsts.COMPANYNONEINDUSTRY;
			} else {
				str = FZhongConsts.COMPANY;
			}
			StatementResult result = session
					.run(str,
							Values.parameters("countyName", add.getCountyName()
									+ add.getCountyType().getName(),
									"roadName", add.getRoadName()
											+ add.getRoadType().getName(),
									"cityName", add.getCity(), "addressName",
									add.getAddress(), "lat", "", "lng", "",
									"zuo", "", "floor", "", "buildingNum", "",
									"companyid", UUID.randomUUID().toString(),
									"companyName", companyDto.getCompanyName(),
									"companyId", companyDto.getCompanyID(),
									"industry", companyDto.getIndustry(),
									"hao", add.getRoadType().getName()));
			while (result.hasNext()) {
				Record record = result.next();
				if (record.get("city.id").toString() == "NULL") {
					session.run(FZhongConsts.CITY,
							Values.parameters("id", UUID.randomUUID()
									.toString(), "cityName", add.getCity()));
				}
				if (record.get("county.id").toString() == "NULL") {
					session.run(FZhongConsts.COUNTY,
							Values.parameters("id", UUID.randomUUID()
									.toString(), "countyName",
									add.getCountyName()
											+ add.getCountyType().getName()));
				}
				if (record.get("road.id").toString() == "NULL") {
					session.run(FZhongConsts.ROAD, Values.parameters("id", UUID
							.randomUUID().toString(), "roadName",
							add.getRoadName() + add.getRoadType().getName()));
				}

				if (record.get("address.id").toString() == "NULL") {
					session.run(FZhongConsts.ADDRESS, Values.parameters("id",
							UUID.randomUUID().toString(), "addressName",
							add.getAddress()));
				}
				if ((companyDto.getIndustry() != null)
						&& (record.get("industry.id").toString() == "NULL")) {
					session.run(FZhongConsts.INDUSTRY, Values.parameters("id",
							UUID.randomUUID().toString(), "industry",
							companyDto.getIndustry()));
				}

			}
		}
	}

	/**
	 * 添加楼宇实体关系
	 * 
	 * @param data
	 */
	public void addBuildingNode(DataReqDto data) {
		Session session = driver.session();
		BuildingReqDto buildingDto = (BuildingReqDto) data.getEntity();
		Iterator<AddressReqDto> addressIt = data.getAddress().iterator();
		while (addressIt.hasNext()) {
			AddressReqDto add = addressIt.next();
			String str;
			if (buildingDto.getProjectName() == null) {
				str = FZhongConsts.BUILDINGNONEPROJECT;
			} else
				str = FZhongConsts.BUILDING;
			StatementResult result = session.run(str, Values.parameters(
					"countyName", add.getCountyName()
							+ add.getCountyType().getName(), "roadName",
					add.getRoadName() + add.getRoadType().getName(),
					"cityName", add.getCity(), "addressName", add.getAddress(),
					"lat", "", "lng", "", "zuo", "", "floor", "",
					"buildingNum", "", "buildingid", UUID.randomUUID()
							.toString(), "buildingName", buildingDto
							.getBuildingName(), "buildingType", "",
					"projectid", UUID.randomUUID().toString(), "projectName",
					buildingDto.getProjectName(), "projectId", buildingDto
							.getProjectID(), "updateTime", buildingDto
							.getUpdateTime(), "hao", add.getRoadType()
							.getName()));
			while (result.hasNext()) {
				Record record = result.next();
				if (record.get("city.id").toString() == "NULL") {
					session.run(FZhongConsts.CITY,
							Values.parameters("id", UUID.randomUUID()
									.toString(), "cityName", add.getCity()));
				}
				if (record.get("county.id").toString() == "NULL") {
					session.run(FZhongConsts.COUNTY,
							Values.parameters("id", UUID.randomUUID()
									.toString(), "countyName",
									add.getCountyName()
											+ add.getCountyType().getName()));
				}
				if (record.get("road.id").toString() == "NULL") {
					session.run(FZhongConsts.ROAD, Values.parameters("id", UUID
							.randomUUID().toString(), "roadName",
							add.getRoadName() + add.getRoadType().getName()));
				}

				if (record.get("address.id").toString() == "NULL") {
					session.run(FZhongConsts.ADDRESS, Values.parameters("id",
							UUID.randomUUID().toString(), "addressName",
							add.getAddress()));
				}
			}
		}
	}
}
