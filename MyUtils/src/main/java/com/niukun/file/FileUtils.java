package com.niukun.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class FileUtils {
	public static void main(String[] args) throws UnsupportedEncodingException, Exception {
		FileSplit(500);
	}

	private static void FileSplit(int filenumb) throws UnsupportedEncodingException, Exception {
		InputStreamReader isr = new InputStreamReader(new FileInputStream("D:/NLPIR/test/weibo.txt"),"gbk");
		BufferedReader bufr = new BufferedReader(isr);
		int num = 0;
		String str = null;
		while((str=bufr.readLine())!=null){
			num++;
		}
		System.out.println(num);
		int singlefilenum = num/filenumb;
		BufferedReader bufrtem = new BufferedReader(new InputStreamReader(new FileInputStream("D:/NLPIR/test/weibo.txt"),"gbk"));
		int count = 0;
		for (int i = 0; i < filenumb-1; i++) {
			BufferedWriter bufw = new BufferedWriter(new FileWriter("D:/NLPIR/test/weibo/"+(i+1)+".txt"));
			while((str=bufrtem.readLine())!=null&&((count++)<singlefilenum*(i+1))){
				bufw.write(str);
			}
			bufw.flush();
			if(bufw!=null){
				bufw.close();
			}
			System.out.println(i+1+"\tfile finished");
		}
		BufferedWriter bufw = new BufferedWriter(new FileWriter("D:/NLPIR/test/weibo/"+filenumb+".txt"));
		while((str=bufrtem.readLine())!=null){
			bufw.write(str);
		}
		bufw.flush();
		if(bufw!=null){
			bufw.close();
		}
		System.out.println(filenumb+"\tfile finished");
	}

	public static void getFilesBinary(String filename,String destfile) throws Exception{
		FileInputStream fis = new FileInputStream(filename);
		InputStreamReader isr = new InputStreamReader(fis);
		
		BufferedReader bufr = new BufferedReader(isr);
		BufferedWriter bufw = new BufferedWriter(new FileWriter(new File(destfile)));
		
		String str =null;
		while((str=bufr.readLine())!=null){
			bufw.write(getStringFromBytes(str.getBytes()));
			bufw.newLine();
			bufw.flush();
		}
		
		System.out.println("Finished ...");
	}
	public static String getStringFromBytes(byte[] bytes){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			sb.append(Integer.toBinaryString(bytes[i]));
		}
		return sb.toString();
	}
	
}
