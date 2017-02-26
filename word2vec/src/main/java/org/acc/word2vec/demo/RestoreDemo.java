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
        .restore("C:/D/NLPIR/paper/files/vec/Normalized/doc.bin");
        System.out.println("加载模型使用时间："+(System.currentTimeMillis()-start));
//        double[] ds =  word2Vec.getWordVector("余建伟");
//        for (int i = 0; i < ds.length; i++) {
//        	System.out.print(ds[i]+" ");
//		}
        System.out.println("______________________");
        
        System.out.println(word2Vec.wordsNearest("北京", 10));
        System.out.println(word2Vec.wordsNearest("文化", 10));
        System.out.println(word2Vec.wordsNearest("阅读", 10));
        System.out.println(word2Vec.wordsNearest("军事", 10));
        System.out.println(word2Vec.wordsNearest("西游记", 10));
        //[水浒传, 三国演义, 霸王别姬, 红楼梦, 西厢记, 文昭关, 怀玉, 铁梨花, 花木兰, 四郎探母]
    }
}

// WithOutNormalize.bin
//[天津, 上海, 联谊会, 第十五届, 会议厅, 25周年, 广州, 第十九届, 第15届, 闭幕]
//[社会, 反思, 个人, 批判, 记忆, 劣根性, 多元性, 追问, 人文主义, 教育观]
//[连载, 本书, 延伸, 提示, 书评, 简介, 陈智德, 交锋, 提要, 书讯]
//[互信, 两岸, 南海, 切入口, 歼, 降, 跑道, 自述, 亲手, 解放军]
//[儒林外史, 三国演义, 水浒传, 左传, 玄奘, 资治通鉴, 禹贡, 封神榜, 本草纲目, 红楼梦]

//doc.bin
//[上海, 广州, 重庆, 杭州, 德惠市, 成都, 南京, 昨天, 获悉, 上午]
//[反思, 追问, 批判, 社会, 记忆, 个人, 一体, 高彦, 资讯, 孙宏开]
//[连载, 本书, 书评, 精品, 提示, 书讯, 书系, 风云录, 延伸, 品读]
//[互信, 两岸, 歼, 南海, 切入口, 降, 自述, 李磊, 跑道, 亲手]
//[三国演义, 汪宏华, 奘, 孙悟空, 取经, 西游, 玄, 水浒传, 续集, 吴承恩]
