package org.acc.word2vec.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
//import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

	static String news_tensite_xml_strPath = "E:/NLPIR/sougou/news_tensite_xml/";
	static String news_sohusite_xml_strPath = "E:/NLPIR/sougou/news_sohusite_xml/";
	static BufferedWriter bufw = null;
	static String fileClass = "full";
	static BufferedWriter classbufw = null;//将所有的网站类别写入文件
	static Set<String> set = new HashSet<String>();//用来存储所有的网站类别
	static List<String> urlList = new ArrayList<String>();//存储需要过滤的url（从文件读取）

	static{
		try {
			BufferedReader bufr = new BufferedReader(new FileReader("source/ten_urls.txt"));
			String line = null;
			while((line = bufr.readLine())!=null){
				urlList.add(line);
			}
			for (int i = 0; i < urlList.size(); i++) {
				System.out.println(urlList.get(i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException, DocumentException {
		System.out.println("code start...");
//		getFormatedData(news_sohusite_xml_strPath);
//		getFormatedData(news_tensite_xml_strPath);
		
		//得到各个分类网站名称并且提取含有配置文件url的文档内容
//		getAllSURLS(news_tensite_xml_strPath);
//		getAllSURLS(news_sohusite_xml_strPath);
		
		
		classbufw = new BufferedWriter(new FileWriter(new File(news_tensite_xml_strPath + "/xml/"+fileClass+"/classes.txt")));
		XMLsToTxts(news_tensite_xml_strPath);
		Iterator setit = set.iterator();
		while(setit.hasNext()){
			classbufw.write((String)setit.next());
			classbufw.newLine();
			classbufw.flush();
		}
		classbufw.close();
		
		classbufw = new BufferedWriter(new FileWriter(new File(news_sohusite_xml_strPath + "/xml/"+fileClass+"/classes.txt")));
		XMLsToTxts(news_sohusite_xml_strPath);
		
		Iterator setit2 = set.iterator();
		while(setit2.hasNext()){
			classbufw.write((String)setit2.next());
			classbufw.newLine();
			classbufw.flush();
		}
		classbufw.close();
		
		
		System.out.println("code end ...");
	}

	public static void getAllSURLs(String path) throws IOException {
		classbufw = new BufferedWriter(new FileWriter(new File(path + "/xml/"+fileClass+"/classes.txt")));
		XMLsToTxts(path);
		Iterator setit = set.iterator();
		while(setit.hasNext()){
			classbufw.write((String)setit.next());
			classbufw.newLine();
			classbufw.flush();
		}
		classbufw.close();
	}
	
	private static void getFormatedData(String path){
	
		FilesToXMLs(path);
		System.out.println("FilesToTxt finish...");
		//会更深一层文件夹
		XMLsToTxts(path);
	}

	/**
	 * 从xml中解析出需要的内容并保存
	 * 2017/02/14
	 * @author Niukun
	 * @param path
	 */
	public static void XMLsToTxts(String path) {
		File domfile = new File(path+"xml/");
		File[] domfiles = domfile.listFiles();
		for (int i = 0; i < domfiles.length; i++) {
			if(!domfiles[i].isDirectory()){
				System.out.println(domfiles[i].getAbsolutePath()+":start");
				DOM4JXML(domfiles[i].getAbsolutePath(),path + "xml/"+fileClass+"/"+(i+1)+".txt");
				System.out.println(domfiles[i].getAbsolutePath()+":end");
			}
		}
	}

	/**
	 * 把目录下所有txt文件转换成xml文件
	 * 2017/02/14
	 * @param path
	 */
	public static void FilesToXMLs(String path) {
		File file = new File(path);
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			//不会递归处理文件夹里面的文件
			if(!files[i].isDirectory()){
				System.out.println(files[i].getAbsolutePath()+":start");
				try {
					TextToXML(files[i].getAbsolutePath(), path + "xml/"+(i+1)+".xml");
				} catch (IOException e) {
					e.printStackTrace();
				} catch (DocumentException e) {
					e.printStackTrace();
				}
				System.out.println(files[i].getAbsolutePath()+":end");
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
				
				if(book.element("url").getStringValue().contains(".cn")){
					set.add(book.element("url").getStringValue().substring(0, book.element("url").getStringValue().indexOf(".cn")+".cn".length()));
				}else if(book.element("url").getStringValue().contains(".com")){
					set.add(book.element("url").getStringValue().substring(0, book.element("url").getStringValue().indexOf(".com")+".com".length()));
				}
				
				//把url写入文件
//				bufw.write(toSemiangle(book.element("url").getStringValue()));
//				bufw.newLine();
				
				//把标题和内容写入文件
//				for (int i = 0; i < urlList.size(); i++) {
//					if(book.element("url").getStringValue().contains(urlList.get(i))){
						bufw.write(toSemiangle(book.element("contenttitle").getStringValue().trim()));
						bufw.newLine();
						bufw.write(toSemiangle(book.element("content").getStringValue().trim()));
						bufw.newLine();
						bufw.flush();
//					}
//				}
				
				//另一种用迭代器取元素的方法
//				Iterator itt = book.elementIterator();
//				while (itt.hasNext()) {
//					Element bookChild = (Element) itt.next();
////					System.out.println("节点名：" + bookChild.getName() + "--节点值：" + bookChild.getStringValue());
//					
//					for (int i = 0; i < urlList.size(); i++) {
//						if(bookChild.getStringValue().contains(urlList.get(i))){
//							if(bookChild.getName().equals("contenttitle")||bookChild.getName().equals("content")){
//								bufw.write(toSemiangle(bookChild.getStringValue()));
//								bufw.newLine();
//								bufw.flush();
//							}
//						}
//					}
//				}
			}
			bufw.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 把指定txt文件转换成指定目录下的xml文件
	 * 
	 * @param filename
	 * @param destfile
	 * @throws IOException
	 * @throws DocumentException
	 */
	private static void TextToXML(String filename, String destfile) throws IOException, DocumentException {
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
