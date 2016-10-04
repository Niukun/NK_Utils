package com.niukun.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetSelect2000 {

	public static void main(String[] args) {
		Set<Integer> numberSet = new TreeSet<Integer>();
		for (int i = 0; i < 10; i++) {
			int count = (int) (Math.random() * 100);
			numberSet.add(Integer.valueOf(count));
		}
		Iterator it = numberSet.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
