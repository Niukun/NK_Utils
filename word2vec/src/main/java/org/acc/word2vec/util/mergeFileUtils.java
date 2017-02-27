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

/**
 * 
 * @author Niukun
 *
 */
public class mergeFileUtils {

	public static void main(String[] args) {
		System.out.println("start");
//		filetoOne(new File("D:/NLPIR/sougou/big/0214"));
//		filetoOne(new File("C:/D/NLPIR/paper/files/test/Normalize/seg"));
//		filetoOne(new File("E:/NLPIR/sougou/news_sohusite_xml/xml/full"));
//		filetoOne(new File("E:/NLPIR/sougou/news_tensite_xml/xml/full"));
		filetoOne(new File("C:/D/NLPIR/paper/files/merge/sohusite_tensite"));
//		filetoOne(new File("C:/D/NLPIR/paper/files/train/Normalize/seg"));
//		filetoOne(new File("C:/D/NLPIR/paper/files/merge/noNormalize_Segment"));
		System.out.println("end");
	}

	/**
	 * 把指定目录下所有文件合并成一个文件，以bigfile.txt存在当前文件夹中
	 * 递归处理，得到目录中所有的文本文件
	 * @param file
	 */
	public static void filetoOne(File file) {
		BufferedReader bufr = null;
		BufferedWriter bufw = null;
		String line = null;
		try {
			bufw = new BufferedWriter(new FileWriter(file.getParent()+"/bigfile.txt", true));
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					filetoOne(files[i]);
				}
			} else {
				bufr = new BufferedReader(new FileReader(file));
//				System.out.println(file.getAbsolutePath());
				while ((line = bufr.readLine()) != null) {
					bufw.write(line.toLowerCase());
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
					e.printStackTrace();
				}
			}
			if (bufr != null) {
				try {
					bufw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
