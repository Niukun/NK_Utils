package com.niukun.crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 58同城爬虫
 * 
 * @author Niukun
 *
 */
public class JsoupDemo2 {
	private static Document doc;

	public static void main(String[] args) throws Exception {
		String pageurl = "http://image.baidu.com/search/index?tn=baiduimage&ipn=r&ct=201326592&cl=2&lm=-1&st=-1&fr=&sf=1&fmq=1461833981476_R&pv=&ic=0&nc=1&z=&se=1&showtab=0&fb=0&width=&height=&face=0&istype=2&ie=utf-8&word=%E5%A3%81%E7%BA%B8#z=0&pn=&ic=0&st=-1&face=0&s=0&lm=-1";
		getURLFromPage(pageurl);
		System.out.println("Finished.....");
	}

	private static void getURLFromPage(String pageurl) {
		try {
			doc = Jsoup.connect(pageurl).get();
			Elements links = doc.getElementsByTag("img");
			for (Element link : links) {
				String linkHref = link.attr("onclick");
				String linkText = link.text();
				System.out.println(linkHref + ":" + linkText);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
