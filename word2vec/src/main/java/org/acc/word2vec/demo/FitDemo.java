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
    	long start = System.currentTimeMillis();
        List<File> files = TextUtils.listFilesRecursively("C:/D/NLPIR/paper/files/merge/tensite_5/", file -> file.getName().endsWith(".txt"));
        System.out.println("file is ready...");
        Word2VecUtils
                .newWord2Vec()
                .addAllTextFile(files)
                .charset(Charset.forName("UTF-8"))
                .saveAt("C:/D/NLPIR/paper/files/merge/tensite_5/1.bin", true)
                .build();
        System.out.println( System.currentTimeMillis()-start);
        System.out.println("end...");

    }
}
