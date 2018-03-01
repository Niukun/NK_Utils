package com.niukun.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试一个列表是否包含某个字符串元素
 * 
 * @author Niukun
 *
 */
public class ListContainsStr {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List list = new ArrayList();
		for (int i = 0; i < 100; i++) {
			list.add("abc" + i);
		}
		System.out.println(list.contains("abc222"));
		System.out.println(list.contains("abc2"));
		System.out.println(list.contains("ab"));
	}
}
