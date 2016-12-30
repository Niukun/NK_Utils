package org.acc.word2vec.demo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.acc.word2vec.core.Word2VecUtils;
import org.deeplearning4j.models.word2vec.Word2Vec;

/**
 * Created by zhaoyy on 2016/12/19.
 */
public class RestoreDemo {

    public static void main(String[] args) throws FileNotFoundException {
        Word2Vec word2Vec = Word2VecUtils
                .restore("D:/NLPIR/word2vec/tenbigfileSegment.bin");
        /*double[] ds =  word2Vec.getWordVector("西游记");
        for (int i = 0; i < ds.length; i++) {
        	System.out.print(ds[i]+" ");
		}*/
        System.out.println("______________________");
        List<String> list= new ArrayList();
        list.add("中国");
        list.add("北京");
        list.add("美国");
        list.add("纽约");
        Map<String, Double>  map = word2Vec.accuracy(list);
        HashSet set = (HashSet) map.keySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
        	String str = (String) it.next();
        	double d = map.get(str);
        	System.out.println(str + ":" + d);
        }
        
        
        System.out.println(word2Vec.wordsNearest("西游记", 10));
        //[水浒传, 三国演义, 霸王别姬, 红楼梦, 西厢记, 文昭关, 怀玉, 铁梨花, 花木兰, 四郎探母]
    }
}
