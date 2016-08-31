package com.niukun.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) throws Exception {
		BufferedReader bufr = new BufferedReader(new FileReader("files/firstmap.txt"));
		List<String> addressList = new ArrayList<String>();
		List<String> type = new ArrayList<String>();
		List<String> resultList = new ArrayList<String>();
		String line;
		int baidu = 0;
		int gaode = 0;
		int baidunull = 0;
		int gaodenull = 0;
		while ((line = bufr.readLine()) != null) {
			String[] resu = line.split("\t");
			addressList.add(resu[0]);
			type.add(resu[1]);

			if (resu.length == 3) {
				resultList.add(resu[2]);
			} else if (resu.length == 2) {
				if (resu[1].contains("baidu")) {
					baidunull++;
				} else {
					gaodenull++;
				}
			}
		}
		for (int i = 0; i < type.size(); i++) {
			if (type.get(i).equals("baidu:")) {
				baidu++;
			} else if (type.get(i).equals("gaode:")) {
				gaode++;
			}
		}
		System.out.println("经过地图查询的条数:" + addressList.size());
		System.out.println("经由gaode查询的数量:" + gaode);
		System.out.println("经由baidu查询的数量:" + baidu);
		// System.out.println("baidu + gaode = " + (baidu + gaode));
		System.out.println("经由gaode查询，无结果数量：" + gaodenull);
		System.out.println("经由baidu查询，无结果数量：" + baidunull);
		System.out.println("经过地图最终有结果的数量:" + resultList.size());
		if(gaodenull+baidunull+resultList.size()==addressList.size()){
			System.out.println(true);
		}
	}
}
