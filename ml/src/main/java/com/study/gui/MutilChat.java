package com.study.gui;



public class MutilChat implements Runnable{
    static int left = 0;
    static int top = 0;
    public MutilChat(String name) {
        Thread.currentThread().setName(name);
    }

    public static void main(String[] args) {
        MutilChat mt1 = new MutilChat("线程A ");    // 实例化对象
        MutilChat mt2 = new MutilChat("线程B ");    // 实例化对象
        Thread t1 = new Thread(mt1);       // 实例化Thread类对象
        Thread t2 = new Thread(mt2);       // 实例化Thread类对象
        t1.start();    // 启动多线程
        t2.start();    // 启动多线程
    }

    @Override
    public void run() {
         new ControlPanel(Thread.currentThread().getName()).createWindow(5);
    }
}
