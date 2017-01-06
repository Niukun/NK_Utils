package org.acc.word2vec.util;

import java.io.File;

public class test {

	public static void main(String[] args) {
		String str = "http://star.news.sohu.com/20120703/n347124223.shtml";
		System.out.println(str.substring(0, str.indexOf(".com")+".com".length()));
	}

}
