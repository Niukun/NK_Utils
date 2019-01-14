package com.niukun.awt.layout;

import com.niukun.awt.MyFrame;

import java.awt.*;

/**
 * Panel,Applet use this Layout by default
 */
public class FlowLayoutDemo extends MyFrame {
    public static void main(String[] args) {
        f.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT,20,5));

        for(int i =0;i<20;i++) {
            f.add(new Button("Button" + i));
        }
        f.pack();
        f.setVisible(true);
    }
}
