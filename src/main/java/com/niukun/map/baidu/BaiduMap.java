package com.niukun.map.baidu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class BaiduMap {
//	private static String key = "DcrelvGvRBKGzmMCnbZKFzfAwbNv2ofx";
	private static String key = "6tbmRDwZNyBNPnWw6wFuzufb";

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 2; i++) {
			long startone = System.currentTimeMillis();
			String str = getJsonResult("兆丰世贸大厦");
			long endone = System.currentTimeMillis();
			System.out.println("第"+i+"条数据花费："+(endone-startone)+"mm");
		}
		System.out.println("查询1000条数据用时：" + (System.currentTimeMillis() - start) + "mm");
		System.out.println("平均查询1条数据用时：" + ((System.currentTimeMillis() - start)/1000) + "mm");
	}

	private static String getJsonResult(String address) throws IOException {
		StringBuilder json = new StringBuilder();
		String str = "http://api.map.baidu.com/place/v2/search?q=" + address + "&region=上海&output=json&ak=" + key;
		URL url = new URL(str);
		URLConnection yc = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		String inputLine = null;
		while ((inputLine = in.readLine()) != null) {
			json.append(inputLine);
		}
		System.out.println(json.toString());
		in.close();
		return json.toString().replaceAll(" ", "");
	}
}
