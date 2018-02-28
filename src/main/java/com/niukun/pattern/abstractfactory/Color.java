package com.niukun.pattern.abstractfactory;

public abstract class Color {
	abstract void fill();
}

class Red extends Color {
	@Override
	void fill() {
		System.out.println("Fill the red.");
	}
}

class Green extends Color {
	@Override
	void fill() {
		System.out.println("Fill the green.");
	}
}

class Blue extends Color {
	@Override
	void fill() {
		System.out.println("Fill the blue.");
	}
}