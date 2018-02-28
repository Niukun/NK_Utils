package com.niukun.pattern.abstractfactory;

public class AbstractFactoryDemo {

	public static void main(String[] args) {
		
		AbstractFactory shapeFactory = AbstractFactoryFactory.getFactoryInstance("shape");
		Shape s = shapeFactory.getShape("circle");
		s.draw();
		
		AbstractFactory colorFactory = AbstractFactoryFactory.getFactoryInstance("color");
		Color c = colorFactory.getColor("blue");
		c.fill();
	}

}
