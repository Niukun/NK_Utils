package business.com.fzhong.service.kg.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import business.com.fzhong.service.kg.dto.req.BuildingReqDto;
import business.com.fzhong.service.kg.dto.req.CompanyReqDto;
import business.com.fzhong.service.kg.dto.req.DataReqDto;
import business.com.fzhong.service.kg.enums.DataSourceEnums;
/**
 * strList中数据分类，生成DataDto类型的List
 * @author Niukun
 *
 */
public class KafkaDao {

	public List<DataReqDto> getDataList(List<String> strList) {
		List<DataReqDto> addressList = new ArrayList<DataReqDto>();
		Iterator<String> iter = strList.iterator();
		while (iter.hasNext()) {
			String singleRecord = iter.next();
			DataReqDto address = createDtoFromString(singleRecord);
			if (address != null) {
				addressList.add(address);
			}
		}
		return addressList;
	}

	/**
	 * 每一条数据根据其类型进行不同的初始化形成DataDto
	 * 
	 * @param singleRecord
	 */
	private DataReqDto createDtoFromString(String singleRecord) {
		System.out.println(singleRecord);
		JSONObject obj = JSONObject.parseObject(singleRecord);
		if ("cabia_company".equals(obj.getJSONObject("schema")
				.getString("name"))) {
			JSONObject object = JSONObject.parseObject(obj.getJSONObject(
					"payload").getString("object"));

			String companyName = (String) object.get("company_name");
			String sourceAddress = (String) object.get("location");
			String industry = (String) object.get("industry");
			return new DataReqDto(new CompanyReqDto(companyName,
					DataSourceEnums.PC_COMPANY, sourceAddress, industry));
		} else if ("cabia_building".equals(obj.getJSONObject("schema")
				.getString("name"))) {
			JSONObject object = JSONObject.parseObject(obj.getJSONObject(
					"payload").getString("object"));
			String buildingName = (String) object.get("building_name");
			String sourceAddress = (String) object.get("location");
			return new DataReqDto(new BuildingReqDto(buildingName,
					DataSourceEnums.PC_BUILDING, sourceAddress));
		} else {
			return null;
		}
	}
}
