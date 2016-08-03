package base.com.fzhong.service.db.neo4j;

import java.util.List;
import java.util.Map;

/**
 * Neo4j的基本操作
 * 
 * @author DingFengwu
 * 
 */
public interface IBaseNeo4j {
	
	/**
	 * 根据实体类型和名称进行模糊搜索，返回匹配到的id集合
	 * @param label
	 * @param name
	 * @return
	 */
	public List<String> getEntityIdByFuzzyName(String label, String name);
	
	/**
	 * 根据实体id及类型获得所有属性，存入Map
	 * @param id
	 * @param label
	 * @return
	 */
	public Map<String, Object> getEntityAttrMap(String id, String label);
	
	/**
	 * 根据实体id及类型获得所有关联实体的id，存入Map（键为实体id，值为实体类型）
	 * @param id
	 * @param label
	 * @return
	 */
	public Map<String, String> getRelatedEntity(String id, String label);
	
	/**
	 * 根据实体id及类型获得所有关联实体的id，以及边上的属性，存入Map(键为关联实体id，值为边上的属性Map)
	 * @param id
	 * @param label
	 * @return
	 */
	public Map<String, Map<String, Object>> getRelationMap(String id,
			String label);
	
	/**
	 * 根据两个实体id及类型获得边的所有属性，存入Map
	 * @param inId
	 * @param inLabel
	 * @param outId
	 * @param outLabel
	 * @return
	 */
	public Map<String, Object> getRelationAttrMap(String inId, String inLabel,
			String outId, String outLabel);
}
