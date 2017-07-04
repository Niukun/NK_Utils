package com.niukun.crawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	// 地址
	private static final String URL = "https://tieba.baidu.com/p/5106721649";
	// 获取img标签正则
	private static final String IMGURL_REG = "src=\"(.*?jpg)\"";
	// 获取src路径的正则
	private static final String IMGSRC_REG = "[a-zA-z]+://[^\\s]*";

	public static void main(String[] args) {
		try {
			Main cm = new Main();
			// 获得html文本内容
			String HTML = cm.getHtml(URL);
			// 获取图片标签
			List<String> imgUrl = cm.getImageUrl(HTML);
			// 获取图片src地址
			System.out.println(imgUrl.size());
			List<String> imgSrc = cm.getImageSrc(imgUrl);
			System.out.println(imgSrc.size());
			// 下载图片
			cm.Download(imgSrc);

		} catch (Exception e) {
			System.out.println("发生错误");
		}

	}

	// 获取HTML内容
	private String getHtml(String url) throws Exception {
		URL url1 = new URL(url);
		URLConnection connection = url1.openConnection();
		InputStream in = connection.getInputStream();
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);

		String line;
		StringBuilder sb = new StringBuilder();
		// StringBuffer sb=new StringBuffer();
		while ((line = br.readLine()) != null) {
			sb.append(line + '\n');
//			System.out.println(line);
		}
		br.close();
		isr.close();
		in.close();
//		System.out.println(sb.toString());
		return sb.toString();
	}

	// 获取ImageUrl地址
	private List<String> getImageUrl(String html) {
		Matcher matcher = Pattern.compile(IMGURL_REG).matcher(html);
		List<String> listimgurl = new ArrayList<String>();
		while (matcher.find()) {
			listimgurl.add(matcher.group(1));
			System.out.println(matcher.group(1));
		}
		return listimgurl;
	}

	// 获取ImageSrc地址
	private List<String> getImageSrc(List<String> listimageurl) {
		List<String> listImageSrc = new ArrayList<String>();
		String str = "";
		for (String image : listimageurl) {
			Matcher matcher = Pattern.compile(IMGSRC_REG).matcher(image);
			while (matcher.find()) {
				str = matcher.group().substring(0, matcher.group().length());
				System.out.println(image + "  "+str);
				listImageSrc.add(str);
			}
		}
		return listImageSrc;
	}

	// 下载图片
	private void Download(List<String> listImgSrc) {
		try {
			// 开始时间
			Date begindate = new Date();
			for (String url : listImgSrc) {
				// 开始时间
				Date begindate2 = new Date();
				String imageName = url.substring(url.lastIndexOf("/") + 1, url.length());
				URL uri = new URL(url);
				InputStream in = uri.openStream();
				FileOutputStream fo = new FileOutputStream(new File("e:/res/" + imageName));
				byte[] buf = new byte[1024];
				int length = 0;
				System.out.println("开始下载:" + url);
				while ((length = in.read(buf, 0, buf.length)) != -1) {
					fo.write(buf, 0, length);
				}
				in.close();
				fo.close();
				System.out.println(imageName + "下载完成");
				// 结束时间
				Date overdate2 = new Date();
				double time = overdate2.getTime() - begindate2.getTime();
				System.out.println("耗时：" + time / 1000 + "s");
			}
			Date overdate = new Date();
			double time = overdate.getTime() - begindate.getTime();
			System.out.println("总耗时：" + time / 1000 + "s");
		} catch (Exception e) {
			System.out.println("下载失败");
		}
	}
}