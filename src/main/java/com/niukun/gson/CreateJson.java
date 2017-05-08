package com.niukun.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CreateJson {
	public static void main(String[] args) {
		JsonObject object = new JsonObject();
		object.addProperty("name", "Niukun");

		JsonArray array = new JsonArray();
		JsonObject int1 = new JsonObject();
		int1.addProperty("like", "running");
		int1.addProperty("time", "2011");
		array.add(int1);

		JsonObject int2 = new JsonObject();
		int2.addProperty("like", "reading");
		int2.addProperty("time", "2012");
		array.add(int2);

		JsonObject int3 = new JsonObject();
		int3.addProperty("like", "walking");
		int3.addProperty("time", "2013");
		array.add(int3);
		object.add("likes", array);
		
		object.addProperty("boy", true);
		
		System.out.println(object.toString());
	}
}
