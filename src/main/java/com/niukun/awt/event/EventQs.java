package com.niukun.awt.event;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.niukun.awt.MyFrame;

public class EventQs  extends MyFrame {
    private Button ok = new Button("Click me");
    private TextField tf = new TextField(30);
    public void init(){
        ok.addActionListener(new OkListener());
        f.add(tf);
        f.add(ok,BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }
    class OkListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("用户单击了ok按钮");
            tf.setText("Hello world!");
        }
    }
    public static void main(String[] args){
        new EventQs().init();

    }
}
