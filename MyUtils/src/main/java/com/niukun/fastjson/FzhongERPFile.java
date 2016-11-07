package com.niukun.fastjson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FzhongERPFile {

	public static void main(String[] args) {
		testFastJson();
	}

	private static void testFastJson() {
		try {
			BufferedReader bufr = new BufferedReader(new FileReader("D:/NLPIR/Fenzhong/cabia-building.txt"));
			String str = null;
			JSONObject obj = null;
			int i = 0;
			while ((str = bufr.readLine()) != null) {
				i++;
				obj = JSONObject.parseObject(str);
				System.out.println(i + ":" + obj.getString("update_time"));
			}

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
