package business.com.fzhong.service.kg.dto.req;

import java.util.HashMap;
import java.util.Map;

public class EntityDtoTest {
	public static void main(String[] args) {
		DataDtoTest test = new DataDtoTest();
		Map<String,String> map = new HashMap<String,String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		test.setName("niukun");
		test.setEntity(map);
		System.out.println(test.toString());
	}
}

class DataDtoTest {
	private String name;
	private Map<String,String> entity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getEntity() {
		return entity;
	}

	public void setEntity(Map<String, String> entity) {
		this.entity = entity;
	}

	@Override
	public String toString() {
		return "name:" + this.name + ", " + mapToString(entity) ;
	}
	
	private String mapToString(Map<String,String> map){
		StringBuilder sb = new StringBuilder();
		int i =1;
		for(String key :map.keySet()){
			if(i++<map.keySet().size()){
				sb.append(key+":"+map.get(key)+", ");
			}else{
				sb.append(key+":"+map.get(key));
			}
		}
		return sb.toString();
	}
}