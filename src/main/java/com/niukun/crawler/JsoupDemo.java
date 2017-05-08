package com.niukun.crawler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
public class JsoupDemo {
	private static List<String> urllist = new ArrayList<String>();
	private static Map<String,String> map = new TreeMap<String,String>();
	private static BufferedWriter bufw = null;
	private static Document doc;

	public static void main(String[] args) throws Exception {
		bufw = new BufferedWriter(new FileWriter("files/page.txt"));
		String urlfront = "http://sh.58.com/zhaozu/pn";
		String urltail = "/?utm_source=market&spm=b-31580022738699-me-f-824.bdpz_biaoti&PGTID=0d30000d-0000-2d0e-9866-8c48539ae76a&ClickID=1";
		int pageNum = 70;
		for (int i = 1; i <= pageNum; i++) {
			String pageurl = urlfront + i + urltail;
			getURLFromPage(pageurl);
			System.out.println("第" + i + "个页面爬取完毕;");
		}
		for (int i = 0; i < urllist.size(); i++) {
			getInfoFromURL(urllist.get(i));
			System.out.println(urllist.size()+":第"+i+"个网页数据");
		}
		Set<String> set = map.keySet();
		Iterator<String> setIter = set.iterator();
		String key;
		while(setIter.hasNext()){
			key = (String) setIter.next();
			bufw.write(map.get(key));
			bufw.newLine();
		}
		System.out.println("Finished.....");
		bufw.close();
	}

	private static void getInfoFromURL(String url) {
		StringBuilder sb = new StringBuilder();
		try {
			doc = Jsoup.connect(url).get();
			Elements links = doc.getElementsByClass("info");
//			System.out.println(links);
			for (Element link : links) {
				Elements lis = link.getElementsByTag("li");
				for (Element li : lis) {
					sb.append(li.text()+"\t");
				}
				map.put(url, sb.toString().replace("轻松买铺，贷来财富", ""));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void getURLFromPage(String pageurl) {
		try {
			doc = Jsoup.connect(pageurl).get();
			Elements links = doc.getElementsByClass("t");
			for (Element link : links) {
				String linkHref = link.attr("href");
				if (linkHref != "") {
					urllist.add(linkHref);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
