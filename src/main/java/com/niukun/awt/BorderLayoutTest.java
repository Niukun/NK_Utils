package com.niukun.awt;

import java.awt.*;
import java.awt.event.*;

import static java.awt.BorderLayout.*;


public class BorderLayoutTest {
    public static void main(String[] args) {
        Frame f = new Frame("Frame");
        f.setBounds(200,100,800,500);

        FileDialog d1 = new FileDialog(f, "file to open", FileDialog.LOAD);
        FileDialog d2 = new FileDialog(f, "file to save", FileDialog.SAVE);
        Button b1 = new Button("open");
        Button b2 = new Button("save");
        b1.addActionListener(e->{
            d1.setVisible(true);
            System.out.println(d1.getDirectory() + d1.getFile());
        });
        b2.addActionListener(e->{
            d2.setVisible(true);
            System.out.println(d2.getDirectory() + d2.getFile());
        });

        f.add(b1);
        f.add(b2, SOUTH);
        f.setVisible(true);

        f.pack();
        f.setVisible(true);
    }
    class clickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class MyListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {

        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }

}
