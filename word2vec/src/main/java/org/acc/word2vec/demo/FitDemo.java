package org.acc.word2vec.demo;

import org.acc.word2vec.core.Word2VecUtils;
import org.acc.word2vec.util.TextUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by zhaoyy on 2016/12/19.
 */
public class FitDemo {

    public static void main(String[] args) {

    	System.out.println("start...");
        List<File> files = TextUtils.listFilesRecursively("D:/NLPIR/word2vec/big/trainandtestSegment/", file -> file.getName().endsWith(".txt"));
        Word2VecUtils
                .newWord2Vec()
                .addAllTextFile(files)
                .charset(Charset.forName("UTF-8"))
                .saveAt("D:/NLPIR/word2vec/big/trainandtestSegment/trainandtestSegment.bin", true)
                .build();
        System.out.println("end...");

    }
}
