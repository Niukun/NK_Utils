package com.niukun.string;

import org.junit.Test;

import java.util.StringJoiner;

public class StringJoinerStudy {

    public static void main(String[] args) {
        String[] names = {"Bob", "Alice", "Grace"};
        StringBuilder sb = new StringBuilder();
        sb.append("Hello ");
        for (String name : names) {
            sb.append(name).append(", ");
        }
        // 注意去掉最后的", ":
        sb.delete(sb.length() - 2, sb.length());
        sb.append("!");
        System.out.println(sb.toString());
    }

    @Test
    public void JoinerTest01(){
        String[] names = {"Bob", "Alice", "Grace"};
        StringJoiner sj = new StringJoiner(", ");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());
    }

    @Test
    public void JoinerTest02(){
        String[] names = {"Bob", "Alice", "Grace"};
        StringJoiner sj = new StringJoiner(", ", "[ ", "]");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());
    }

    //String还提供了一个静态方法join()，这个方法在内部使用了StringJoiner来拼接字符串，在不需要指定“开头”和“结尾”的时候，用String.join()更方便：
//    String[] names = {"Bob", "Alice", "Grace"};
//    String s = String.join(", ", names);

}
