package com.niukun.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class test {

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		getNumline(100);
		System.out.println(System.currentTimeMillis()-start+"mm");
	}
	
	public static void getNumline(int num) throws Exception{
		InputStreamReader isr = new InputStreamReader(new FileInputStream("D:/NLPIR/test/news_tensite.xml"),"utf-8");
		
		BufferedReader bufr = new BufferedReader(isr);
		String str = null;
		int i =0;
		while ((str=bufr.readLine())!=null&&i++<num) {
			System.out.println(str);
		}
		if(bufr!=null){
			bufr.close();
		}
	}
	
	public static void FileToUTF8(String code) throws Exception {
		InputStreamReader isr = new InputStreamReader(new FileInputStream("D:/NLPIR/test/news_tensite_xml.dat"), code);
		BufferedReader bufr = new BufferedReader(isr);
		BufferedWriter bufw = new BufferedWriter(new FileWriter("D:/NLPIR/test/news_tensite.xml"));
		String str = null;
		int i =0;
		while ((str=bufr.readLine())!=null) {
			bufw.write(str);
			System.out.println(++i);
		}
		bufw.flush();
		if(bufw!=null){
			bufw.close();
		}
		if(bufr!=null){
			bufr.close();
		}
	}
}
