package com.niukun.map.gaode;

import com.google.gson.*;
import com.niukun.file.FileUtils;
import com.sun.org.apache.bcel.internal.generic.NamedAndTyped;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GaodeMap {
	private static final String KEY = "8a3ded01ce67a8f7892211cecf0ab0ed";

	public static void main(String[] args) {

		List<String> addresses = FileUtils.getAllLinesFromFile("src\\main\\resources\\map\\address.txt");
		Gson gson = new Gson();
//
//		for (int i =0; i< addresses.size();i++){
//			String s = gson.toJson(addresses.get(i));
//			System.out.println("gson is: " + s);
//			Address address = convertStrToAddress(addresses.get(i));
//			System.out.println(address);
//		}
		String result = geoCode("https://restapi.amap.com/v3/geocode/geo?address=上海市浦东新区申城佳苑二期C块10号楼&output=json&key=" + KEY);
		System.out.println(convertStrToAddress(result));
	}


	/**
	 * 从高德地图接口中拿到的字符串 -> Address对象
	 * @param str
	 * @return
	 */
	private static Address convertStrToAddress(String str) {
		JsonParser jp = new JsonParser();
		JsonElement parse = jp.parse(str);
		JsonObject jsonObject = parse.getAsJsonObject();

		Address address = new Address();
		List<AddressDetial> addressDetialList = new ArrayList<>();
		address.setGeocodes(addressDetialList);
		address.setStatus(jsonObject.get("status").getAsInt());
		address.setInfo(jsonObject.get("info").getAsString());
		address.setInfocode(jsonObject.get("infocode").getAsInt());

		JsonArray geocodes = jsonObject.getAsJsonArray("geocodes");
		for(int i =0;i<geocodes.size();i++){
			JsonObject object = geocodes.get(i).getAsJsonObject();
			addressDetialList.add(parseAddressDetial(object));
		}

		return address;
	}

	private static AddressDetial parseAddressDetial( JsonObject object) {
		AddressDetial addressDetial = new AddressDetial();
		addressDetial.setFormatted_address(object.get("formatted_address").toString());
		addressDetial.setCountry(object.get("country").toString());
		addressDetial.setProvince(object.get("province").toString());
		addressDetial.setCitycode(object.get("citycode").getAsInt());
		addressDetial.setCity(object.get("city").toString());
		addressDetial.setDistrict(object.get("district").toString());
		addressDetial.setTownship(Arrays.asList(object.get("township").getAsJsonArray()));
		addressDetial.setNeighborhood(addressDetial.new NameAndType());
		addressDetial.setBuilding(addressDetial.new NameAndType());
		addressDetial.setAdcode(object.get("adcode").toString());
		addressDetial.setStreet(object.get("street").toString());
		addressDetial.setNumber(object.get("number").toString());
		addressDetial.setLocation(object.get("location").toString());
		addressDetial.setLevel(object.get("level").toString());
		return addressDetial;
	}

	/**
	 * 地理编码 API 服务地址
	 * https://restapi.amap.com/v3/geocode/geo?address=北京市朝阳区阜通东大街6号&output=json&key=<用户的key>
	 *
	 * @param str
	 */
	private static String geoCode(String url) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		String result = "";
		try{
			//通过默认配置创建一个httpClient实例
			httpClient = HttpClients.createDefault();
			//创建httpGet远程连接实例
			HttpGet httpGet = new HttpGet(url);
			//httpGet.addHeader("Connection", "keep-alive");
			//设置请求头信息
			httpGet.addHeader("Accept", "application/json");
			//配置请求参数
			RequestConfig requestConfig = RequestConfig.custom()
					.setConnectTimeout(35000) //设置连接主机服务超时时间
					.setConnectionRequestTimeout(35000)//设置请求超时时间
					.setSocketTimeout(60000)//设置数据读取超时时间
					.build();
			//为httpGet实例设置配置
			httpGet.setConfig(requestConfig);
			//执行get请求得到返回对象
			response = httpClient.execute(httpGet);
			//通过返回对象获取返回数据
			HttpEntity entity = response.getEntity();
			//通过EntityUtils中的toString方法将结果转换为字符串，后续根据需要处理对应的reponse code
			result = EntityUtils.toString(entity);
			System.out.println(result);

		}catch (ClientProtocolException e){
			e.printStackTrace();
		}catch (IOException ioe){
			ioe.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			//关闭资源
			if(response != null){
				try {
					response.close();
				}catch (IOException ioe){
					ioe.printStackTrace();
				}
			}
			if(httpClient != null){
				try{
					httpClient.close();
				}catch (IOException ioe){
					ioe.printStackTrace();
				}
			}
		}

		return result;
	}


	/**
	 * 逆地理编码API服务地址
	 * @param url
	 * @return
	 */
	public static String doPost(String url){
		//创建httpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String result = "";
		try{
			//创建http请求
			HttpPost httpPost = new HttpPost(url);
			httpPost.addHeader("Content-Type", "application/json");
			//创建请求内容
			String jsonStr = "{\"qry_by\":\"name\", \"name\":\"Tim\"}";
			StringEntity entity = new StringEntity(jsonStr);
			httpPost.setEntity(entity);
			response = httpClient.execute(httpPost);
			result = EntityUtils.toString(response.getEntity(),"utf-8");
			System.out.println(result);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			//关闭资源
			if(response != null){
				try {
					response.close();
				}catch (IOException ioe){
					ioe.printStackTrace();
				}
			}
			if(httpClient != null){
				try{
					httpClient.close();
				}catch (IOException ioe){
					ioe.printStackTrace();
				}
			}
		}
		return result;
	}
}
