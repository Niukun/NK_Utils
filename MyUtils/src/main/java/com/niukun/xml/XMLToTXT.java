package com.niukun.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLToTXT {
	private static final String LINE_SEPARATOR = System
			.getProperty("line.separator");

	public static void main(String[] args) {
		// getAll();
		getSomeOfThem();
	}

	public static void getSomeOfThem() {
		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("E:/files/NLPIR.xml"));
			Element root = document.getDocumentElement();
			NodeList list = root.getElementsByTagName("RECORD");
			File file = null;
			PrintWriter fw = null;
			file = new File("E:/files/The000.txt");
			fw = new PrintWriter(file);
			System.out.println(list.getLength());
			for (int i = 0; i < list.getLength(); i++) {
				Element node = (Element) list.item(i);
				Element id = (Element) node.getElementsByTagName("id").item(0);
				// System.out.println(id.getTextContent());
				Element article = (Element) node
						.getElementsByTagName("article").item(0);
				// System.out.println(article.getTextContent());
				fw.write(id.getTextContent() + article.getTextContent()
						+ LINE_SEPARATOR);
				fw.flush();
			}
			System.out.println("==============");
			fw.close();

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getAll() {
		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("E:/files/12.xml"));
			Element root = document.getDocumentElement();
			NodeList list = root.getElementsByTagName("RECORD");
			for (int i = 0; i < list.getLength(); i++) {
				Element node = (Element) list.item(i);
				System.out.println("==============");
				NodeList childlist = node.getChildNodes();
				for (int j = 0; j < childlist.getLength(); j++) {
					Node c = childlist.item(j);
					if (c instanceof Element) {
						System.out.println(c.getNodeName() + "+"
								+ c.getTextContent());
					}
				}
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}