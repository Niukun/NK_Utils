package data;

import java.io.File;

import org.acc.word2vec.util.Normalize;

public class FormatFile {

	public static void main(String[] args) throws Exception {
		getFileNormalized("C:/D/NLPIR/paper/files/test/");
//		getFileNormalized("C:/D/NLPIR/paper/files/trainnum/");
		System.out.println("end...");
	}

	private static void getFileNormalized(String dataPath) throws Exception {
		File file = new File(dataPath);
		File[] files = file.listFiles();
		for (File f : files) {
			if (!f.isDirectory()){
				Normalize.ProcessWithoutTXT(f.getAbsolutePath(),f.getParentFile()+"/Normalize/" + f.getName());
			}
		}
	}

}
