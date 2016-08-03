package business.com.fzhong.service.kg.dto.req;

import java.util.HashMap;
import java.util.Map;

import business.com.fzhong.service.kg.enums.DataSourceEnums;

/**
 * 地址对于名称类型的父类
 * @author Revan
 *
 */
public class EntityReqDto {
	private DataSourceEnums dataSource; // 数据来源类型
	private String sourceAddress; // 源地址
	private HashMap<String, String> otherMaps; //其它信息

	// constructor
	public EntityReqDto() {
		super();
	}

	public EntityReqDto(DataSourceEnums dataSource, String sourceAddress) {
		super();
		this.dataSource = dataSource;
		this.sourceAddress = sourceAddress;
	}

	public DataSourceEnums getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSourceEnums dataSource) {
		this.dataSource = dataSource;
	}

	public String getSourceAddress() {
		return sourceAddress;
	}

	public void setSourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
	}

	public HashMap<String, String> getOtherMaps() {
		return otherMaps;
	}

	public void setOtherMaps(HashMap<String, String> otherMaps) {
		this.otherMaps = otherMaps;
	}

	/**
	 * return as: "key:value" pattern
	 * @author Niukun
	 * @param map
	 * @return
	 */
	protected String mapToString(Map<String, String> map) {
		StringBuilder sb = new StringBuilder();
		int i = 1;
		for (String key : map.keySet()) {
			if (i++ < map.keySet().size()) {
				sb.append(key + ":" + map.get(key) + ", ");
			} else {
				sb.append(key + ":" + map.get(key));
			}
		}
		return sb.toString();
	}
}
