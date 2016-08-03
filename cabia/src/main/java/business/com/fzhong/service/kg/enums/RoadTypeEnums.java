package business.com.fzhong.service.kg.enums;

public enum RoadTypeEnums {
	LU("路"),
	JIE("街"),
	DAO("道");
	
	private String name;
	
	private RoadTypeEnums(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
