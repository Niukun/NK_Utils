package com.niukun.fastjson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FzhongERPFile {

	public static void main(String[] args) {
		getFromPCCompany();
		getFromERPCompany();
	}

	private static void getFromERPCompany() {
		try {
			BufferedReader bufr = new BufferedReader(new FileReader("D:/NLPIR/Fenzhong/customer-data.json"));
			BufferedWriter bufw = new BufferedWriter(new FileWriter("D:/NLPIR/Fenzhong/address.txt", true));
			StringBuilder sb = new StringBuilder();
			String line = null;
			JSONObject obj = null;
			while ((line = bufr.readLine()) != null) {
				sb.append(line);
			}
			String str = null;
			str = sb.toString();

			JSONArray jsonarray = JSONObject.parseArray(str);
			for (int i = 0; i < jsonarray.size(); i++) {
				obj = (JSONObject) jsonarray.get(i);
				if (obj.getString("customeraddress") == null) {
					bufw.write("null");
					bufw.newLine();
					bufw.flush();
				} else {
					bufw.write(obj.getString("customeraddress"));
					bufw.newLine();
					bufw.flush();
				}
			}
			bufw.close();
			bufr.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}

	private static void getFromPCCompany() {
		try {
			BufferedReader bufr = new BufferedReader(new FileReader("D:/NLPIR/Fenzhong/cabia-company.txt"));
			BufferedWriter bufw = new BufferedWriter(new FileWriter("D:/NLPIR/Fenzhong/address.txt", true));
			String str = null;
			JSONObject obj = null;
			int i = 0;
			while ((str = bufr.readLine()) != null) {
				i++;
				obj = JSONObject.parseObject(str);
				if (obj.containsKey("location")) {
					System.out.println(obj.getString("location"));
					bufw.write(obj.getString("location"));
					bufw.newLine();
					bufw.flush();
					System.out.println(i + ":" + obj.getString("location"));
				}
			}
			bufw.close();
			bufr.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}

	@SuppressWarnings("unused")
	private static void testGson() {
		try {
			@SuppressWarnings("resource")
			BufferedReader bufr = new BufferedReader(new FileReader("files/kafka.json"));
			String str = bufr.readLine();
			JsonParser parser = new JsonParser();
			JsonObject obj = (JsonObject) parser.parse(str);
			System.out.println(obj.get("payload").getAsJsonObject().get("object").getAsString());

		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}

}
