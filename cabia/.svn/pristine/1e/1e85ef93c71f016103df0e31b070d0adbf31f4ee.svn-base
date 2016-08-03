package business.com.fzhong.service.kg.dao;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Values;

import base.com.fzhong.service.db.neo4j.impl.BaseNeo4jImpl;
import business.com.fzhong.service.kg.dto.IndustryDto;
import business.com.fzhong.service.kg.utils.FZhongConsts;

public class IndustryDao {

	private static Driver driver = BaseNeo4jImpl.getDriver();

	/**
	 * 模糊查询行业
	 * 
	 * @param industryName
	 * @return
	 */
	public List<IndustryDto> getEntityListByFuzzyIndustry(String industryName) {
		Session session = driver.session();
		String str = FZhongConsts.GETENTITYLISTBYFUZZYINDUSTRY;
		StatementResult result = session.run(str,
				Values.parameters("industryName", industryName));
		List<IndustryDto> list = new ArrayList<IndustryDto>();
		IndustryDto industry = null;
		while (result.hasNext()) {
			Record record = result.next();
			industry = new IndustryDto();
			industry.setIndustry(record.get("industry").asString());
			industry.setId(record.get("id").asString());
			list.add(industry);
		}
		session.close();
		return list;
	}
	
	/**
	 * 通过行业id查询行业信息
	 */
	public List<IndustryDto> getIndustryInfoByIndustryId(String id) {
		Session session = driver.session();
		String str = FZhongConsts.GETINDUSTRYINFOBYINDUSTRYID;
		StatementResult result = session.run(str, Values.parameters("id", id));
		List<IndustryDto> list = new ArrayList<IndustryDto>();
		IndustryDto industry = new IndustryDto();
		while (result.hasNext()) {
			Record record = result.next();
			industry.setIndustry(record.get("industry").asString());
			list.add(industry);
		}
		session.close();
		return list;
	}
	
	/**
	 * 通过企业查询行业
	 */
	public List<IndustryDto> getIndustryListByCompany(String id) {
		Session session = driver.session();
		String str = FZhongConsts.GETINDUSTRYLISTBYCOMPANY;
		StatementResult result = session.run(str, Values.parameters("id", id));
		List<IndustryDto> list = new ArrayList<IndustryDto>();
		IndustryDto industry = new IndustryDto();
		while (result.hasNext()) {
			Record record = result.next();
			industry.setIndustry(record.get("industry").asString());
			list.add(industry);
		}
		session.close();
		return list;
	}
}
