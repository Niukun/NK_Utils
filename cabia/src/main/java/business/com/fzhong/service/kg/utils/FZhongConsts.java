package business.com.fzhong.service.kg.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author DingFengwu
 *
 */
public class FZhongConsts {

	private static final String MAP_CONFIG = "map_config.properties";
	private static final String MONGO_CONFIG = "mongo_config.properties";
	private static final String NEO4J_CONFIG = "neo4j_config.properties";// 配置文件

	private static Properties mapProperties = new Properties();
	private static Properties mongoProperties = new Properties();
	private static Properties neo4jProperties = new Properties();

	static {
		try {
			mapProperties.load(FZhongConsts.class.getClassLoader()
					.getResourceAsStream(MAP_CONFIG));
			mongoProperties.load(FZhongConsts.class.getClassLoader()
					.getResourceAsStream(MONGO_CONFIG));
			neo4jProperties.load(FZhongConsts.class.getClassLoader()
					.getResourceAsStream(NEO4J_CONFIG));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * get方法获取配置文件参数值
	 * 
	 * @param key
	 * @return
	 */
	private static String getProp(String key, Properties props) {
		return props.getProperty(key);
	}

	/**
	 * mongoDb数据库连接
	 */
	public static final String DRIVER_MONGO_PARAM = getProp("driver",
			mongoProperties);

	/**
	 * Neo4j驱动连接信息
	 */
	public static final String DRIVER_NEO4J_PARAM = getProp("driver",
			neo4jProperties);
	public static final String USER_NEO4J_PARAM = getProp("user",
			neo4jProperties);
	public static final String PASSWORD_NEO4J_PARAM = getProp("password",
			neo4jProperties);

	/**
	 * 实体及实体关系添加
	 */
	public static final String COMPANY = getProp("company", neo4jProperties);
	
	public static final String COMPANYNONEINDUSTRY = getProp(
			"companyNoneIndustry", neo4jProperties);

	public static final String BUILDINGNONEPROJECT = getProp(
			"buildingNoneProject", neo4jProperties);

	public static final String BUILDING = getProp("building", neo4jProperties);

	/**
	 * uuid添加
	 */
	public static final String CITY = getProp("city", neo4jProperties);
	public static final String COUNTY = getProp("county", neo4jProperties);
	public static final String ROAD = getProp("road", neo4jProperties);
	public static final String ADDRESS = getProp("address", neo4jProperties);
	public static final String INDUSTRY = getProp("industry", neo4jProperties);

	/**
	 * 实体查询
	 */
	public static final String GETPROJECTINFOBYPROJECTID = getProp(
			"getProjectInfoByProjectId", neo4jProperties);
	public static final String GETBUILDINGINFOBYBUILDINGID = getProp(
			"getBuildingInfoByBuildingId", neo4jProperties);
	public static final String GETPROJECTLISTBYBUILDING = getProp(
			"getProjectListByBuilding", neo4jProperties);
	public static final String GETCOMPANYINFOBYCOMPANYID = getProp(
			"getCompanyInfoByCompanyId", neo4jProperties);
	public static final String GETADDRESSINFOBYADDRESSID = getProp(
			"getAddressInfoByAddressId", neo4jProperties);
	public static final String GETINDUSTRYINFOBYINDUSTRYID = getProp(
			"getIndustryInfoByIndustryId", neo4jProperties);
	public static final String GETAREAINFOBYAREAID = getProp(
			"getAreaInfoByAreaId", neo4jProperties);

	/**
	 * 实体关系查询
	 */
	public static final String GETBUILDINGLISTBYPROJECT = getProp(
			"getBuildingListByProject", neo4jProperties);
	public static final String GETPROJECTLISTBYBUILDINGID = getProp(
			"getProjectListByBuildingId", neo4jProperties);
	public static final String GETADDRESSLISTBYBUILDING = getProp(
			"getAddressListByBuilding", neo4jProperties);
	public static final String GETADDRESSLISTBYCOMPANY = getProp(
			"getAddressListByCompany", neo4jProperties);
	public static final String GETBUILDINGINFOBYADDRESS = getProp(
			"getBuildingInfoByAddress", neo4jProperties);
	public static final String GETCOMPANYLISTBYADDRESS = getProp(
			"getCompanyListByAddress", neo4jProperties);
	public static final String GETCOMPANYLISTBYINDUSTRY = getProp(
			"getCompanyListByIndustry", neo4jProperties);
	public static final String GETINDUSTRYLISTBYCOMPANY = getProp(
			"getIndustryListByCompany", neo4jProperties);
	public static final String GETADDRESSLISTBYAREA = getProp(
			"getAddressListByArea", neo4jProperties);
	public static final String GETAREALISTBYADDRESS = getProp(
			"getAreaListByAddress", neo4jProperties);
	public static final String GETENTITYLISTBYFUZZYCOMPANYNAME = getProp(
			"getEntityListByFuzzyCompanyName", neo4jProperties);
	public static final String GETENTITYLISTBYFUZZYINDUSTRY = getProp(
			"getEntityListByFuzzyIndustry", neo4jProperties);
	public static final String GETENTITYLISTBYFUZZYBUILDINGNAME = getProp(
			"getEntityListByFuzzyBuildingName", neo4jProperties);

	/**
	 * 地图api公钥、私钥
	 */

	public static final String BAIDUSN_MAP_PARAM = getProp("baiduSn",
			mapProperties);
	public static final String BAIDUSK_MAP_PARAM = getProp("baiduSk",
			mapProperties);
	public static final String GAODEAK_MAP_PARAM = getProp("gaodeAk",
			mapProperties);
	/**
	 * 地图解析参数
	 */
	public static final String ADDRESS_MAP_PARAM = "address";
	public static final String RESULTS_MAP_PARAM = "results";
	public static final String LOCATION_MAP_PARAM = "location";
	public static final String NAME_MAP_PARAM = "name";
	public static final String LNG_MAP_PARAM = "lng";
	public static final String LAT_MAP_PARAM = "lat";

	public static final String POIS_MAP_PARAM = "pois";
	public static final String ADNAME_MAP_PARAM = "adname";
	public static final String CITYNAME_MAP_PARAM = "cityname";

}
