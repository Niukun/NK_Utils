package business.com.fzhong.service.kg.enums;

public enum DoorplateCombinationEnums {
	NONG("弄"),
	NONG_ZHINONG("弄_支弄"),
	NONG_HAO("弄_号"),
	HAO("号");
	
	private String name;
	
	private DoorplateCombinationEnums(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
