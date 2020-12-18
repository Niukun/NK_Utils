package com.luckybag.algorithm;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.util.*;

public class GaussianDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000000; i++) {
            list.add(doubleToInt(NormalDistribution(5, 10)));
        }

//        System.out.println(list);
        Collections.sort(list);
        XYSeries series = new XYSeries("xySeries");


        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int temp = 0;
        for (int i = 0; i < list.size();i++) {
            temp = list.get(i);
            if(map.containsKey(temp)){
                map.put(temp,map.get(temp)+1);
            }else{
                map.put(temp,1);
            }
        }
        Set<Integer> integers = map.keySet();
        Object[] objects = integers.toArray();


        Arrays.sort(objects);
        for(Object key:objects){
//            System.out.println(key +": "+map.get(key));
            series.add((Number) key, map.get(key));
        }

        Arrays.sort(objects);

//        for (int i = 0; i < list.size();i++) {
//            series.add(i, map.get(list.get(i)));
//        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "GaussianDemo", // chart title
                "x", // x axis label
                "Gaussian(x)", // y axis label
                dataset, // data
                PlotOrientation.VERTICAL,
                false, // include legend
                false, // tooltips
                false // urls
        );

        ChartFrame frame = new ChartFrame("my picture", chart);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public static int doubleToInt(Double d) {
        return d.intValue();
    }

    //普通正态随机分布
    //参数 u 均值
    //参数 v 方差
    public static double NormalDistribution(float u, float v) {
        java.util.Random random = new java.util.Random();
        return Math.sqrt(v) * random.nextGaussian() + u;
    }
}
