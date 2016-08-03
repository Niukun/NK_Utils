package business.com.fzhong.service.kg.enums;

public enum BuildingSuffixEnums {
	//应当加上code，
	HAO("号"),
	HAOLOU("号楼"),
	DONG("栋"),
	ZHUANG("幢");
	
	private String name;
	
	private BuildingSuffixEnums(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
