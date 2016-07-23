package com.niukun.gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class ReadJson {

	public static void main(String[] args) {
		try {

			JsonParser parser = new JsonParser();
			JsonObject object = (JsonObject) parser.parse(new FileReader("files/test.json"));
			System.out.println("name = " + object.get("name").getAsString());

			JsonArray array = object.get("likes").getAsJsonArray();
			for (int i = 0; i < array.size(); i++) {
				System.out.println("-------------");
				JsonObject subobject = array.get(i).getAsJsonObject();
				System.out.println("like = " + subobject.get("like").getAsString());
				System.out.println("time = " + subobject.get("time").getAsString());
			}
			System.out.println("boy = " + object.get("boy").getAsBoolean());
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
