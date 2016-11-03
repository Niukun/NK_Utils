package com.niukun.list;

import java.util.ArrayList;
import java.util.List;

public class ListContainsStr {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List list = new ArrayList();
		for (int i = 0; i < 100; i++) {
			list.add("abc"+i);
		}
		System.out.println(list.contains("abc2"));
	}
}
