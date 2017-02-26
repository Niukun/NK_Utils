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
	
	
	public static List<String> getAllDocuments() {
		return allDocuments;
	}

	public static Map<String, Double> getIdfmap() {
		return idfmap;
	}

	public static Map<String, MutableInt> getTfmap() {
		return tfmap;
	}

	static {
		List<String> dataPaths = new ArrayList<String>();
		dataPaths.add("C:/D/NLPIR/paper/files/test/Normalize/seg/");
		dataPaths.add("C:/D/NLPIR/paper/files/train/Normalize/seg/");
		System.out.println("get allDocuments...");
		try {
			//在类加载的时候读取文件集合
			getAllDocuments(dataPaths);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 直接放在构造函数里面完成idf的计算与保存工作，保存到idf.txt
	 * 
	 * 含有map按照value排序，参考：http://www.cnblogs.com/hxsyl/p/3331095.html
	 * 
	 * @throws IOException
	 */
	public keyWords() throws IOException {

		bufwidf = new BufferedWriter(new FileWriter(new File("C:/D/NLPIR/paper/files/idf.txt")));
		
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
		if(bufwidf!=null){
			bufwidf.close();
		}
	
	}
	
	public static void main(String[] args) throws Exception {

//		System.out.println("save allDocuments...");
//		saveDocs();

		new keyWords();
		
		System.out.println("getSortedTFIDFAndSave...");
		getSortedTFIDFAndSave(15);
		
		System.out.println("TF Save...");
		getSortedKeyWords(allDocuments.get(3) ,15);

		System.out.println("end...");

	}

	/*
	 * 对所有文件进行操作，得到排序的tfidf值，然后按照指定的数量存储到文件中
	 */
	private static void getSortedTFIDFAndSave(int wordsNum) throws IOException {
		bufwtf = new BufferedWriter(new FileWriter(new File("C:/D/NLPIR/paper/files/tfidf.txt")));
		
		TfIdf tfIdf = new TfIdf(allDocuments);

		for (int i = 0; i < allDocuments.size(); i++) {
			Map<String, MutableInt> map = tfIdf.tf(allDocuments.get(i));
			Set<String> words = map.keySet();
			Iterator iter = words.iterator();
			Map<String, Double> tfidfmap = new HashMap<String, Double>();
			// 先得到tfidf的map数据
			String key = null;
			double idf = 0;
			int tf = 0;
			while (iter.hasNext()) {
				key = (String) iter.next();
				if (idfmap.containsKey(key)) {
					idf = idfmap.get(key);
					tf = map.get(key).getCounter();
					tfidfmap.put(key, (tf * idf));
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
		if(bufwtf!=null){
			bufwtf.close();
		}
	}

	/**
	 * 此类之前必须执行得到idf的操作，因为要计算tf-idf = tf * idf
	 * @param document 要提取关键字的字符串
	 * @param wordsNum 即将返回的关键词个数
	 * @throws IOException
	 */
	public static String[] getSortedKeyWords(String document, int wordsNum) throws IOException {
		bufwtf = new BufferedWriter(new FileWriter(new File("C:/D/NLPIR/paper/files/keyWords.txt"),true));
		TfIdf tfIdf = new TfIdf(allDocuments);
		String[] strs = new String[wordsNum];
		tfmap = tfIdf.tf(document);//得到文档中每个词的tf值
		Set<String> words = tfmap.keySet();//得到文档的所有词
		Iterator iter = words.iterator();
		
		Map<String, Double> tfidfmap = new HashMap<String, Double>();//用来保存文档中词的tfidf值
		
		// 先得到tfidf的map数据
		String key = null;
		double idf = 0;
		int tf = 0;
		while (iter.hasNext()) {
			key = (String) iter.next();//对于每个词
			if (idfmap.containsKey(key)) {
				idf = idfmap.get(key);//找到对应的idf值
				tf = tfmap.get(key).getCounter();//找到对应的tf值
				tfidfmap.put(key, (tf * idf));
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
		if(bufwtf!=null){
			bufwtf.close();
		}
		return strs;
	}

	/*
	 * 仅仅是保存文档，没什么技术含量、
	 */
	private static void saveDocs() throws IOException {
		BufferedWriter bu = new BufferedWriter(new FileWriter(new File("C:/D/NLPIR/paper/files/doc.txt")));
		Iterator iter = allDocuments.iterator();
		while (iter.hasNext()) {
			bu.write((String) iter.next());
			bu.newLine();
			bu.flush();
		}
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
		System.out.println("Document count is : " + count);
		System.out.println("'allDocuments' is prepared,size is : " + allDocuments.size());
	}

}
