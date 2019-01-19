package com.niukun.awt.component;

import com.niukun.awt.MyFrame;

import java.awt.*;

public class FileDialogDemo extends MyFrame {
    FileDialog d1 = new FileDialog(f,"choose file to open",FileDialog.LOAD);
    FileDialog d2 = new FileDialog(f,"Choose path to save", FileDialog.SAVE);
    Button b1 = new Button("Open");
    Button b2 = new Button("Save");

    public static void main(String[] args){
        new FileDialogDemo().init();
    }

    private void init() {
        b1.addActionListener(e->{
            d1.setVisible(true);
            System.out.println(d1.getDirectory() + d1.getFile());
        });
        b2.addActionListener(e->{
            d2.setVisible(true);
            System.out.println(d2.getDirectory() + d2.getFile());
        });
        f.add(b1);
        f.add(b2,BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }
}
