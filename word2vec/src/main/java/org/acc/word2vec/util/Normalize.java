package org.acc.word2vec.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Normalize {
	private static List<String> signList = new ArrayList<String>();
	public static void main(String[] args) throws Exception {
//		System.out.println("start");
//		Process("D:/NLPIR/sougou/big/0214/0214_sougou_bigfile");
//		System.out.println("end");
	}
	
	static{
		//加载stopSign文件，得到一个list
		try {
			BufferedReader signBufr = new BufferedReader(new FileReader("source/stopSigns"));
			Set<String> signSet = new HashSet<String>();
			String signStr = "";
			int num = 0;
			while((signStr = signBufr.readLine())!=null){
				signSet.add(signStr);
				num++;
			}
			Iterator iter = signSet.iterator();
			while(iter.hasNext()){
				signStr = (String) iter.next();
				signList.add( signStr );
			}
			System.out.println("stopSign长度：" + num);
			System.out.println("signList长度：" + signList.size());
			
			
		} catch (Exception e) {
			System.out.println("stopSign配置文件加载出错。。。");
			e.printStackTrace();
		}
	}

	/**
	 * 精确到文件名，但是不带后缀
	 * @param pathWithFileName
	 * @throws Exception
	 */
	public static void Process(String pathWithFileName) throws Exception {
		BufferedReader bufr = new BufferedReader(new FileReader(pathWithFileName + ".txt"));
		BufferedWriter bufw = new BufferedWriter(new FileWriter(pathWithFileName + "Normalized.txt"));
		Set<String> strSet = new TreeSet<String>();
		
		String str = "";
		while((str=bufr.readLine())!=null){
			for (int i = 0; i < signList.size(); i++) {
				str = str.replace(signList.get(i), " ");
			}
			str = str.replaceAll("[a-zA-Z]{1,2}", " ");
			str = str.replaceAll("[0-9]{1,40}", " ");
			str = str.replaceAll(" 年", " ");
			str = str.replaceAll(" 月", " ");
			str = str.replaceAll(" 日", " ");
			str = str.replaceAll(" 转", " ");
			while(str.contains("  ")){
				str = str.replace("  ", " ");
			}
			str = str.replaceAll("\t", " ");
			str = str.toLowerCase();
			strSet.add(str.trim());
		}
		Iterator iter = strSet.iterator();
		while(iter.hasNext()){
			bufw.write((String)iter.next());
			bufw.newLine();
			bufw.flush();
		}
		
		bufw.close();
		bufr.close();
	}
	/**
	 * 精确到文件名，但是不带后缀
	 * @param pathWithFileName
	 * @throws Exception
	 */
	public static void ProcessWithoutTXT(String fileName,String distFileName) throws Exception {
		BufferedReader bufr = new BufferedReader(new FileReader(fileName));
		BufferedWriter bufw = new BufferedWriter(new FileWriter(distFileName));
		Set<String> strSet = new TreeSet<String>();
		
		String str = "";
		while((str=bufr.readLine())!=null){
			for (int i = 0; i < signList.size(); i++) {
				str = str.replace(signList.get(i), " ");
			}
//			str = str.replaceAll("[a-zA-Z]{1,2}", " ");
//			str = str.replaceAll("[0-9]{1,40}", " ");
			str = str.replaceAll("，", ",");
//			str = str.replaceAll(" 月", " ");
//			str = str.replaceAll(" 日", " ");
//			str = str.replaceAll(" 转", " ");
			while(str.contains("　")){
				str = str.replace("　", "");
			}
			while(str.contains("  ")){
				str = str.replace("  ", " ");
			}
			str = str.replaceAll("\t", " ");
			str = str.toLowerCase();
			strSet.add(str.trim());
		}
		Iterator iter = strSet.iterator();
		while(iter.hasNext()){
			bufw.write((String)iter.next());
			bufw.newLine();
			bufw.flush();
		}
		
		bufw.close();
		bufr.close();
	}

}
