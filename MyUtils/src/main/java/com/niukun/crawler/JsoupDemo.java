package com.niukun.crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupDemo {

	public static void main(String[] args) {
		getURLs();
	}

	private static void getURLs() {
		Document doc;
		try {
			doc = Jsoup.connect("http://www.baidu.com").get();
			Element content = doc.getElementById("head");
			System.out.println(content.toString());
			Elements links = content.getElementsByTag("a");
			for (Element link : links) {
				String linkHref = link.attr("href");
				String linkText = link.text();
				System.out.println(linkHref+":"+linkText);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
