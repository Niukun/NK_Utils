package api.com.fzhong.service.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import api.com.fzhong.service.IApiService;
import business.com.fzhong.service.kg.service.impl.ServiceImpl;

/**
 * REST服务接口定义
 * @author Liyibin
 *
 */
public class ServiceController {
	
	private static IApiService serviceImpl = new ServiceImpl();
	
	/**
	 * 根据名称模糊查询实体
	 * @param entityName
	 * @param classId	实体类型（1企业 2楼宇 3行业）
	 * @param request
	 * @return
	 */
	@GET
	@Path("entity")
	@Produces("text/plain;charset=UTF-8")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String getEntityListByFuzzyEntityName(
			@FormParam("entityName") String entityName,
			@FormParam("classId") int classId,
			@Context HttpServletRequest request) {
		return serviceImpl.getEntityListByFuzzyEntityName(entityName, classId);
	}
	
	/**
	 * 楼宇信息查询
	 * @param buildingId
	 * @param request
	 * @return
	 */
	@GET
	@Path("buildinginfo")
	@Produces("text/plain;charset=UTF-8")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String getBuildingInfoByBuildingId(
			@FormParam("buildingId") String buildingId,
			@Context HttpServletRequest request) {
		return serviceImpl.getBuildingInfoByBuildingId(buildingId);
	}
	
	/**
	 * 企业信息查询
	 * @param companyId
	 * @param request
	 * @return
	 */
	@GET
	@Path("companyinfo")
	@Produces("text/plain;charset=UTF-8")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String getCompanyInfoByCompanyId(
			@FormParam("companyId") String companyId,
			@Context HttpServletRequest request) {
		return serviceImpl.getCompanyInfoByCompanyId(companyId);
	}
	
	/**
	 * 地址信息查询
	 * @param addressId
	 * @param request
	 * @return
	 */
	@GET
	@Path("addressinfo")
	@Produces("text/plain;charset=UTF-8")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String getAddressInfoByAddressId(
			@FormParam("addressId") String addressId,
			@Context HttpServletRequest request) {
		return serviceImpl.getAddressInfoByAddressId(addressId);
	}
	
	/**
	 * 行政区域信息查询
	 * @param areaId
	 * @param request
	 * @return
	 */
	@GET
	@Path("areainfo")
	@Produces("text/plain;charset=UTF-8")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String getAreaInfoByAreaId(
			@FormParam("areaId") String areaId,
			@Context HttpServletRequest request) {
		return serviceImpl.getAreaInfoByAreaId(areaId);
	}
	
	/**
	 * 行业信息查询
	 * @param industryId
	 * @param request
	 * @return
	 */
	@GET
	@Path("industryinfo")
	@Produces("text/plain;charset=UTF-8")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String getIndustryInfoByIndustryId(
			@FormParam("industryId") String industryId,
			@Context HttpServletRequest request) {
		return serviceImpl.getIndustryInfoByIndustryId(industryId);
	}
	
	/**
	 * 根据项目id查询所在楼宇的企业信息
	 * @param buildingId
	 * @param request
	 * @return
	 */
	@GET
	@Path("companyinbuilding")
	@Produces("text/plain;charset=UTF-8")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String getCompanyListByProjectId(
			@FormParam("buildingId") String buildingId,
			@Context HttpServletRequest request) {
		return serviceImpl.getCompanyListByProjectId(buildingId);
	}
	
	/**
	 * 查询某一区域内的楼宇
	 * @param areaId
	 * @param request
	 * @return
	 */
	@GET
	@Path("buildinginarea")
	@Produces("text/plain;charset=UTF-8")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String getBuildingListByAreaId(
			@FormParam("areaId") String areaId,
			@Context HttpServletRequest request) {
		return serviceImpl.getBuildingListByAreaId(areaId);
	}
	
	/**
	 * 查询某一区域内的企业
	 * @param areaId
	 * @param request
	 * @return
	 */
	@GET
	@Path("companyinarea")
	@Produces("text/plain;charset=UTF-8")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String getCompanyListByAreaId(
			@FormParam("areaId") String areaId,
			@Context HttpServletRequest request) {
		return serviceImpl.getCompanyListByAreaId(areaId);
	}
	
	/**
	 * 根据行业查询企业
	 * @param industryId
	 * @param request
	 * @return
	 */
	@GET
	@Path("companyinindustry")
	@Produces("text/plain;charset=UTF-8")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String getCompanyListByIndustryId(
			@FormParam("industryId") String industryId,
			@Context HttpServletRequest request) {
		return serviceImpl.getCompanyListByIndustryId(industryId);
	}
}
