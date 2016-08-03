package business.com.fzhong.service.kg.dao;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Values;

import base.com.fzhong.service.db.neo4j.impl.BaseNeo4jImpl;
import business.com.fzhong.service.kg.dto.CompanyDto;
import business.com.fzhong.service.kg.utils.FZhongConsts;

public class CompanyDao {

	private static Driver driver = BaseNeo4jImpl.getDriver();
	
	/**
	 * 模糊查询企业
	 * 
	 * @param companyName
	 * @return
	 */
	public List<CompanyDto> getEntityListByFuzzyCompanyName(String companyName) {
		Session session = driver.session();
		String str = FZhongConsts.GETENTITYLISTBYFUZZYCOMPANYNAME;
		StatementResult result = session.run(str,
				Values.parameters("companyName", companyName));
		List<CompanyDto> list = new ArrayList<CompanyDto>();
		CompanyDto company = null;
		while (result.hasNext()) {
			Record record = result.next();
			company = new CompanyDto();
			company.setCompanyID(record.get("companyId").asString());
			company.setCompanyName(record.get("companyName").asString());
			company.setOtherInfo(record.get("otherInfo").asString());
			company.setId(record.get("id").asString());
			list.add(company);
		}
		session.close();
		return list;
	}
	
	/**
	 * 通过企业id查询企业信息
	 */
	public List<CompanyDto> getCompanyInfoByCompanyId(String id) {
		Session session = driver.session();
		String str = FZhongConsts.GETCOMPANYINFOBYCOMPANYID;
		StatementResult result = session.run(str, Values.parameters("id", id));
		List<CompanyDto> list = new ArrayList<CompanyDto>();
		CompanyDto com = new CompanyDto();
		while (result.hasNext()) {
			Record record = result.next();
			com.setCompanyID(record.get("companyId").asString());
			com.setCompanyName(record.get("companyName").asString());
			com.setOtherInfo(record.get("otherInfo").asString());
			list.add(com);
		}

		session.close();
		return list;
	}
	
	/**
	 * 通过地址查询企业
	 */
	public List<CompanyDto> getCompanyListByAddress(String id) {
		Session session = driver.session();
		String str = FZhongConsts.GETCOMPANYLISTBYADDRESS;
		StatementResult result = session.run(str, Values.parameters("id", id));
		List<CompanyDto> list = new ArrayList<CompanyDto>();
		CompanyDto company = new CompanyDto();
		while (result.hasNext()) {
			Record record = result.next();
			company.setCompanyID(record.get("companyId").asString());
			company.setCompanyName(record.get("companyName").asString());
			company.setOtherInfo(record.get("otherInfo").asString());
			list.add(company);
		}
		session.close();
		return list;
	}
	
	/**
	 * 通过行业查询企业
	 */
	public List<CompanyDto> getCompanyListByIndustry(String id) {
		Session session = driver.session();
		String str = FZhongConsts.GETCOMPANYLISTBYINDUSTRY;
		StatementResult result = session.run(str, Values.parameters("id", id));
		List<CompanyDto> list = new ArrayList<CompanyDto>();
		CompanyDto company = new CompanyDto();
		while (result.hasNext()) {
			Record record = result.next();
			company.setCompanyID(record.get("companyId").asString());
			company.setCompanyName(record.get("companyName").asString());
			company.setOtherInfo(record.get("otherInfo").asString());
			list.add(company);
		}
		session.close();
		return list;
	}

}
