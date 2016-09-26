package com.niukun.list;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.alibaba.fastjson.JSONObject;

public class List {

	public static void main(String[] args) throws Exception {
		BufferedReader bufr = new BufferedReader(new FileReader("fmproject.json"));
		ArrayList<String> list = new ArrayList<String>();
		String line;
		/*while((line=bufr.readLine())!=null){
			list.add(line);
			JSONObject obj = JSONObject.parseObject(line);
//			System.out.println(obj.getString("buildingnme"));
		}*/
		list.add("123");
		list.add("123");
		list.add("123");
		list.add("123");
		System.out.println(list.size());
		list.addAll(getList());
		System.out.println(list.size());
	}
	private static ArrayList<String> getList(){
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("456");
		list2.add("567");
		return list2;
	}
}
