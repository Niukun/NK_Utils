package business.com.fzhong.service.kg.dao;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Values;

import base.com.fzhong.service.db.neo4j.impl.BaseNeo4jImpl;
import business.com.fzhong.service.kg.dto.AddressDto;
import business.com.fzhong.service.kg.utils.FZhongConsts;

public class AddressDao {
	
	private static Driver driver = BaseNeo4jImpl.getDriver();
	
	/**
	 * 通过地址id查询地址信息
	 */
	public List<AddressDto> getAddressInfoByAddressId(String id) {
		Session session = driver.session();
		String str = FZhongConsts.GETADDRESSINFOBYADDRESSID;
		StatementResult result = session.run(str, Values.parameters("id", id));
		List<AddressDto> list = new ArrayList<AddressDto>();
		AddressDto add = new AddressDto();
		while (result.hasNext()) {
			Record record = result.next();
			add.setAddress(record.get("addressName").asString());
			// add.setLat((BigDecimal) record.get("lat"));
			// add.setLng((BigDecimal) record.get("lng"));
			list.add(add);
		}
		session.close();
		return list;
	}
	
	/**
	 * 通过楼宇查询地址
	 */
	public List<AddressDto> getAddressListByBuilding(String id) {
		Session session = driver.session();
		String str = FZhongConsts.GETADDRESSLISTBYBUILDING;
		StatementResult result = session.run(str, Values.parameters("id", id));
		List<AddressDto> list = new ArrayList<AddressDto>();
		AddressDto addressDto = new AddressDto();
		while (result.hasNext()) {
			Record record = result.next();
			addressDto.setAddress(record.get("addressName").asString());
			list.add(addressDto);
		}
		session.close();
		return list;

	}
	
	/**
	 * 通过企业查询地址
	 */
	public List<AddressDto> getAddressListByCompany(String id) {
		Session session = driver.session();
		String str = FZhongConsts.GETADDRESSLISTBYCOMPANY;
		StatementResult result = session.run(str, Values.parameters("id", id));
		List<AddressDto> list = new ArrayList<AddressDto>();
		AddressDto addressDto = new AddressDto();
		while (result.hasNext()) {
			Record record = result.next();
			addressDto.setAddress(record.get("addressName").asString());
			list.add(addressDto);
		}
		session.close();
		return list;

	}
	
	/**
	 * 通过区域查询地址
	 */
	public List<AddressDto> getAddressListByArea(String id) {
		Session session = driver.session();
		String str = FZhongConsts.GETADDRESSLISTBYAREA;
		StatementResult result = session.run(str, Values.parameters("id", id));
		List<AddressDto> list = new ArrayList<AddressDto>();
		AddressDto address = new AddressDto();
		while (result.hasNext()) {
			Record record = result.next();
			address.setAddress(record.get("address").asString());
			list.add(address);
		}
		session.close();
		return list;
	}
}
