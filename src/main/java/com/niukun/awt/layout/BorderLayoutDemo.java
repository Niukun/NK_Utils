package com.niukun.awt.layout;

import com.niukun.awt.MyFrame;

import java.awt.*;

import static javax.swing.SpringLayout.*;

/**
 * Frame,Dialog,ScrollPane use this Layout by default
 *
 */
public class BorderLayoutDemo extends MyFrame {
    public static void main(String[] args){
        f.setLayout(new BorderLayout(3,5));

        f.add(new Button("a"),SOUTH);
        f.add(new Button("b"),NORTH);
        f.add(new Button("c"));
        f.add(new Button("d"),EAST);
        f.add(new Button("e"),WEST);
        f.pack();
        f.setVisible(true);
    }
}
