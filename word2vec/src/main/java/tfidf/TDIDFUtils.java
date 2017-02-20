package tfidf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.acc.word2vec.util.mergeFileUtils;

import com.sun.jna.Native;

import nlpir.CLibrary;

public class TDIDFUtils {
	static List<File> fileList = new ArrayList<File>();// 用来存储指定目录下所有非目录文件

	/**
	 * TF-IDF的主要思想是： 如果某个词或短语在一篇文章中出现的频率TF高，并且在其他文章中很少出现，
	 * 则认为此词或者短语具有很好的类别区分能力，适合用来分类。
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("start");
		getIDFOfDataSet("D:/NLPIR/paper/files/trainnum", "D:/NLPIR/paper/files/directory.txt");
		mergeFiles("D:/NLPIR/paper/files/trainnum/culture");
		System.out.println("fileList size:" + fileList.size());
		System.out.println("end");
	}

	/**
	 * 1、得到文件夹目录下所有文档
	 * 
	 * @param filePath
	 *            要遍历的目录
	 * @param distFilePath
	 *            目录结构存储的文件
	 * @throws Exception
	 */
	public static void getIDFOfDataSet(String filePath, String distFilePath) throws Exception {
		File file = new File(filePath);
		File[] files = file.listFiles();
		BufferedWriter bufw = new BufferedWriter(new FileWriter(distFilePath, true));
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				getIDFOfDataSet(files[i].getAbsolutePath(), distFilePath);
				bufw.write("Directory path:" + files[i].getAbsolutePath());
				bufw.newLine();
				bufw.flush();
			} else {
				fileList.add(files[i]);
				bufw.write("\tFile path:" + files[i].getAbsolutePath());
				bufw.newLine();
				bufw.flush();
			}
		}
		bufw.close();

	}

	/**
	 * 2、合成一个大的文件，并分词，得到词库
	 * 
	 * @param files
	 */
	public static void mergeFiles(String filesPath) {
		System.out.println("mergeFiles start...");
		mergeFileUtils.filetoOne(new File(filesPath));
		System.out.println("mergeFiles end...");
		System.out.println("Segmrnt start...");
		//初始化
		CLibrary instance = (CLibrary) Native.loadLibrary(System.getProperty("user.dir") + "\\source\\NLPIR",
				CLibrary.class);
		int init_flag = instance.NLPIR_Init("", 1, "0");
		String resultString = null;
		if (0 == init_flag) {
			resultString = instance.NLPIR_GetLastErrorMsg();
			System.err.println("初始化失败！\n" + resultString);
			return;
		}
		//分词
//		double d = instance.NLPIR_FileProcess("D:/NLPIR/paper/files/bigfile.txt", "D:/NLPIR/paper/files/bigfileSegment.txt", 0);
		
		System.out.println("Segmrnt end...");
	}

	/**
	 * 3、对每一个词，统计它在各个文档中出现的频率
	 * 
	 * @param absolutePath
	 */
	public static void segmentFile(String absolutePath) {

	}

	/**
	 * 
	 * 4、得到并保存idf值
	 * 
	 * @param dictonary
	 * @param filePath
	 */
	public static void calcIDF(String dictonary, String filePath) {

	}

}
