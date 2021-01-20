package com.lcode;

public class TestSpeed {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for(int i = 1; i < 10; i++){
            System.out.println("time is: " +  (i>>2));
        }

    }
}
