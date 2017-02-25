package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class keyWords {
	private static List<String> allDocuments = new ArrayList<String>();
	private static BufferedWriter bufw ;
	static{
		try {
			bufw = new BufferedWriter(new FileWriter(new File("C:/D/NLPIR/paper/files/idf.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		List<String> dataPaths = new ArrayList<String>();
		dataPaths.add("C:/D/NLPIR/paper/files/test/Normalize/seg/");
//		dataPaths.add("C:/D/NLPIR/paper/files/train/Normalize/seg/");
		getIDFSaved(dataPaths);
	}
	private static void getIDFSaved(List<String> dataPaths) throws Exception {
		String line = null;
		int count =0;
		for (String dataPath : dataPaths) {
			File file = new File(dataPath);
			System.out.println(file.getAbsolutePath());
			File[] files = file.listFiles();
			System.out.println(files.length);
			for (File f : files) {
				if(!f.isDirectory()){
					BufferedReader bufr = new BufferedReader(new FileReader(f));
					while((line=bufr.readLine())!=null){
						allDocuments.add(line);
						count++;
					}
				}
			}
		}
		System.out.println("count is : " + count);
		System.out.println("allDocuments is prepared,size is : " + allDocuments.size());
	}

}
