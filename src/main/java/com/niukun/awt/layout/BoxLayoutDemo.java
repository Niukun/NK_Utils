package com.niukun.awt.layout;

import com.niukun.awt.MyFrame;

import javax.swing.*;
import java.awt.*;

/**
 * BoxLayout 是Swing提供的布局管理器，用它管理Swing组件会有更好的效果
 *
 * glue可以在两个方向上拉伸
 * strut只能在一个方向上拉伸
 */
public class BoxLayoutDemo extends MyFrame {

    private Box horizontal = Box.createHorizontalBox();
    private Box vertical = Box.createVerticalBox();
    public void init(){
        f.setLayout(new BoxLayout(f,BoxLayout.Y_AXIS));
        f.add(new Button("First Button"));
        f.add(new Button("Second Button"));
        f.pack();
        f.setVisible(true);
    }

    public void init2(){
        horizontal.add(new Button("水平1"));
        horizontal.add(Box.createHorizontalGlue());
        horizontal.add(new Button("水平2"));
        horizontal.add(Box.createHorizontalStrut(10));
        horizontal.add(new Button("水平3"));


        vertical.add(new Button("垂直1"));
        vertical.add(Box.createVerticalGlue());
        vertical.add(new Button("垂直2"));
        vertical.add(Box.createVerticalStrut(10));
        vertical.add(new Button("垂直3"));
        f.add(horizontal,BorderLayout.NORTH);
        f.add(vertical);
        f.pack();
        f.setVisible(true);
    }


    public static void main(String[] a){
        new BoxLayoutDemo().init2();
    }
}
