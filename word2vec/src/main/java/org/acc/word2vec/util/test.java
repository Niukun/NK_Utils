package org.acc.word2vec.util;

public class test {

	public static void main(String[] args) {
		test1();
		test2();
	}

	private static void test2() {
		String str = "   2                       2   ";
		System.out.println(str.trim().replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("  ", " "));
	}

	private static void test1() {
		String str = "Digital Wolrd Resea";
		str = str.toLowerCase();
		System.out.println(str);
	}

}
