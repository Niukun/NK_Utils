package business.com.fzhong.service.kg.dao;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import base.com.fzhong.service.db.neo4j.IBaseNeo4j;
import base.com.fzhong.service.db.neo4j.impl.BaseNeo4jImpl;
import business.com.fzhong.service.kg.dto.AddressDto;
import business.com.fzhong.service.kg.dto.AreaDto;
import business.com.fzhong.service.kg.dto.BuildingDto;
import business.com.fzhong.service.kg.dto.CompanyDto;
import business.com.fzhong.service.kg.dto.IndustryDto;
import business.com.fzhong.service.kg.dto.ProjectDto;

@SuppressWarnings("unused")
public class DaoTest {

	private static IBaseNeo4j iBaseNeo4j = new BaseNeo4jImpl();
	

	private static GraphDao graphDao = new GraphDao();
	private static AddressDao addressDao = new AddressDao();
	private static AreaDao areaDao = new AreaDao();
	private static CompanyDao companyDao = new CompanyDao();
	private static IndustryDao industryDao = new IndustryDao();
	private static BuildingDao buildingDao = new BuildingDao();
	private static ProjectDao projectDao = new ProjectDao();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddNodeAndRelationship() {
	}

	@Test
	public void testAddCompanyNode() {
	}

	@Test
	public void testAddBuildingNode() {
	}


