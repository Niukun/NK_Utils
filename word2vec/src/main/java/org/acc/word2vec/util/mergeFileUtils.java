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
		int strlen = countFileWords("D:/NLPIR/sougou/big/0214/","52Segment");
//		int strlen = countFileWords("D:/NLPIR/sougou/big/0214/");
		System.out.println("一共有" + strlen + "个词。");
		System.out.println("end");
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
			String str = PreProcess(sb.toString());//预处理操作
			
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

	
	/**
	 * 对文件进行预处理
	 * @param string
	 * @return
	 */
	private static String PreProcess(String string) {
		string.replaceAll("[。=，,,?'【】：:（）()!！$￥%;；“”\"]", " ");
		String pattern = "[\u4e00-\u9fa5]";

		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher("收到");
		System.out.println(m.matches());
		return string;
	}

	/**
	 * 把指定目录下所有文件合并成一个文件，以bigfile.txt存在当前文件夹中
	 * @param file
	 */
	private static void filetoOne(File file) {
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
