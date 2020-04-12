package com.niukun.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class FileUtils {
	public static void main(String[] args) throws UnsupportedEncodingException, Exception {
//		FileSplitByLine("D:/NLPIR/sougou/news_sohusite_xml.dat", 6 * 2048*10);
//		System.out.println(FilesBeginsWithCertainString("D:/NLPIR/sougou/news_sohusite_xml/","<doc>"));
//		System.out.println(FilesBeginsWithCertainString("D:/NLPIR/sougou/news_tensite_xml/","<doc>"));
		getAllFileNameInFolder("K:\\NK\\学习视频\\视频-2020版数据结构与算法\\day01");
		String property = System.getProperty("java.ext.dirs");
		property = System.getProperty("java.class.path");
//		System.out.println(property);
		int[] ints = {1, 2, 3};
		int[] d = new int[5];
		System.arraycopy(ints,0,d,0,ints.length);
		System.out.println(d[0]);

	}

	private static void getAllFileNameInFolder(String filePath){
		File folder = new File(filePath);
		File[] files = folder.listFiles();
		for(File file : files){
			System.out.println(file.getName().substring(0,file.getName().lastIndexOf(".")));
		}
	}

	/**
	 * 判断一个文件夹目录下所有非目录文件是否以某一个字符串开头
	 * 2016-12-20
	 * @param path 文件集所在文件
	 * @param str 目标字符串
	 * @return 
	 * @throws IOException
	 */
	private static boolean FilesBeginsWithCertainString(String path, String str) throws IOException {
		boolean flag = true;
		File file = new File(path);
		File[] files = file.listFiles();
		BufferedReader bufr ;
		for (int i = 0; i < files.length; i++) {
			if(!files[i].isDirectory()){
			bufr = new BufferedReader(new FileReader(files[i]));
			if(!str.equals(bufr.readLine())){
				flag = false;
			}}
			System.out.println(i + " " + flag);
		}
		
		return flag;
	}


	/**
	 * 已知一个文件，固定抽出来每个文件的行数（fileSize行）作为一个新的文件保存，剩下的存入一个单独的文件
	 * 2016-12-20
	 * @param string
	 * @param fileSize
	 * @throws IOException
	 */
	private static void FileSplitByLine(String string, int fileSize) throws IOException {
		InputStreamReader isr = new InputStreamReader(
				new FileInputStream(string), "gbk");
		BufferedReader bufr = new BufferedReader(isr);
		int num = 0;
		String str = null;
		while ((str = bufr.readLine()) != null) {
			num++;
		}
		System.out.println(num);
		int filenum = num / fileSize;

		BufferedReader bufrtTwo = new BufferedReader(new InputStreamReader(
				new FileInputStream(string), "gbk"));
		int count = 1;
		for (int i = 1; i <= filenum - 1; i++) {
			BufferedWriter bufw = new BufferedWriter(
					new FileWriter("D:/NLPIR/sougou/news_sohusite_xml/" + (i) + ".txt"));
			while (((count++) <= fileSize * (i + 1))) {
				if ((str = bufrtTwo.readLine()) != null) {
					bufw.write(str);
					bufw.newLine();
				}
			}
			bufw.flush();
			if (bufw != null) {
				bufw.close();
			}
			count--;
			System.out.println(i + 1 + "\tfile finished");
		}
		BufferedWriter bufw = new BufferedWriter(
				new FileWriter("D:/NLPIR/sougou/news_sohusite_xml/" + filenum + ".txt"));
		while ((str = bufrtTwo.readLine()) != null) {
			bufw.write(str);
			bufw.newLine();
		}
		bufw.flush();
		if (bufw != null) {
			bufw.close();
		}
		System.out.println(filenum + "\tfile finished");

	}

	/**
	 * 按文件数分解大文件
	 * 2016-12-20
	 * @param filenumb
	 * @throws UnsupportedEncodingException
	 * @throws Exception
	 */
	private static void FileSplitByFilenum(int filenumb) throws UnsupportedEncodingException, Exception {
		InputStreamReader isr = new InputStreamReader(
				new FileInputStream("src/main/resources/testfiles/news_sohusite_xml.dat"), "gbk");
		BufferedReader bufr = new BufferedReader(isr);
		int num = 0;
		String str = null;
		while ((str = bufr.readLine()) != null) {
			num++;
		}
		System.out.println(num);
		int singlefilenum = num / filenumb;
		BufferedReader bufrtem = new BufferedReader(new InputStreamReader(
				new FileInputStream("src/main/resources/testfiles/news_sohusite_xml.dat"), "gbk"));
		int count = 0;
		for (int i = 0; i < filenumb - 1; i++) {
			BufferedWriter bufw = new BufferedWriter(
					new FileWriter("src/main/resources/testfiles/news_sohusite_xml/" + (i + 1) + ".txt"));
			while ((str = bufrtem.readLine()) != null && ((count++) < singlefilenum * (i + 1))) {
				bufw.write(str);
			}
			bufw.flush();
			if (bufw != null) {
				bufw.close();
			}
			System.out.println(i + 1 + "\tfile finished");
		}
		BufferedWriter bufw = new BufferedWriter(
				new FileWriter("src/main/resources/testfiles/news/" + filenumb + ".txt"));
		while ((str = bufrtem.readLine()) != null) {
			bufw.write(str);
		}
		bufw.flush();
		if (bufw != null) {
			bufw.close();
		}
		System.out.println(filenumb + "\tfile finished");
	}

	
	/**
	 * 得到一个文件的二进制数字形式
	 * 2016-12-19
	 * @param filename
	 * @param destfile
	 * @throws Exception
	 */
	public static void getFilesBinary(String filename, String destfile) throws Exception {
		FileInputStream fis = new FileInputStream(filename);
		InputStreamReader isr = new InputStreamReader(fis);

		BufferedReader bufr = new BufferedReader(isr);
		BufferedWriter bufw = new BufferedWriter(new FileWriter(new File(destfile)));

		String str = null;
		while ((str = bufr.readLine()) != null) {
			bufw.write(getStringFromBytes(str.getBytes()));
			bufw.newLine();
			bufw.flush();
		}

		System.out.println("Finished ...");
	}

	public static String getStringFromBytes(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			sb.append(Integer.toBinaryString(bytes[i]));
		}
		return sb.toString();
	}

}
