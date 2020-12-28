package com.study.gui;

import com.luckybag.multiclient.websocket.MyWebSocketClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URISyntaxException;

import static com.study.gui.CONTANTS.WS_SERVER_DEV;
import static com.study.gui.CONTANTS.userMap;

public class ControlPanel {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JTextArea textArea;
    private JPanel controlPanel;
    private JTextField textField;
    private MyWebSocketClient myClient = null;
    static int left = 0;
    static int top = 0;

    public ControlPanel(String name) {

        try {
            myClient = new MyWebSocketClient(new URI(WS_SERVER_DEV));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            myClient.connectBlocking();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myClient.setConnectionLostTimeout(3000);
//        myClient.connect();
        if (myClient.isOpen()) {
            myClient.send("{<" + name + "@123@8008>}");

            System.out.println("send successful");
        }

        System.out.println(myClient.getToken());


        prepareGUI(name);
    }

    public static void main(String[] args) {
        System.out.println(userMap);
        for (int i = 0; i < 10; i++) {
            ControlPanel swingControlDemo = new ControlPanel("I'm windows " + i);
            swingControlDemo.showEventDemo();
        }
    }

    public void createWindow(int times) {
        for (int i = 0; i < times; i++) {
            ControlPanel swingControlDemo = new ControlPanel(Thread.currentThread().getName());
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
        JButton sendButton = new JButton("Send");
        textField = new JTextField(25);
        sendButton.addActionListener(new ButtonClickListener());
        textField.addActionListener(new TextFieldListener());

        controlPanel.add(sendButton);
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

            textArea.setText(textArea.getText() + textField.getText() + "\n");
            textField.setText("");
            myClient.send("subscribe:99999@lm.com.100");


        }
    }

    private class TextFieldListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String content = e.getActionCommand();
            textArea.setText(textArea.getText() + content + "\n");
            textField.setText("");
            myClient.send("subscribe:99999@lm.com.100");

        }
    }
}
