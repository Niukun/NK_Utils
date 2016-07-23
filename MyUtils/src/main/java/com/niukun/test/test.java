package com.niukun.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.baidu.com");
		BufferedReader bufr = new BufferedReader(new InputStreamReader(
				url.openStream()));
		BufferedWriter bufw = new BufferedWriter(new FileWriter(
				"C:\\Users\\Niukun\\Desktop\\result.html"));
		String line = null;
		String str = " ";
		Pattern p = Pattern.compile("(http://www.+?)\"");
		while ((line = bufr.readLine()) != null) {
			Matcher m = p.matcher(line);
			if (m.find()) {
				str = m.group(1);
				if (str.length() > 0 && str.length() < 50) {
					bufw.write(str);
					bufw.newLine();
				}
			}
		}

		bufw.close();
		bufr.close();
		System.out.println("Finished.");
	}
}
