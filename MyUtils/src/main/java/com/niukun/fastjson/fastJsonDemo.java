package com.niukun.fastjson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class fastJsonDemo {

	public static void main(String[] args) throws Exception {
//		testFastJson();
// 		testGson();
		removeAttr();
//		hasAttrNum();
//		JsonArrayTest();
//		createJson();
		
	}

	private static void createJson() {
		String str = "info";
		JSONObject jo = new JSONObject();
		jo.put("key", str);
		System.out.println(jo.toJSONString());
	}

	private static void JsonArrayTest() throws Exception {
		BufferedReader bufr = new BufferedReader(new FileReader("D:/NLPIR/Fenzhong/customer-data.json"));
		StringBuffer sb = new StringBuffer();
		String line = null;
		while((line=bufr.readLine())!=null){
			sb.append(line);
		}
		
		String str = sb.toString().replaceAll("  ", "").replaceAll("\t", "");
		System.out.println(str);
		JSONArray objarr = JSONObject.parseArray(str);
		System.out.println(objarr.get(1));
	}

	private static void hasAttrNum() {
		String str = "{age:12,phone:123123,industry:\"[电子技术:半导体]\"}";
		JSONObject obj = JSONObject.parseObject(str);
//		obj.remove("age");
		System.out.println(obj.getString("industry"));
		
	}

	private static void removeAttr() {
		String str = "{age:12,phone:123123}";
		JSONObject obj = JSONObject.parseObject(str);
		obj.remove("name");
		System.out.println(obj.toJSONString());
	}

	private static void testFastJson() {
		try {
			@SuppressWarnings("resource")
			BufferedReader bufr = new BufferedReader(new FileReader("files/kafka.json"));
			String str = bufr.readLine();
			
			JSONObject obj = JSONObject.parseObject(str);
			System.out.println(obj.getJSONObject("schema").getString("name"));
			
									System.out.println(obj.getJSONObject("payload").getString("object"));
			JSONObject object = JSONObject.parseObject(obj.getJSONObject("payload").getString("object"));
			
			System.out.println(object.getString("company_name"));
			JSONObject timeobj = JSONObject.parseObject(object.getString("update_time"));
			System.out.println(timeobj.getLongValue("$numberLong"));
			Long time = timeobj.getLongValue("$numberLong");
			Date date = new Date(time);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy--MM--dd");
			System.out.println(sdf.format(date));
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
