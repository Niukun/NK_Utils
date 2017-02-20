package org.acc.word2vec.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class countFileWords {

	public static void main(String[] args) {
		int num = countFileWords("D:/NLPIR/sougou/big/0214/", "0214_sougou_bigfileNormalizeSegment");
		System.out.println("num:" + num);
	}
	/**
	 * 统计该目录下bigfile.txt里面有多少词，并且记录在*Word.txt中
	 * @param filePath 文件所在路径，如：D:/NLPIR/sougou/big/0214/"
	 * @param filename 文件名称，不带后缀，如果是name.txt，则传入name
	 * @return
	 */
	private static int countFileWords(String filePath,String filename) {
		int wordNum = 0;
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			BufferedReader bufr = new BufferedReader(new FileReader(filePath + filename + ".txt"));
			BufferedWriter bufw = new BufferedWriter(new FileWriter(filePath + filename + "Word.txt"));
			while ((line = bufr.readLine()) != null) {
				sb.append(line);
			}
			String str = sb.toString();
			System.out.println("StringBuilder Finished...");
			String[] strs = str.split(" ");
			System.out.println("split finished....");
			Set<String> set = new TreeSet<String>();
			for (int i = 0; i < strs.length; i++) {
				set.add(strs[i].trim());
			}
			System.out.println("set finished...");
			Iterator<String> it = set.iterator();
			while(it.hasNext()){
				wordNum++;
				bufw.write(it.next());
				bufw.newLine();
			}
			bufw.flush();
			bufw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wordNum;
	}
}
