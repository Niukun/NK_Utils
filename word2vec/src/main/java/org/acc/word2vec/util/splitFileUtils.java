package org.acc.word2vec.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * 第一步：切分文件并验证
 * 此工具类处理把大文件切分成小文件
 * -Xms256m -Xmx512m
 * @author Niukun
 *
 */
public class splitFileUtils {
	private static int totalLine = 6 * 2048 * 10;
	public static void main(String[] args) throws UnsupportedEncodingException, Exception {
		// 切分文件，默认生成文件与本文件同级目录
		FileSplitByMulti("e:/NLPIR/sougou/news_sohusite_xml.dat", totalLine);
		FileSplitByMulti("e:/NLPIR/sougou/news_tensite_xml.dat", totalLine);
		// 验证制定路径下的文件是否以"<doc>"作为开头
		System.out.println("FilesBeginsWithCertainString:" + FilesBeginsWithCertainString("D:/NLPIR/sougou/news_sohusite_xml/", "<doc>"));
		System.out.println("FilesEndsWithCertainString:" + FilesEndsWithCertainString("D:/NLPIR/sougou/news_sohusite_xml/", "</doc>"));
		System.out.println("FilesBeginsWithCertainString:" + FilesBeginsWithCertainString("D:/NLPIR/sougou/news_tensite_xml/", "<doc>"));
		System.out.println("FilesEndsWithCertainString:" + FilesEndsWithCertainString("D:/NLPIR/sougou/news_tensite_xml/", "</doc>"));
	}

	/**
	 * 判断一个文件是否以某一字符串作为结束行 2016-12-20
	 * @param path
	 * @param str
	 * @return
	 * @throws IOException
	 */
	private static boolean FilesEndsWithCertainString(String path, String str) throws IOException{
		// 开始时设置标志位为true
		boolean flag = true;
		File file = new File(path);
		// 得到目录下所有文件的列表
		File[] files = file.listFiles();
		String line = null,linetem = "1";
		BufferedReader bufr;
		// 对每个文件进行判断，如果有文件不是制定字符串开头，则把标志位设为false
		for (int i = 0; i < files.length; i++) {
			if(!files[i].isDirectory()){
				bufr = new BufferedReader(new FileReader(files[i]));
				bufr.skip(totalLine-2);
				while((line = bufr.readLine())!=null){
					linetem = line;
				}
				if (!str.equals(linetem)) {
					flag = false;
				}
			}
//			System.out.println("第"+i+"个文件开始测试Ends..."+ flag+":"+files[i].getName());
		}
		return flag;
	}

	/**
	 * 判断一个文件是否以某一字符串作为开头行 2016-12-20
	 * 
	 * @param path
	 *            文件集所在文件
	 * @param str
	 *            目标字符串
	 * @return
	 * @throws IOException
	 */
	private static boolean FilesBeginsWithCertainString(String path, String str) throws IOException {
		// 开始时设置标志位为true
		boolean flag = true;
		File file = new File(path);
		// 得到目录下所有文件的列表
		File[] files = file.listFiles();
		BufferedReader bufr;
		// 对每个文件进行判断，如果有文件不是制定字符串开头，则把标志位设为false
		for (int i = 0; i < files.length; i++) {
			if(!files[i].isDirectory()){
				bufr = new BufferedReader(new FileReader(files[i]));
				if (!str.equals(bufr.readLine())) {
					flag = false;
				}
			}
//			System.out.println("第"+i+"个文件开始测试Begins..."+ flag+":"+files[i].getName());
		}
		return flag;
	}

	/**
	 * 已知一个文件，固定抽出来每个文件的行数（fileSize行）作为一个新的文件保存，剩下的存入一个单独的文件 2016-12-20
	 * 
	 * @param string
	 * @param fileSize
	 * @throws IOException
	 */
	private static void FileSplitByMulti(String string, int fileSize) throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream(string), "gbk");

		// 得到文件行数
		BufferedReader bufr = new BufferedReader(isr);
		int num = 0;
		String str = null;
		while ((str = bufr.readLine()) != null) {
			num++;
		}
		System.out.println("文件行数:" + num);
		// 确定需要分割成的文件数量
		int filenum = num / fileSize;

		// 重新读该文件，进行处理
		BufferedReader bufrtTwo = new BufferedReader(new InputStreamReader(new FileInputStream(string), "gbk"));
		int count = 1;
		for (int i = 1; i <= filenum; i++) {
			BufferedWriter bufw = new BufferedWriter(
					new FileWriter(new File(string).getParent()+"/" + (i) + ".txt"));
			while (((count++) <= fileSize * (i))) {
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
			System.out.println(i + "\tfile finished");
		}
		BufferedWriter bufw = new BufferedWriter(
				new FileWriter(new File(string).getParent()+"/" + (filenum + 1) + ".txt"));
		while ((str = bufrtTwo.readLine()) != null) {
			bufw.write(str);
			bufw.newLine();
		}
		bufw.flush();
		if (bufw != null) {
			bufw.close();
		}
		System.out.println((filenum + 1) + "\tfile finished...");

	}

	/**
	 * 按文件数分解大文件 2016-12-20
	 * 
	 * @param filenumb
	 * @throws UnsupportedEncodingException
	 * @throws Exception
	 */
	private static void FileSplitByNum(int filenumb) throws UnsupportedEncodingException, Exception {
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
	 * 得到一个文件的二进制数字形式 2016-12-19
	 * 
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
