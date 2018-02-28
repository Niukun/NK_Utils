package com.niukun.pattern.abstractfactory;

public abstract class AbstractFactory {
	abstract Shape getShape(String shape);

	abstract Color getColor(String color);
}

class ShapeFactory extends AbstractFactory {
	@Override
	Shape getShape(String shape) {
		if (shape == null) {
			return null;
		} else if (shape.equalsIgnoreCase("circle")) {
			return new Circle();
		} else if (shape.equalsIgnoreCase("Rectangle")) {
			return new Rectangle();
		} else if (shape.equalsIgnoreCase("Square")) {
			return new Square();
		} else {
			return null;
		}
	}

	@Override
	Color getColor(String color) {
		return null;
	}
}
class ColorFactory extends AbstractFactory{

	@Override
	Shape getShape(String shape) {
		return null;
	}

	@Override
	Color getColor(String color) {
		if (color == null) {
			return null;
		} else if (color.equalsIgnoreCase("red")) {
			return new Red();
		} else if (color.equalsIgnoreCase("blue")) {
			return new Blue();
		} else if (color.equalsIgnoreCase("green")) {
			return new Green();
		} else {
			return null;
		}
	}
	
}