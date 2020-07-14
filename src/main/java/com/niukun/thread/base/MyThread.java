package com.niukun.thread.base;

public class MyThread implements Runnable{
    private int number = 2000;



    @Override
    public void run() {
        while(true){

            test();
        }
    }

    public synchronized void test() {
        if(number > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + number);
            number--;
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(myThread);
        Thread t2 = new Thread(myThread);
        Thread t3 = new Thread(myThread);
        t1.start();
        t2.start();
        t3.start();
        StringBuffer
    }
}
