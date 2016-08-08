package com.niukun.list;

import java.util.ArrayList;

public class List {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("123");
		System.out.println(list.size());
		System.out.println(list.toString());
		list.remove(0);

		System.out.println(list.size());
		System.out.println(list.toString());
	}

}
