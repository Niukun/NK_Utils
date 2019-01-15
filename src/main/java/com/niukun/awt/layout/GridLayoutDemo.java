package com.niukun.awt.layout;

import com.niukun.awt.MyFrame;

import java.awt.*;

import static java.awt.BorderLayout.NORTH;


public class GridLayoutDemo extends MyFrame {
    public static void main(String[] args){
        Panel p1 = new Panel();
        p1.add(new TextField(30));
        f.add(p1,NORTH);
        Panel p2 = new Panel();
        p2.setLayout(new GridLayout(3,5,4,4));
        String[] name = {"1","2","3","4","5","6","7","8","9","0","+","_","*","/","="};
        for ( String str : name) {
            p2.add(new Button(str));
        }
        f.add(p2);
        f.pack();
        f.setVisible(true);



    }
}
