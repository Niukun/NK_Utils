package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 
 * @author Niukun
 *
 */
public class FileToLine {

	public static void main(String[] args) throws IOException {
		System.out.println("Start...");
		getClassFile("C:/D/NLPIR/paper/files/test/");
		getClassFile("C:/D/NLPIR/paper/files/train/");
		System.out.println("end...");

	}
	/**
	 * 提取出改目录下所有的类别文件夹，然后以类别文件夹名称为名，以类别文件夹中的文件为行，在当前目录生成新的文件
	 * @param dataPath
	 * @throws IOException 
	 */
	public static void getClassFile(String dataPath) throws IOException{
		File file = new File(dataPath);
		File[] classFiles = file.listFiles();
		String className = "";
		for (File classFile : classFiles) {
			if(classFile.isDirectory()){
				className = classFile.getName();
				BufferedWriter bufw = new BufferedWriter(new FileWriter(new File(classFile.getParentFile().getAbsolutePath()+"/"+classFile.getName()+".txt")));
				File[] files = classFile.listFiles();
				for (File f : files) {
					bufw.write(singleFileToLine(f.getAbsoluteFile()));
					bufw.newLine();
					bufw.flush();
				}
				bufw.close();
			}
		}
	}
	
	/*
	 * 传入文件绝对路径，返回改文件的一个字符串，实现一个文件转换为一行
	 * 工具方法
	 */
	public static String singleFileToLine(File file) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader bufr = new BufferedReader(new FileReader(file));
		String line = null;
		while((line = bufr.readLine())!=null){
			sb.append(line);
		}
		return sb.toString();
	}
}
