package study;

import java.io.File;
import java.io.IOException;

public class test {

	public static void main(String[] args) throws IOException {
		File file = new File("D:/NLPIR/sougou/news_sohusite_xml/xml/final/1.txt");
		System.out.println(file.getAbsolutePath());
	}
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