	@Test
	public void testGetProjectInfoByProjectId() {
		long time = System.currentTimeMillis();
		List<ProjectDto> list = projectDao.getProjectInfoByProjectId("");
		Iterator<ProjectDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			ProjectDto project = dataIt.next();
			System.out.println("项目:" + project.getProjectName() + "--"
					+ (System.currentTimeMillis() - time));
		}
	}

	@Test
	public void testGetBuildingInfoByBuildingId() {
		long time = System.currentTimeMillis();
		List<BuildingDto> list = buildingDao
				.getBuildingInfoByBuildingId("401cc72d-0949-4eac-b2be-dacef18121fe");
		Iterator<BuildingDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			BuildingDto building = dataIt.next();
			System.out.println("楼宇:" + building.getBuildingName() + "--"
					+ (System.currentTimeMillis() - time));
		}
	}

	@Test
	public void testGetProjectListByBuilding() {
		long time = System.currentTimeMillis();
		List<ProjectDto> list =projectDao.getProjectListByBuilding("");
		Iterator<ProjectDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			ProjectDto project = dataIt.next();
			System.out.println("项目:" + project.getProjectName() + "--"
					+ (System.currentTimeMillis() - time));
		}
	}

	@Test
	public void testGetCompanyInfoByCompanyId() {
		long time = System.currentTimeMillis();
		List<CompanyDto> list = companyDao
				.getCompanyInfoByCompanyId("2687ce12-d07b-4a50-b64f-f933315e7490");
		Iterator<CompanyDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			CompanyDto company = dataIt.next();
			System.out.println("企业:" + company.getCompanyName() + "--"
					+ (System.currentTimeMillis() - time));
		}
	}

	@Test
	public void testGetAddressInfoByAddressId() {
		long time = System.currentTimeMillis();
		List<AddressDto> list = addressDao
				.getAddressInfoByAddressId("0477fd39-00bc-4610-b17e-5afe9131b634");
		Iterator<AddressDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			AddressDto address = dataIt.next();
			System.out.println("地址:" + address.getAddress() + "--"
					+ (System.currentTimeMillis() - time));
		}
	}

	@Test
	public void testGetIndustryInfoByIndustryId() {
		long time = System.currentTimeMillis();
		List<IndustryDto> list = industryDao
				.getIndustryInfoByIndustryId("0976e849-a4ce-44bc-9ebe-e3ff42528110");
		Iterator<IndustryDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			IndustryDto industry = dataIt.next();
			System.out.println("行业:" + industry.getIndustry() + "--"
					+ (System.currentTimeMillis() - time));
		}
	}

	@Test
	public void testGetAreaInfoByAreaId() {
		long time = System.currentTimeMillis();
		List<AreaDto> list = areaDao.getAreaInfoByAreaId("c1dacfdf-1e21-45b2-aacc-6257d03eb59d");
		Iterator<AreaDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			AreaDto areaDto = dataIt.next();
			System.out.println("行政区域:" + areaDto.getAreaName() + "--"
					+ (System.currentTimeMillis() - time));
		}
	}

	@Test
	public void testGetBuildingListByProject() {
		long time = System.currentTimeMillis();
		List<BuildingDto> list = buildingDao.getBuildingListByProject("");
		Iterator<BuildingDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			BuildingDto bui = dataIt.next();
			System.out.println("项目-楼宇:" + bui.getBuildingName() + "--"
					+ (System.currentTimeMillis() - time));
		}
	}

	@Test
	public void testGetProjectListByBuildingId() {
		long time = System.currentTimeMillis();
		List<ProjectDto> list = projectDao.getProjectListByBuildingId("");
		Iterator<ProjectDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			ProjectDto pro = dataIt.next();
			System.out.println("楼宇-项目:" + pro.getProjectName() + "--"
					+ (System.currentTimeMillis() - time));
		}
	}

	@Test
	public void testGetAddressListByBuilding() {
		long time = System.currentTimeMillis();
		List<AddressDto> list = addressDao
				.getAddressListByBuilding("2923f403-e187-47e2-b06a-001307693645");
		Iterator<AddressDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			AddressDto add = dataIt.next();
			System.out.println("楼宇-地址:" + add.getAddress() + add.getCityName()
					+ add.getCountyName() + add.getRoadName() + "--"
					+ (System.currentTimeMillis() - time));
		}
	}

	@Test
	public void testGetAddressListByCompany() {
		long time = System.currentTimeMillis();
		List<AddressDto> list = addressDao
				.getAddressListByCompany("7bc54ed3-50ab-4f62-a587-fc5c83ded8ae");
		Iterator<AddressDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			AddressDto add = dataIt.next();
			System.out.println("企业-地址:" + add.getAddress() + add.getCityName()
					+ add.getCountyName() + add.getRoadName() + "--"
					+ (System.currentTimeMillis() - time));
		}
	}

	@Test
	public void testGetBuildingListByAddress() {
		long time = System.currentTimeMillis();
		List<BuildingDto> list = buildingDao
				.getBuildingListByAddress("351bea33-ed14-411c-91e0-a56e4d9693b6");
		Iterator<BuildingDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			BuildingDto bui = dataIt.next();
			System.out.println("地址-楼宇:" + bui.getBuildingName() + "--"
					+ (System.currentTimeMillis() - time));
		}
	}

	@Test
	public void testGetCompanyListByAddress() {
		long time = System.currentTimeMillis();
		List<CompanyDto> list = companyDao
				.getCompanyListByAddress("0477fd39-00bc-4610-b17e-5afe9131b634");
		Iterator<CompanyDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			CompanyDto company = dataIt.next();
			System.out.println("地址-企业:" + company.getCompanyName() + "--"
					+ (System.currentTimeMillis() - time));
		}
	}

	@Test
	public void testGetCompanyListByIndustry() {
		long time = System.currentTimeMillis();
		List<CompanyDto> list = companyDao
				.getCompanyListByIndustry("084b692c-f23c-43ae-828f-c57ca0cd6c22");
		Iterator<CompanyDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			CompanyDto company = dataIt.next();
			System.out.println("行业-企业:" + company.getCompanyName() + "--"
					+ (System.currentTimeMillis() - time));
		}
	}

	@Test
	public void testGetIndustryListByCompany() {
		long time = System.currentTimeMillis();
		List<IndustryDto> list = industryDao
				.getIndustryListByCompany("cfdf597c-31cc-4440-9027-91ed20af5e60");
		Iterator<IndustryDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			IndustryDto in = dataIt.next();
			System.out.println("企业-行业:" + in.getIndustry() + "--"
					+ (System.currentTimeMillis() - time));
		}
	}

	@Test
	public void testGetAddressListByArea() {
		long time = System.currentTimeMillis();
		List<AddressDto> list = addressDao
				.getAddressListByArea("c1dacfdf-1e21-45b2-aacc-6257d03eb59d");
		Iterator<AddressDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			AddressDto addressDto = dataIt.next();
			System.out.println("区域-地址" + addressDto.getAddress() + "--"
					+ (System.currentTimeMillis() - time));
		}
	}

	@Test
	public void testGetAreaListByAddress() {
		long time = System.currentTimeMillis();
		List<AreaDto> list = areaDao
				.getAreaListByAddress("0477fd39-00bc-4610-b17e-5afe9131b634");
		Iterator<AreaDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			AreaDto areaDto = dataIt.next();
			System.out.println("地址-区域:" + areaDto.getAreaName() + "--"
					+ (System.currentTimeMillis() - time));
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetEntityListByFuzzyEntityName() {
		long time = System.currentTimeMillis();
		List<CompanyDto> list = (List<CompanyDto>) graphDao
				.getEntityListByFuzzyEntityName("生物", 1);
		Iterator<CompanyDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			CompanyDto com = dataIt.next();
			System.out.println("模糊查询:" + com.getCompanyName() + " id:"
					+ com.getId() + "ID:" + com.getCompanyID() + "--"
					+ (System.currentTimeMillis() - time));
		}
	}

	@Test
	public void testGetEntityListByFuzzyCompanyName() {
		long time = System.currentTimeMillis();
		List<CompanyDto> list = companyDao
				.getEntityListByFuzzyCompanyName("生物");
		Iterator<CompanyDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			CompanyDto com = dataIt.next();
			System.out.println("企业模糊查询:" + com.getCompanyName() + " id:"
					+ com.getId() + "ID:" + com.getCompanyID() + "--"
					+ (System.currentTimeMillis() - time));
		}
	}

	@Test
	public void testGetEntityListByFuzzyBuildingName() {
		long time = System.currentTimeMillis();
		List<BuildingDto> list = buildingDao
				.getEntityListByFuzzyBuildingName("中山");
		Iterator<BuildingDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			BuildingDto bui = dataIt.next();
			System.out.println("楼宇模糊查询:" + bui.getBuildingName() + " id:"
					+ bui.getId() + "--" + (System.currentTimeMillis() - time));
		}
	}

	@Test
	public void testGetEntityListByFuzzyIndustry() {
		long time = System.currentTimeMillis();
		List<IndustryDto> list = industryDao
				.getEntityListByFuzzyIndustry("医疗");
		Iterator<IndustryDto> dataIt = list.iterator();
		while (dataIt.hasNext()) {
			IndustryDto in = dataIt.next();
			System.out.println("行业模糊查询:" + in.getIndustry() + " id:"
					+ in.getId() + "--" + (System.currentTimeMillis() - time));
		}
	}

}
