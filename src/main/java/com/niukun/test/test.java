package com.niukun.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class test {

	public static void main(String[] args)  {
		String str = "\"\\u4e3d\\u6c34\\u5e02\"";

		System.out.println(unicodeToString(str));
		System.out.println(stringToUnicode("牛坤"));
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

