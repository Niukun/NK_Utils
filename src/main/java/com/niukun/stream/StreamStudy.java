package com.niukun.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudy {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = list.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
// 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).collect(Collectors.toList());
        squaresList.stream().forEach(System.out::println);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());

        System.out.println("筛选列表: " + filtered);
        String mergedString = list.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);
    }
}
