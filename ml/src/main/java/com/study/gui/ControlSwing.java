package com.study.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlSwing {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JTextArea textArea;
    private JPanel controlPanel;
    private JTextField textField;
    static int left = 0;
    static int top = 0;

    public ControlSwing(String name) {
        prepareGUI(name);
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            ControlSwing swingControlDemo = new ControlSwing("I'm windows " + i);
            swingControlDemo.showEventDemo();
        }
    }

    public void createWindow(int times){
        for (int i = 0; i < times; i++) {
            ControlSwing swingControlDemo = new ControlSwing(Thread.currentThread().getName());
            swingControlDemo.showEventDemo();
        }
    }

    private void prepareGUI(String name) {
        mainFrame = new JFrame("Lucky Bag Chat");
        mainFrame.setSize(380, 400);
        mainFrame.setLayout(new BorderLayout());
        headerLabel = new JLabel(name, JLabel.CENTER);
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setSize(350, 100);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(headerLabel, BorderLayout.NORTH);
        mainFrame.add(textArea, BorderLayout.CENTER);
        mainFrame.add(controlPanel, BorderLayout.SOUTH);

        mainFrame.setVisible(true);
    }

    public void showEventDemo() {
        JButton okButton = new JButton("Send");
        textField = new JTextField(25);
        okButton.addActionListener(new ButtonClickListener());
        textField.addActionListener(new TextFieldListener());

        controlPanel.add(okButton);
        controlPanel.add(textField);
        mainFrame.setLocation(left, top);
        left += 380;
        if (left >= 380 * 5) {
            left = 0;
            top = 400;
        }
        top += 0;
        System.out.println(left + top);
        mainFrame.setVisible(true);
    }



    private class ButtonClickListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String content = e.getActionCommand();
            if (content.trim() != "") {
                textArea.setText(textArea.getText() + content + "\n");
                textField.setText("");
            }

        }
    }

    private class TextFieldListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String content = e.getActionCommand();
            textArea.setText(textArea.getText() + content + "\n");
            textField.setText("");
        }
    }
}
