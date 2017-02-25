package nlpir;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

public class test1 {
	public static void main(String[] args) throws IOException {
//		File file = new File("D:/NLPIR/word2vec/class/trainnum/education/");
//		File[] files = file.listFiles();
		String name = "C:/D/NLPIR/paper/files/test/Normalize/seg/";
		File file = new File(name);
	
		System.out.println(file.mkdirs());
	}
}
