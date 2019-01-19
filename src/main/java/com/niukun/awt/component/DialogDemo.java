package com.niukun.awt.component;

import com.niukun.awt.MyFrame;

import java.awt.*;

public class DialogDemo extends MyFrame {
    Dialog d1 = new Dialog(f,"modal",true);
    Dialog d2 = new Dialog(f,"non-modal",false);
    Button b1 = new Button("Open modal dialog");
    Button b2 = new Button("Open non-modal dialog");
    public static void main(String[] args){
        new DialogDemo().init();

    }


    private void init() {
        d1.setBounds(20,30,300,400);
        d2.setBounds(20,30,300,400);
        b1.addActionListener(e -> d1.setVisible(true));
        b2.addActionListener(e -> d2.setVisible(true));
        f.add(b1);
        f.add(b2,BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }
}
