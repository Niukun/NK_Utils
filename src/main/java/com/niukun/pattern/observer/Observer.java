package com.niukun.pattern.observer;

public abstract class Observer {
	Subject subject;
	public abstract void update();
}

class BinaryObserver extends Observer {
	public BinaryObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Binary:" + Integer.toBinaryString(subject.getState()));
	}

}

class OctalObserver extends Observer {
	public OctalObserver(Subject subject) {
		this.subject = subject;
		//把this对象传递给父类对象中的subject，让它加到自己的ArrayList<Observer>中
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Octal:" + Integer.toOctalString(subject.getState()));
	}
}

class HexaObserver extends Observer {
	public HexaObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Hexa:" + Integer.toHexString(subject.getState()));
	}
}