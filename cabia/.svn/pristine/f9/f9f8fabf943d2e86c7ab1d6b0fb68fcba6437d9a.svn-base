package business.com.fzhong.service.kg.dao;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Values;

import base.com.fzhong.service.db.neo4j.impl.BaseNeo4jImpl;
import business.com.fzhong.service.kg.dto.AreaDto;
import business.com.fzhong.service.kg.utils.FZhongConsts;

public class AreaDao {

	private static Driver driver = BaseNeo4jImpl.getDriver();
	
	/**
	 * 通过id查询区域实体信息
	 */
	public List<AreaDto> getAreaInfoByAreaId(String id) {
		Session session = driver.session();
		String str = FZhongConsts.GETAREAINFOBYAREAID;
		StatementResult result = session.run(str, Values.parameters("id", id));
		List<AreaDto> list = new ArrayList<AreaDto>();
		AreaDto areaDto = new AreaDto();
		while (result.hasNext()) {
			Record record = result.next();
			areaDto.setAreaName(record.get("countyName").asString());
			list.add(areaDto);
		}
		session.close();
		return list;
	}
	
	/**
	 * 通过地址查询行政区域
	 */
	public List<AreaDto> getAreaListByAddress(String id) {
		Session session = driver.session();
		String str = FZhongConsts.GETAREALISTBYADDRESS;
		StatementResult result = session.run(str, Values.parameters("id", id));
		List<AreaDto> list = new ArrayList<AreaDto>();
		AreaDto areaDto = new AreaDto();
		while (result.hasNext()) {
			Record record = result.next();
			/*
			 * areaDto.setAreaName(record.get("cityName").asString());
			 * list.add(areaDto);
			 */
			areaDto.setAreaName(record.get("countyName").asString());
			list.add(areaDto);
		}
		session.close();
		return list;
	}
}
