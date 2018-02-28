package com.niukun.pattern.abstractfactory;

public class AbstractFactoryDemo {

	public static void main(String[] args) {
		
		AbstractFactory shapeFactory = FactoryProducer.getFactoryInstance("shape");
		Shape s = shapeFactory.getShape("circle");
		s.draw();
		
		AbstractFactory colorFactory = FactoryProducer.getFactoryInstance("color");
		Color c = colorFactory.getColor("blue");
		c.fill();
	}

}
