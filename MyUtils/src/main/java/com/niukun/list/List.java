package com.niukun.list;

import java.util.ArrayList;

public class List {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("123");
		list.add("234");
		list.add("345");
		list.add("456");
		list.add("567");
		System.out.println(list.size());
		list.clear();
		list.add("asdf");
		System.out.println(list.size());
		System.out.println(list.toString());
	}

}
