package com.niukun.pattern.factory;

public abstract class Shape {
 	abstract void draw();
}

class Rectangle extends Shape{
	@Override
	void draw() {
		System.out.println("This is Rectangle.");
	}
}