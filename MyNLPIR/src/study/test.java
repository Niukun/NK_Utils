package study;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class test {

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufw = new BufferedWriter(new FileWriter("D:/Data/eclipse/Niukun/MyNLPIR/test.txt"));
		File file = new File("D:/Data/eclipse/Niukun/MyNLPIR/");
		if(file.exists()){
			System.out.println(file.getAbsolutePath());
			System.out.println(file.getParent());
			System.out.println("文件已经存在");
		}else{
			System.out.println("文件不存在");
		}
	}
}
