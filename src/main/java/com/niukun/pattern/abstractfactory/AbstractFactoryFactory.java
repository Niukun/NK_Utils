package com.niukun.pattern.abstractfactory;

public class AbstractFactoryFactory {
	public static AbstractFactory getFactoryInstance(String factoryName) {
		if (factoryName == null) {
			return null;
		} else if (factoryName.equalsIgnoreCase("shape")) {
			return new ShapeFactory();
		} else if (factoryName.equalsIgnoreCase("color")) {
			return new ColorFactory();
		} else {
			return null;
		}
	}
}
