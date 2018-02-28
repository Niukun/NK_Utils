package com.niukun.pattern.factory;

public class ShapeFactoryDemo {

	public static void main(String[] args) {
		Shape s = ShapeFactory.getShape("rectangle");
		s.draw();
	}
	
}
