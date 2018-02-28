package com.niukun.pattern.abstractfactory;

public abstract class Shape {
	abstract void draw();
}

class Circle extends Shape {
	@Override
	void draw() {
		System.out.println("This is circle.");
	}
}

class Square extends Shape {
	@Override
	void draw() {
		System.out.println("This is square.");
	}
}

class Rectangle extends Shape {
	@Override
	void draw() {
		System.out.println("This is Rectangle.");
	}
}