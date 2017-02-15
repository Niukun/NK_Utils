package org.acc.word2vec.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

	public static void main(String[] args) {
		String str = "23*+_";
		String pattern = "[^\\dA-Za-z\\u3007\\u4E00-\\u9FCB\\uE815-\\uE864]+";

		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(str);
		System.out.println(m.matches());
	}

}
