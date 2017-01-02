package org.acc.word2vec.util;

import java.io.File;

public class test {

	public static void main(String[] args) {
		File file = new File("D:/NLPIR/word2vec/class/bigger");
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i].getParent());
		}
	}

}
