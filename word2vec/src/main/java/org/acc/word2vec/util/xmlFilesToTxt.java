package org.acc.word2vec.util;

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

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 把已经切分好的小文件转换成xml格式存入传入目录下的xml目录中，然后抽取出其中内容存入传入目录下xml/final目录中
 * @author Niukun
 *
 */
public class xmlFilesToTxt {

	static String news_tensite_xml_strPath = "D:/NLPIR/sougou/news_tensite_xml/";
	static String news_sohusite_xml_strPath = "D:/NLPIR/sougou/news_sohusite_xml/";
	static BufferedWriter bufw = null;

	public static void main(String[] args) throws IOException, DocumentException {
		System.out.println("code start...");
		getFormatedData(news_sohusite_xml_strPath);
		
		getFormatedData(news_tensite_xml_strPath);
		
		System.out.println("code end ...");
	}

	private static void getFormatedData(String filename){
	
		File file = new File(filename);
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			if(!files[i].isDirectory()){
				System.out.println(files[i].getAbsolutePath()+":start");
				try {
					showText(files[i].getAbsolutePath(), filename + "xml/"+(i+1)+".xml");
				} catch (IOException e) {
					e.printStackTrace();
				} catch (DocumentException e) {
					e.printStackTrace();
				}
				System.out.println(files[i].getAbsolutePath()+":end");
			}
		}
		
		System.out.println("showText finish...");
		
		
		File domfile = new File(filename+"xml/");
		File[] domfiles = domfile.listFiles();
		for (int i = 0; i < domfiles.length; i++) {
			if(!domfiles[i].isDirectory()){
				System.out.println(domfiles[i].getAbsolutePath()+":start");
				DOM4JXML(domfiles[i].getAbsolutePath(),filename + "xml/final/"+(i+1)+".txt");
				System.out.println(domfiles[i].getAbsolutePath()+":end");
			}
		}
	}
	
	
	private static void DOM4JXML(String filename, String destfile) {
		// 创建SAXReader的对象reader
		SAXReader reader = new SAXReader();
		try {
			// 通过reader对象的read方法加载books.xml文件,获取docuemnt对象。
			Document document = reader.read(new File(filename));
			// 通过document对象获取根节点bookstore
			Element bookStore = document.getRootElement();
			// 通过element对象的elementIterator方法获取迭代器
			Iterator it = bookStore.elementIterator();
			// 遍历迭代器，获取根节点中的信息（书籍）,并保存
			bufw = new BufferedWriter(new FileWriter(new File(destfile)));
			 
			while (it.hasNext()) {
				Element book = (Element) it.next();
				// 获取book的属性名以及 属性值
//				List<Attribute> bookAttrs = book.attributes();
//				for (Attribute attr : bookAttrs) {
//					System.out.println("属性名：" + attr.getName() + "--属性值：" + attr.getValue());
//				}
				Iterator itt = book.elementIterator();
				while (itt.hasNext()) {
					Element bookChild = (Element) itt.next();
//					System.out.println("节点名：" + bookChild.getName() + "--节点值：" + bookChild.getStringValue());
					if(bookChild.getName().equals("contenttitle")||bookChild.getName().equals("content")){
						bufw.write(toSemiangle(bookChild.getStringValue()));
						bufw.newLine();
						bufw.flush();
					}
				}
			}
			bufw.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 把指定txt文件转换成制定目录下的xml文件
	 * 
	 * @param filename
	 * @param destfile
	 * @throws IOException
	 * @throws DocumentException
	 */
	private static void showText(String filename, String destfile) throws IOException, DocumentException {
		FileInputStream is = new FileInputStream(new File(filename));
		InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
		BufferedReader bufr = new BufferedReader(isr);
		BufferedWriter bufw = new BufferedWriter(new FileWriter(new File(destfile)));
		String line = null;
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version='1.0' encoding='UTF-8'?>\n<docs>");
		while ((line = bufr.readLine()) != null) {
			sb.append("\n" + line.replace("&", ""));
		}
		sb.append("\n</docs>");
		bufw.write(sb.toString());
		bufw.newLine();
		bufw.flush();
		bufw.close();

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
	
	/**
	 * 全角转半角
	 * @param src
	 * @return
	 */
	public static String toSemiangle(String src) {
        char[] c = src.toCharArray();
        for (int index = 0; index < c.length; index++) {
            if (c[index] == 12288) {// 全角空格
                c[index] = (char) 32;
            } else if (c[index] > 65280 && c[index] < 65375) {// 其他全角字符
                c[index] = (char) (c[index] - 65248);
            }
        }
        return String.valueOf(c);
    }
}
