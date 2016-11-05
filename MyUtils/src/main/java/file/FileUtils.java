package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class FileUtils {
	public static void main(String[] args) throws UnsupportedEncodingException, Exception {
		FileSplit("D:/NLPIR/test/news_tensite.xml",100);
	}

	private static void FileSplit(String file,int filenumb) throws UnsupportedEncodingException, Exception {
		InputStreamReader isr = new InputStreamReader(new FileInputStream("D:/NLPIR/test/news_tensite_xml.dat"),"gbk");
		BufferedReader bufr = new BufferedReader(isr);
		int num = 0;
		String str = null;
		while((str=bufr.readLine())!=null){
			num++;
		}
		System.out.println(num);
		int singlefilenum = num/filenumb;
		BufferedReader bufrtem = new BufferedReader(new InputStreamReader(new FileInputStream("D:/NLPIR/test/news_tensite_xml.dat"),"gbk"));
		int count = 0;
		for (int i = 0; i < filenumb-1; i++) {
			BufferedWriter bufw = new BufferedWriter(new FileWriter("D:/NLPIR/test/news_tensite_xml/"+i+".txt"));
			while((str=bufrtem.readLine())!=null&&((count++)<singlefilenum*i)){
				bufw.write(str);
			}
			bufw.flush();
			if(bufw!=null){
				bufw.close();
			}
		}
	}

}
