package com.niukun.list;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.list.TreeList;

public class RandomList {

	public static void main(String[] args) {
		Set Randlist = new HashSet();
		int ii =0;
		for (int i = 0; i < 67000; i++) {
			
			if (Randlist.size() < 500) {
				int count = (int) (Math.random() * 67000);
				Randlist.add(Integer.valueOf(count));
				ii++;
			}else{
				break;
			}
		}
		System.out.println(Randlist.size() + "Randlist.size");
		System.out.println(ii + "ii");
	}

}
