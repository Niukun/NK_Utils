package com.niukun.awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class SimpleDraw {
    String RECT_SHAPE = "react";
    String OVAL_SHAPE = "oval";
    Frame f = new Frame("Frame");
    Button rect = new Button("RECT");
    Button oval = new Button("OVAL");
    MyCanvas drawArea = new MyCanvas();
    String shape = "";
    public void init() {
        Panel p = new Panel();
        rect.addActionListener(e ->{
            shape = RECT_SHAPE;
            drawArea.repaint();
        });
        oval.addActionListener(e ->{
            shape = OVAL_SHAPE;
            drawArea.repaint();
        });

        p.add(rect);
        p.add(oval);
        drawArea.setPreferredSize(new Dimension(250, 180));
        f.add(drawArea);
        f.add(p,BorderLayout.SOUTH);
        f.pack();
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleDraw().init();
    }

    class MyCanvas extends Canvas{
        public void paint(Graphics g){
            Random rand = new Random();
            if(shape.equals(RECT_SHAPE)){
                g.setColor(new Color(200,100,80));
                g.drawRect(rand.nextInt(200), rand.nextInt(120),40,60);
            }
            if(shape.equals(OVAL_SHAPE)){
                g.setColor(new Color(80,100,200));
                g.fillOval(rand.nextInt(200), rand.nextInt(120),50,40);
            }
        }
    }
}
