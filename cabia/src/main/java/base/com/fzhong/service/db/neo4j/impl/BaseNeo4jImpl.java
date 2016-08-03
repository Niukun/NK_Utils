package base.com.fzhong.service.db.neo4j.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Values;

import base.com.fzhong.service.db.neo4j.IBaseNeo4j;
import business.com.fzhong.service.kg.utils.FZhongConsts;

/**
 * 实体基本操作
 * 
 * @author DingFengwu
 * 
 */
public class BaseNeo4jImpl implements IBaseNeo4j {

	private static Driver driver = GraphDatabase.driver(
			FZhongConsts.DRIVER_NEO4J_PARAM, AuthTokens.basic(
					FZhongConsts.USER_NEO4J_PARAM,
					FZhongConsts.PASSWORD_NEO4J_PARAM));// 连接Neo4j;用户名neo4j，密码123

	public static Driver getDriver(){
		return driver;
	}
	
	/**
	 * 根据实体类型和名称进行模糊搜索，返回匹配到的id集合
	 */
	public List<String> getEntityIdByFuzzyName(String label, String name) {
		Session session = driver.session();
		String str = "match (a:" + label
				+ ") where a.name CONTAINS {name} return  a.id as id";
		StatementResult result = session.run(str,
				Values.parameters("name", name));
		List<String> list = new ArrayList<String>();
		while (result.hasNext()) {
			Record record = result.next();
			list.add(record.get("id").asString());
		}
		session.close();
		return list;
	}

	/**
	 * 根据实体id及类型获得所有属性，存入Map
	 */
	public Map<String, Object> getEntityAttrMap(String id, String label) {
		Session session = driver.session();
		Map<String, Object> map = new HashMap<String, Object>();
		String str = "match (a:" + label + ") where a.id={id} return a";
		StatementResult result = session.run(str, Values.parameters("id", id));
		while (result.hasNext()) {
			Record record = result.next();
			map = record.get("a").asMap();
		}
		session.close();
		return map;
	}

	/**
	 * 根据实体id及类型获得所有关联实体的id，存入Map（键为实体id，值为实体类型）
	 */
	public Map<String, String> getRelatedEntity(String id, String label) {
		Session session = driver.session();
		String str = "";
		Map<String, String> map = new HashMap<String, String>();
		str = "match (a:" + label
				+ ")-[]-(n)  return  n.id as id,labels(n) as label";
		StatementResult result = session.run(str);
		while (result.hasNext()) {
			Record record = result.next();
			map.put("id", record.get("id").asString());
			map.put("label",
					record.get("label").asObject().toString().replace("[", "")
							.replace("]", ""));
		}
		session.close();
		return map;
	}

	/**
	 * 根据实体id及类型获得所有关联实体的id，以及边上的属性，存入Map(键为关联实体id，值为边上的属性Map)
	 */
	public Map<String, Map<String, Object>> getRelationMap(String id,
			String label) {
		Session session = driver.session();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Map<String, Object>> paraMap = new HashMap<String, Map<String, Object>>();
		String str = "match (a:" + label
				+ ")-[r]-(n) where a.id = {id} return  n.id as id,r";
		StatementResult result = session.run(str);
		while (result.hasNext()) {
			Record record = result.next();
			map = record.get("r").asMap();
			paraMap.put("id", map);
		}
		session.close();
		return paraMap;
	}

	/**
	 * 根据两个实体id及类型获得边的所有属性，存入Map
	 */
	public Map<String, Object> getRelationAttrMap(String inId, String inLabel,
			String outId, String outLabel) {
		Session session = driver.session();
		Map<String, Object> map = new HashMap<String, Object>();
		String str = "MATCH (a:" + inLabel + ")-[r]-(b:" + outLabel
				+ ") where a.id={inId} and b.id={outId} return r";
		StatementResult result = session.run(str,
				Values.parameters("inId", inId, "outId", outId));
		while (result.hasNext()) {
			Record record = result.next();
			map = record.get("r").asMap();
		}
		session.close();
		return map;
	}
}
