package com.niukun.random;

import java.util.ArrayList;
import java.util.List;

public class ListRandom {

	public static void main(String[] args) {
		List list = new ArrayList();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		System.out.println("list.size"+list.size());
		for (int i = 0; i < 10; i++) {
			int count = (int)(Math.random()*list.size());
			System.out.println(list.get(count));
			list.remove(count);
		}
		System.out.println("list.size"+list.size());
		
	}

}
