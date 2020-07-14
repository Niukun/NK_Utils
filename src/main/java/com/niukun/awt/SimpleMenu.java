package com.niukun.awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SimpleMenu {
    public static void main(String[] args) {
        Frame f = new Frame();
        MenuBar mb = new MenuBar();
        Menu save = new Menu("save");
        MenuItem open = new MenuItem("open");
        MenuItem edit = new MenuItem("edit");

        save.add(open);
        save.add(edit);
        mb.add(save);
        f.setMenuBar(mb);
        f.setBounds(200,100,500,800);
        f.pack();
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosed(e);
                System.exit(0);
            }
        });





    }

}
