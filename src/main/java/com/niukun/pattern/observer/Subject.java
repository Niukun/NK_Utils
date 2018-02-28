package com.niukun.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private List<Observer> observers = new ArrayList<Observer>();

	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}

	public void attach(Observer list) {
		observers.add(list);
	}

	public void notifyAllObservers() {
		for (Observer o : observers) {
			o.update();
		}
	}

}
