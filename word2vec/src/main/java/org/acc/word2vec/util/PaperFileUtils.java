package org.acc.word2vec.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaperFileUtils {

	public static void main(String[] args) {
		System.out.println("start");
		// filetoOne(new File("D:/NLPIR/paper/files/bigfile"));
		int strlen = countFileWords("D:/NLPIR/paper/files/bigfile/bigfileSegment.txt");
		System.out.println(strlen);
		System.out.println("end");
	}

	private static int countFileWords(String string) {
		int wordNum = 0;
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			BufferedReader bufr = new BufferedReader(new FileReader(string));
			BufferedWriter bufw = new BufferedWriter(new FileWriter("D:/NLPIR/paper/files/bigfile/bigfileWord.txt"));
			while ((line = bufr.readLine()) != null) {
				sb.append(line);
			}
			String str = sb.toString();
			String[] strs = str.split(" ");
			Set<String> set = new TreeSet<String>();
			for (int i = 0; i < strs.length; i++) {
				set.add(strs[i].trim().replaceAll("", ""));
			}
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

	private static void filetoOne(File file) {
		BufferedReader bufr = null;
		BufferedWriter bufw = null;
		String line = null;
		try {
			bufw = new BufferedWriter(new FileWriter("D:/NLPIR/paper/files/bigfile/bigfile.txt", true));
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					filetoOne(files[i]);
				}
			} else {
				bufr = new BufferedReader(new FileReader(file));
				while ((line = bufr.readLine()) != null) {
					bufw.write(line);
					bufw.newLine();
					bufw.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufw != null) {
				try {
					bufw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (bufr != null) {
				try {
					bufw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
