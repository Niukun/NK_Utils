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
    	long start = System.currentTimeMillis();
        Word2Vec word2Vec = Word2VecUtils
//                .restore("D:/NLPIR/word2vec/tenbigfileSegment.bin");
        .restore("D:/NLPIR/word2vec/big/trainandtestSegment/trainandtestSegment.bin");
        System.out.println("加载模型使用时间："+(System.currentTimeMillis()-start));
        double[] ds =  word2Vec.getWordVector("灵柩");
        for (int i = 0; i < ds.length; i++) {
        	System.out.print(ds[i]+" ");
		}
        System.out.println("______________________");
        
        System.out.println(word2Vec.wordsNearest("灵柩", 10));
        //[水浒传, 三国演义, 霸王别姬, 红楼梦, 西厢记, 文昭关, 怀玉, 铁梨花, 花木兰, 四郎探母]
    }
}
