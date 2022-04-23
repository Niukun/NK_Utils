package com.niukun.string;

public class NumStr16 {


    public static void main(String[] args) {
        int a = 0x0001b1d;

        System.out.println(a);
        System.out.println(String.format("%09x", a));
        System.out.println(Integer.toHexString(a));


        long start = System.currentTimeMillis();
        long i = 0;
        while((System.currentTimeMillis()-start)/1000 < 100){
            i++;
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("finished: " + i);
//        16153397090
//        57191
//        57544



    }
}
