package com.niukun.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args)  {
		List list = new ArrayList();
		list.add("123");
		TestBean testBean = new TestBean();
		testBean.setList(list);
		System.out.println(testBean.getList());
	}


	//unicode转中文
	public static String unicodeToString(String str) {
		return String.valueOf(JSON.parse(str));
	}
	//中文字符转unicode
	public static String stringToUnicode(String s) {
		return JSON.toJSONString(s, SerializerFeature.BrowserCompatible);

	}

}

