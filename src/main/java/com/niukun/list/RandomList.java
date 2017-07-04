package com.niukun.list;

import java.util.HashSet;
import java.util.Set;

public class RandomList {

	public static void main(String[] args) {
		Set<Integer> Randlist = new HashSet<Integer>();
		int qwe =0;
		for (int i = 0; i < 67000; i++) {
			
			if (Randlist.size() < 5000) {
				int count = (int) (Math.random() * 67000);
				Randlist.add(Integer.valueOf(count));
				qwe++;
			}else{
				break;
			}
		}
		System.out.println(Randlist.size() + "\tRandlist.size");
		System.out.println(qwe + "\tii");
	}

}
