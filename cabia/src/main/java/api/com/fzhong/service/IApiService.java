package api.com.fzhong.service;

/**
 * REST服务实现接口定义
 * @author Liyibin
 *
 */
public interface IApiService {
	
	/**
	 * 根据名称模糊查询实体
	 * @param entityName
	 * @param classId	实体类型（1企业 2楼宇 3行业）
	 * @return
	 */
	public String getEntityListByFuzzyEntityName(String entityName, int classId);
	
	/**
	 * 楼宇信息查询
	 * @param buildingId
	 * @return
	 */
	public String getBuildingInfoByBuildingId(String buildingId);
	
	/**
	 * 企业信息查询
	 * @param buildingId
	 * @return
	 */
	public String getCompanyInfoByCompanyId(String companyId);
	
	/**
	 * 地址信息查询
	 * @param addressId
	 * @return
	 */
	public String getAddressInfoByAddressId(String addressId);
	
	/**
	 * 行业信息查询
	 * @param industryId
	 * @return
	 */
	public String getIndustryInfoByIndustryId(String industryId);
	
	/**
	 * 行政区域信息查询
	 * @param areaId
	 * @return
	 */
	public String getAreaInfoByAreaId(String areaId);
	
	/** 
	 * 根据项目id查询所在楼宇的企业信息
	 * @param projectId
	 * @return
	 */
	public String getCompanyListByProjectId(String projectId);
	
	/**
	 * 查询某一区域内的楼宇
	 * @param areaId
	 * @return
	 */
	public String getBuildingListByAreaId(String areaId);
	
	/**
	 * 查询某一区域内的行业
	 * @param areaId
	 * @return
	 */
	public String getCompanyListByAreaId(String areaId);
	
	/**
	 * 根据行业查询企业
	 * @param industryId
	 * @return
	 */
	public String getCompanyListByIndustryId(String industryId);
}
