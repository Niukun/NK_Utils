package business.com.fzhong.service.kg.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import api.com.fzhong.service.IApiService;
import base.com.fzhong.service.db.neo4j.IBaseNeo4j;
import base.com.fzhong.service.db.neo4j.impl.BaseNeo4jImpl;
import business.com.fzhong.service.kg.dao.AddressDao;
import business.com.fzhong.service.kg.dao.AreaDao;
import business.com.fzhong.service.kg.dao.BuildingDao;
import business.com.fzhong.service.kg.dao.CompanyDao;
import business.com.fzhong.service.kg.dao.GraphDao;
import business.com.fzhong.service.kg.dao.IndustryDao;
import business.com.fzhong.service.kg.dao.ProjectDao;
import business.com.fzhong.service.kg.dto.AddressDto;
import business.com.fzhong.service.kg.dto.AreaDto;
import business.com.fzhong.service.kg.dto.BuildingDto;
import business.com.fzhong.service.kg.dto.CompanyDto;
import business.com.fzhong.service.kg.dto.IndustryDto;

import com.google.gson.Gson;

/**
 * REST接口实现类
 * @author Liyibin
 *
 */
@SuppressWarnings("unused")
public class ServiceImpl implements IApiService {

	private static IBaseNeo4j baseNeo4jImpl = new BaseNeo4jImpl();
	private static GraphDao graphDao = new GraphDao();
	private static AddressDao addressDao = new AddressDao();
	private static AreaDao areaDao = new AreaDao();
	private static CompanyDao companyDao = new CompanyDao();
	private static IndustryDao industryDao = new IndustryDao();
	private static BuildingDao buildingDao = new BuildingDao();
	private static ProjectDao projectDao = new ProjectDao();
	private static Gson gson = new Gson();

	public String getEntityListByFuzzyEntityName(String entityName, int classId) {
		Map<String, Object> output = new HashMap<String, Object>();
		List<?> entityList = graphDao.getEntityListByFuzzyEntityName(
				entityName, classId);
		output.put("code", "200");
		output.put("msg", "成功");
		output.put("data", entityList);
		return gson.toJson(output);
	}

	public String getCompanyInfoByCompanyId(String companyId) {
		Map<String, Object> output = new HashMap<String, Object>();
		List<CompanyDto> entityList = companyDao
				.getCompanyInfoByCompanyId(companyId);
		output.put("code", "200");
		output.put("msg", "成功");
		output.put("data", entityList);
		return gson.toJson(output);
	}

	public String getBuildingInfoByBuildingId(String buildingId) {
		Map<String, Object> output = new HashMap<String, Object>();
		List<BuildingDto> entityList = buildingDao
				.getBuildingInfoByBuildingId(buildingId);
		output.put("code", "200");
		output.put("msg", "成功");
		output.put("data", entityList);
		return gson.toJson(output);
	}

	public String getAddressInfoByAddressId(String addressId) {
		Map<String, Object> output = new HashMap<String, Object>();
		List<AddressDto> entityList = addressDao
				.getAddressInfoByAddressId(addressId);
		output.put("code", "200");
		output.put("msg", "成功");
		output.put("data", entityList);
		return gson.toJson(output);
	}

	public String getIndustryInfoByIndustryId(String industryId) {
		Map<String, Object> output = new HashMap<String, Object>();
		List<IndustryDto> entityList = industryDao
				.getIndustryInfoByIndustryId(industryId);
		output.put("code", "200");
		output.put("msg", "成功");
		output.put("data", entityList);
		return gson.toJson(output);
	}

	public String getAreaInfoByAreaId(String areaId) {
		Map<String, Object> output = new HashMap<String, Object>();
		List<AreaDto> entityList = areaDao.getAreaInfoByAreaId(areaId);
		output.put("code", "200");
		output.put("msg", "成功");
		output.put("data", entityList);
		return gson.toJson(output);
	}

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		List<?> entityList = graphDao.getEntityListByFuzzyEntityName("",
				1);
		System.out.println(entityList.size());
		for (Object entity : entityList) {
			if (entity instanceof CompanyDto) {
				CompanyDto com = (CompanyDto) entity;
				System.out.println(com.getCompanyName());
//				System.out.println(com.getId());
				for(AddressDto address : addressDao.getAddressListByCompany(com.getId())){
					System.out.println(address.getCityName());
					System.out.println(companyDao.getCompanyListByAddress(address.getId()).size());
					System.out.println("1");
				}
			}
			if (entity instanceof BuildingDto) {
				BuildingDto bu = (BuildingDto) entity;
				System.out.println(bu.getBuildingName());
				for(AddressDto address : addressDao.getAddressListByBuilding(bu.getId())){
					System.out.println(companyDao.getCompanyListByAddress(address.getId()).size());
					System.out.println("1");
				}
			}
			if (entity instanceof IndustryDto) {
				IndustryDto in = (IndustryDto) entity;
				System.out.println(in.getIndustry());
				System.out.println(companyDao.getCompanyListByIndustry(
						in.getId()).size());
			}
		}
		System.out.println(System.currentTimeMillis() - time);
	}
	
	public String getCompanyListByProjectId(String projectId) {
		Map<String, Object> output = new HashMap<String, Object>();
		List<CompanyDto> entityList = new ArrayList<CompanyDto>();
		List<BuildingDto> buildingList = buildingDao
				.getBuildingListByProject(projectId);
		for (BuildingDto building : buildingList) {
			List<AddressDto> addressList = addressDao
					.getAddressListByBuilding(building.getId());
			for (AddressDto address : addressList) {
				entityList.addAll(companyDao.getCompanyListByAddress(address
						.getId()));
			}
		}
		output.put("code", "200");
		output.put("msg", "成功");
		output.put("data", entityList);
		return gson.toJson(output);
	}
	
	public String getBuildingListByAreaId(String areaId) {
		Map<String, Object> output = new HashMap<String, Object>();
		List<BuildingDto> entityList = new ArrayList<BuildingDto>();
		List<AddressDto> addressList = addressDao.getAddressListByArea(areaId);
		for (AddressDto address : addressList) {
			entityList.addAll(buildingDao.getBuildingListByAddress(address
					.getId()));
		}
		output.put("code", "200");
		output.put("msg", "成功");
		output.put("data", entityList);
		return gson.toJson(output);
	}

	public String getCompanyListByAreaId(String areaId) {
		Map<String, Object> output = new HashMap<String, Object>();
		List<CompanyDto> entityList = new ArrayList<CompanyDto>();
		List<AddressDto> addressList = addressDao.getAddressListByArea(areaId);
		for (AddressDto address : addressList) {
			entityList.addAll(companyDao.getCompanyListByAddress(address
					.getId()));
		}
		output.put("code", "200");
		output.put("msg", "成功");
		output.put("data", entityList);
		return gson.toJson(output);
	}

	public String getCompanyListByIndustryId(String industryId) {
		Map<String, Object> output = new HashMap<String, Object>();
		List<CompanyDto> entityList = companyDao
				.getCompanyListByIndustry(industryId);
		output.put("code", "200");
		output.put("msg", "成功");
		output.put("data", entityList);
		return gson.toJson(output);
	}

}
