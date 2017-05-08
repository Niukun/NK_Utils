package com.niukun.crawler;

import java.io.IOException;

import org.apache.http.client.HttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 58同城爬虫
 * 
 * @author Niukun
 *
 */
public class JsoupDemo2 {
	private static Document doc;

	public static void main(String[] args) throws Exception {
		String[] cities = { "上海", "北京", "天津" };
		String url = null;
		for (int i = 0; i < cities.length; i++) {
			url = "https://zh.wikipedia.org/wiki/" + cities[i];
//			getURLFromPage(url);
			System.out.println(url);
		}
	}

	private static void getURLFromPage(String pageurl) {
		try {
			doc = Jsoup.connect(pageurl).data("query", "Java")
					  .userAgent("Mozilla")
					  .cookie("auth", "token")
					  .timeout(3000)
					  .get();
			String page = doc.html();
			System.out.println(page);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
