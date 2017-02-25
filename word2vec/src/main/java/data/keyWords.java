package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import tfidf.src.org.akgul.MutableInt;
import tfidf.src.org.akgul.TfIdf;

public class keyWords {
	private static List<String> allDocuments = new ArrayList<String>();
	private static BufferedWriter bufwidf;
	private static BufferedWriter bufwtf;
	private static Map<String, Double> idfmap;
	private static Map<String, MutableInt> tfmap ;
	
	public static Map<String, Double> getIdfmap() {
		return idfmap;
	}

	public static Map<String, MutableInt> getTfmap() {
		return tfmap;
	}

	static {
		try {
			bufwidf = new BufferedWriter(new FileWriter(new File("C:/D/NLPIR/paper/files/idf.txt")));
			bufwtf = new BufferedWriter(new FileWriter(new File("C:/D/NLPIR/paper/files/tf.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> dataPaths = new ArrayList<String>();
		dataPaths.add("C:/D/NLPIR/paper/files/test/Normalize/seg/");
		dataPaths.add("C:/D/NLPIR/paper/files/train/Normalize/seg/");
		System.out.println("get allDocuments...");
		try {
			getAllDocuments(dataPaths);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {

		System.out.println("save allDocuments...");
		saveDocs();

		 System.out.println("IDF Save...");
		 getSortedIDFSave();

		System.out.println("TF Save...");
		getSortedTFIDFSave(allDocuments.get(3) ,15);

		System.out.println("end...");

	}

	private static void getSortedTFIDFSave(int wordsNum) throws IOException {
		TfIdf tfIdf = new TfIdf(allDocuments);

		for (int i = 0; i < allDocuments.size(); i++) {
			Map<String, MutableInt> map = tfIdf.tf(allDocuments.get(i));
			Set<String> keyWords = map.keySet();
			Iterator iter = keyWords.iterator();
			Map<String, Double> tfidfmap = new HashMap<String, Double>();
			// 先得到tfidf的map数据
			String key = null;
			double idf = 0;
			int value = 0;
			while (iter.hasNext()) {
				key = (String) iter.next();
				if (idfmap.containsKey(key)) {
					idf = idfmap.get(key);
					value = map.get(key).getCounter();
					// System.out.println(key + ":" + (value * idf) + "\t");
					tfidfmap.put(key, (value * idf));
				}
			}

			// 按照value大小排序
			List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(tfidfmap.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
				// 降序排序
				public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
					return o2.getValue().compareTo(o1.getValue());
				}

			});
			int num = 0;
			for (Map.Entry<String, Double> mapping : list) {
				if (num++ < wordsNum) {
					bufwtf.write(mapping.getKey() + ":" + mapping.getValue());
					bufwtf.newLine();
					bufwtf.flush();
				}
			}
			bufwtf.write("---------------------------");
			bufwtf.newLine();
		}
	}

	/**
	 * 重载
	 * 
	 * @param document
	 * @param wordsNum
	 * @throws IOException
	 */
	public static String[] getSortedTFIDFSave(String document, int wordsNum) throws IOException {
		TfIdf tfIdf = new TfIdf(allDocuments);
		String[] strs = new String[wordsNum];
		tfmap = tfIdf.tf(document);
		Set<String> keyWords = tfmap.keySet();
		Iterator iter = keyWords.iterator();
		
		Map<String, Double> tfidfmap = new HashMap<String, Double>();
		// 先得到tfidf的map数据
		String key = null;
		double idf = 0;
		int value = 0;
		while (iter.hasNext()) {
			key = (String) iter.next();
			if (idfmap.containsKey(key)) {
				idf = idfmap.get(key);
				value = tfmap.get(key).getCounter();
				tfidfmap.put(key, (value * idf));
			}
		}

		// 按照value大小排序
		List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(tfidfmap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			// 降序排序
			public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}

		});
		int num = 0;
		for (Map.Entry<String, Double> mapping : list) {
			if (num++ < wordsNum) {
				strs[num-1] = mapping.getKey();
				bufwtf.write(mapping.getKey() + ":" + mapping.getValue());
				bufwtf.newLine();
				bufwtf.flush();
			}
		}
		bufwtf.write("---------------------------");
		bufwtf.newLine();
		return strs;
	}

	private static void saveDocs() throws IOException {
		BufferedWriter bu = new BufferedWriter(new FileWriter(new File("C:/D/NLPIR/paper/files/doc.txt")));
		Iterator iter = allDocuments.iterator();
		while (iter.hasNext()) {
			bu.write((String) iter.next());
			bu.newLine();
			bu.flush();
		}
	}

	/**
	 * 含有map按照value排序：http://www.cnblogs.com/hxsyl/p/3331095.html
	 * 
	 * @throws IOException
	 */
	public static void getSortedIDFSave() throws IOException {
		TfIdf tfIdf = new TfIdf(allDocuments);
		idfmap = tfIdf.idf();
		// Set<String> keyWords = idfmap.keySet();
		// Iterator iter = keyWords.iterator();

		// 按照value大小排序
		List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(idfmap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			// 升序排序
			public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}

		});
		for (Map.Entry<String, Double> mapping : list) {
			bufwidf.write(mapping.getKey() + ":" + mapping.getValue());
			bufwidf.newLine();
			bufwidf.flush();
		}

		// 不按照value大小排序
		// String key = null;
		// double score = 0;
		// while(iter.hasNext()){
		// key = (String) iter.next();
		// score = map.get(key);
		// System.out.println(key + "\t" + score);
		// bufw.write(key + "\t" + score);
		// bufw.newLine();
		// bufw.flush();
		// }
	}

	public static void getAllDocuments(List<String> dataPaths) throws Exception {
		String line = null;
		int count = 0;
		for (String dataPath : dataPaths) {
			File file = new File(dataPath);
			File[] files = file.listFiles();
			for (File f : files) {
				if (!f.isDirectory()) {
					BufferedReader bufr = new BufferedReader(new FileReader(f));
					while ((line = bufr.readLine()) != null) {
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
