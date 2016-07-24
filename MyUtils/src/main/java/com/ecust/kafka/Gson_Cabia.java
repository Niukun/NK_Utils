package com.ecust.kafka;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Gson_Cabia {

	public static void main(String[] args) throws IOException {
		JsonParser parser = new JsonParser();
		
		JsonObject object = (JsonObject) parser.parse(new FileReader("files/kafka.json"));
		System.out.println("payload = " + object.get("payload").getAsJsonObject().get("object").getAsString());
	}

}
