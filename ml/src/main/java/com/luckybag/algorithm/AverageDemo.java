package com.luckybag.algorithm;

public class AverageDemo {
    public static void main(String[] args) {

        int amount = 1000;
        int number = 21;
        int average = amount / number;
        int remainder = amount % number;
        while(number > 0){
            if(remainder > 0){
                System.out.println("第" + number + "个人获得的金额是：" + (average+1));
            }else{
                System.out.println("第" + number + "个人获得的金额是：" + average);
            }
            remainder--;
            number--;
        }
    }
}
