package com.niukun.random;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListRandom {

	public static void main(String[] args) {
		List list = new ArrayList();
		Integer I;
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		System.out.println("list.size: " + list.size());
		/*
		 * for (int i = 0; i < 10; i++) { int count = (int)(Math.random()*list.size());
		 * System.out.println(list.get(count)); list.remove(count); }
		 */
		Iterator it = list.iterator();
		while (it.hasNext()) {
			I = (Integer) it.next();
			if (I.intValue() % 18 == 13) {
				it.remove();
			}
		}
		System.out.println("list.size: " + list.size());

	}

}
