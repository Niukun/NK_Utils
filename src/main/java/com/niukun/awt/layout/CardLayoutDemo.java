package com.niukun.awt.layout;

import com.niukun.awt.MyFrame;

import java.awt.*;
import java.awt.event.ActionListener;

public class CardLayoutDemo extends MyFrame {
    String[] names = {"1","2","3","4","5"};
    Panel p1 = new Panel();
    public void init(){
        CardLayout c = new CardLayout();
        p1.setLayout(c);
        for (String name: names) {
            p1.add(name, new Button(name));
        }
        Panel p = new Panel();
        ActionListener listener = e ->{
            switch (e.getActionCommand()){
                case "pre":
                    c.previous(p1);
                    break;
                case "next":
                    c.next(p1);
                    break;
                case "fir":
                    c.first(p1);
                    break;
                case "last":
                    c.last(p1);
                    break;
                case "thir":
                    c.show(p1,"3");
                    break;

            }
        };
        Button next = new Button("next");
        next.addActionListener(listener);

        Button pre = new Button("pre");
        pre.addActionListener(listener);

        Button fir = new Button("fir");
        fir.addActionListener(listener);

        Button last = new Button("last");
        last.addActionListener(listener);

        Button thir = new Button("thir");
        thir.addActionListener(listener);

        p.add(pre);
        p.add(next);
        p.add(fir);
        p.add(last);
        p.add(thir);
        f.add(p1);
        f.add(p,BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);

    }
    public static void main(String[] args){
        new CardLayoutDemo().init();
    }
}
