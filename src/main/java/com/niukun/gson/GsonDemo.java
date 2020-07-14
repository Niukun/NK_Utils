package com.niukun.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GsonDemo {
    public static void main(String[] args) {
        String str = "{\"status\":\"1\",\"info\":\"OK\",\"infocode\":\"10000\",\"count\":\"1\",\"geocodes\":[{\"formatted_address\":\"北京市朝阳区阜通东大街|6号\",\"country\":\"中国\",\"province\":\"北京市\",\"citycode\":\"010\",\"city\":\"北京市\",\"district\":\"朝阳区\",\"township\":[],\"neighborhood\":{\"name\":[],\"type\":[]},\"building\":{\"name\":[],\"type\":[]},\"adcode\":\"110105\",\"street\":\"阜通东大街\",\"number\":\"6号\",\"location\":\"116.483038,39.990633\",\"level\":\"门牌号\"}]}\n";
        JsonParser jp = new JsonParser();
        JsonElement parse = jp.parse(str);
        JsonObject asJsonObject = parse.getAsJsonObject();
        JsonArray geocodes = asJsonObject.getAsJsonArray("geocodes");
        for(int i = 0; i< geocodes.size();i++){
            parseGeo((JsonObject) geocodes.get(i));
        }

//        System.out.println(geocodes);
//        System.out.println(parse);
    }

    private static void parseGeo(JsonObject jsonElement) {

        System.out.println(jsonElement.get("formatted_address"));
        System.out.println(jsonElement.get("country"));
        System.out.println(jsonElement.get("province"));
        System.out.println(jsonElement.get("citycode"));
        System.out.println(jsonElement.get("district"));
        System.out.println(jsonElement.get("street"));
        System.out.println(jsonElement.get("level"));
        System.out.println(jsonElement.get("number"));
        System.out.println(jsonElement.get("location"));
    }
}
