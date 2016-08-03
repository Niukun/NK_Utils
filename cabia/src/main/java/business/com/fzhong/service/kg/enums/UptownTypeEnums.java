package business.com.fzhong.service.kg.enums;

public enum UptownTypeEnums {
	CUN("村");
	
	private String name;
	
	private UptownTypeEnums(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
