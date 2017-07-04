package com.niukun.regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regEx {

	public static void main(String[] args) {
		 // 要验证的字符串
	    String str = "sadf <img  src=\"photo get\" data-src=\"failed\">";
	    // 正则表达式规则
	    String regEx = "<img[ ]*src=\"(.*?)\".*?>";
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    // 查找字符串中是否有匹配正则表达式的字符/字符串
//	    System.out.println(matcher.find());
//	    System.out.println(str);
	    while(matcher.find()){
	    	System.out.println(matcher.group(1));
	    }

	}

}
