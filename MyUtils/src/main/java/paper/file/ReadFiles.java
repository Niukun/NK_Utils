package paper.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
//import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

public class ReadFiles {

	static String strPath = "src/main/resources/testfiles/";
	static BufferedWriter bufw = null;

	public static void main(String[] args) throws IOException, DocumentException {
		File file = new File("src/main/resources/testfiles");
		// showFileAndDocs(file);
		// showFileAndDocs();
		// createFilesInPath(file,50);
		
		showText(strPath + "news_sohusite_xml.smarty.dat");
		System.out.println("The end ...");
	}

	private static void printXML(String string) throws DocumentException {
		Document document = DocumentHelper.parseText(string);
		Element root = document.getRootElement();

		int count = 0;
		Iterator it = root.elementIterator();
		Iterator iter;
		Element element;
		Attribute attribute;
		Node node;
		String contenttitle,content;
		while (it.hasNext()) {
			element = (Element) it.next();
//			node = element.node(1);//url
//			node = element.node(3);//docno
//			node = element.node(5);//contenttitle
//			node = element.node(7);//content
			contenttitle = element.node(5).getStringValue();
			content = element.node(7).getStringValue();
			try {
				bufw = new BufferedWriter(new FileWriter(new File("src/main/resources/testfiles/"+contenttitle+".txt")));
				bufw.write(content);
				bufw.flush();
				bufw.close();
				System.out.println(count+++"finished....");
			} catch (IOException e) {
				System.out.println("读取出错...");
			}
			
		}
	}

	private static void showText(String filename) throws IOException, DocumentException {
		FileInputStream is = new FileInputStream(new File(filename));
		InputStreamReader isr = new InputStreamReader(is, Charset.forName("GBK"));
		BufferedReader bufr = new BufferedReader(isr);
		BufferedWriter bufw = new BufferedWriter(new FileWriter(new File(strPath + "res.xml")));
		String line = null;
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version='1.0' encoding='UTF-8'?>\n<docs>");
		while ((line = bufr.readLine()) != null) {
			sb.append("\n" + line);
		}
		sb.append("\n</docs>");
		bufw.write(sb.toString());
		bufw.newLine();
		bufw.flush();
		bufw.close();

		File inputXml = new File("D:/Data/eclipse/Niukun/MyUtils/src/main/resources/testfiles/res.txt");

		printXML(sb.toString().replace("&a", ""));

	}

	/**
	 * 在指定目录下创建指定数量的文件
	 * 
	 * @param file
	 *            指定目录
	 * @param i
	 *            指定数量
	 * @throws IOException
	 */
	private static void createFilesInPath(File file, int filenumber) throws IOException {
		BufferedWriter bufw = null;
		for (int i = 0; i < filenumber; i++) {
			bufw = new BufferedWriter(new FileWriter(new File(file.getAbsolutePath() + "/" + i + ".txt")));
			bufw.write("It is the number " + i + " file you have write...");
			bufw.flush();
			bufw.close();
		}
	}


	/**
	 * 
	 * 得到一个目录下所有目录和文件信息
	 * 
	 * @param file
	 */
	private static void showFileAndDocs(File file) {
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (!files[i].isDirectory()) {
				System.out.println(files[i].getAbsolutePath());
			} else {
				showFileAndDocs(files[i]);
			}
		}
	}
}
