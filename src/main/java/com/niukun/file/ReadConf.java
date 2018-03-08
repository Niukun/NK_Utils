package com.niukun.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用文件流读取、设置配置文件
 * @author Niukun
 *
 */
public class ReadConf {
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();// 属性集合对象
		FileInputStream fis = new FileInputStream("files/file.properties");// 属性文件流
		prop.load(fis);// 将属性文件流装载到Properties对象中
		// //获取属性值，sitename已在文件中定义
		System.out.println("获取属性值：name=" + prop.getProperty("name"));
		// 修改sitename的属性值
		// prop.setProperty("name", "NIUKUN");
		// 添加一个新的属性studio
		prop.setProperty("studio", "Boxcode Studio");
		// 文件输出流
		FileOutputStream fos = new FileOutputStream("files/fileniu.properties");
		// 将Properties集合保存到流中
		prop.store(fos, "Copyright (c) Boxcode Studio");
		fos.close();// 关闭流
	}
}
