package business.com.fzhong.service.kg.enums;

public enum CountyTypeEnums {
	QU("区"),
	XIN_QU("新区"),
	XIAN("县");
	
	private String name;
	
	private CountyTypeEnums(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
