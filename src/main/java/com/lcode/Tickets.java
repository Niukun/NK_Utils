package com.lcode;


import java.util.ArrayList;
import java.util.List;

public class Tickets {

    public static void main(String[] args) {

        int[] prices = {9,1,4,6,3,2,8,7};
        maxProfit(prices);
    }

    public static int maxProfit(int[] prices) {
        int result = 0;

        System.out.println(sortPrices(prices));
        System.out.println(getMax(prices));
        return result;
    }

    public static List sortPrices(int[] prices){
        List<Integer> list = new ArrayList<Integer>();

        int pLength = prices.length;
        int[] sortedPrices = new int[pLength];
        for(int i = 0;i< pLength;i++){
            list.add(prices[i]);
        }

        for(int i =0; i < pLength ;i++){
            for(int j = i; j < pLength; j++){
                if(list.get(i) > list.get(j)){
                    int temp = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i,temp);
                }
            }
        }
        return list;
    }

    public static int getMax(int[] nums){
        int max = 0;
        for(int i : nums){
            if(max < i){
                max = i;
            }
        }
        return max;

    }


}
