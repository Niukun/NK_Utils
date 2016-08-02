package com.niukun.fastjson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class fastJsonDemo {

	public static void main(String[] args) {
		testFastJson();
//		testGson();
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

	private static void testFastJson() {
		try {
			@SuppressWarnings("resource")
			BufferedReader bufr = new BufferedReader(new FileReader("files/kafka.json"));
			String str = bufr.readLine();
			JSONObject obj = JSONObject.parseObject(str);
			System.out.println(obj.getJSONObject("schema").getString("name"));
			JSONObject object = JSONObject.parseObject(obj.getJSONObject("payload").getString("object"));
			System.out.println(obj.getJSONObject("payload").getString("object"));
			System.out.println(object.getString("company_name"));
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}
}
