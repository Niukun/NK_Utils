package com.niukun.awt.layout;

import com.niukun.awt.MyFrame;

import java.awt.*;

/**
 * 使用绝对定位不是最好的方法，它可能会大致GUI界面失去跨平台特性。
 */
public class AbsoluteDemo extends MyFrame {
    Button btn1 = new Button("Button1");
    Button btn2 = new Button("Button2");

    public void init(){
        f.setLayout(null);

        btn1.setBounds(20,30,90,28);
        f.add(btn1);
        btn2.setBounds(50,45,120,35);
        f.add(btn2);

        f.setBounds(50,50,200,100);
        f.setVisible(true);
    }
    public static void main(String[] a){
        new AbsoluteDemo().init();
    }
}
