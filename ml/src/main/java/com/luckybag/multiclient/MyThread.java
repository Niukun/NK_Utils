package com.luckybag.multiclient;

public class MyThread implements Runnable {

    public MyThread(String name) {
        Thread.currentThread().setName(name);
    }

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "运行，i = " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
