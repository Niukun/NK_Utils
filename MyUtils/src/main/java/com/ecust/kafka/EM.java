package com.ecust.kafka;

public enum EM {
	MON("ZHOUYI"),SUN("ZHOURI");
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private EM(String str){
		str=name;
	}
}
