package com.niukun.awt.layout;

import com.niukun.awt.MyFrame;

import java.awt.*;

public class GridBagLayoutDemo extends MyFrame {
    private GridBagLayout gb = new GridBagLayout();
    private GridBagConstraints gbc = new GridBagConstraints();
    private Button[] btns = new Button[10];

    public void init(){
        f.setLayout(gb);
        for (int i =0; i<btns.length; i++) {
            btns[i] = new Button("Button " + i);
        }
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        addButton(btns[0]);
        addButton(btns[1]);
        addButton(btns[2]);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        addButton(btns[3]);
        gbc.weightx = 0;
        addButton(btns[4]);
        gbc.gridwidth = 2;
        addButton(btns[5]);


        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        addButton(btns[6]);
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.weighty = 1;
        addButton(btns[7]);
        gbc.weighty = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;

        addButton(btns[8]);
        addButton(btns[9]);
        f.pack();
        f.setVisible(true);
    }

    private void addButton(Button btn ){
        gb.setConstraints(btn,gbc);
        f.add(btn);
    }
    public static void main(String[] args){
        new GridBagLayoutDemo().init();
    }
}
