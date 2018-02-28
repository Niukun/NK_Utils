package com.niukun.pattern.factory;

public abstract class ShapeFactory {
	public static Shape getShape(String name){
		if(name == null) {
			return null;
		}else if(name.equalsIgnoreCase("rectangle")) {
			return new Rectangle();
		}else {
			return null;
		}
	}
}
