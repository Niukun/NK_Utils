package com.niukun.crawler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class PostURL {
	public static void main(String[] args) throws Exception {
		String url = "http://59.78.100.126:8081/cabia-service/ws/test/entityaddress/fuzzy";
		List<NameValuePair> formParams = new ArrayList<NameValuePair>();
		formParams.add(new BasicNameValuePair("entityName", "银行"));
		formParams.add(new BasicNameValuePair("classId", "2"));
		formParams.add(new BasicNameValuePair("limit", "5"));
		formParams.add(new BasicNameValuePair("offset", "0"));
		System.out.println(getPostResultByFormParams(url, formParams));
	}
	public static String getPostResultByFormParams(String url,
			List<NameValuePair> formParams) {
		String body = "";
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		UrlEncodedFormEntity entity = null;
		try {
			entity = new UrlEncodedFormEntity(formParams, "utf-8");
			post.setEntity(entity);
			HttpResponse response = client.execute(post);
			HttpEntity result = response.getEntity();
			body = EntityUtils.toString(result, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return body;
	}

}
