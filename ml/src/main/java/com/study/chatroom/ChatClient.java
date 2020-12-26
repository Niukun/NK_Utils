package com.study.chatroom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ChatClient
{

    private JTextArea incoming;
    private JTextField outgoing;
    private JTextArea userList;
    private BufferedReader reader;
    private PrintWriter writer;
    private String username;
    //Is this a password or something else? should probably be renamed
    private String[] ps;


    public static void main(String[] args)
    {
        ChatClient client = new ChatClient();
        client.go();
    }

    private void go()
    {

        JFrame frame = new JFrame("Client");
        JPanel mainPanel = new JPanel();

        //TODO use this labels
        JLabel l1, l2;
        l1 = new JLabel(Constants.MESSAGE_BOX);
        l2 = new JLabel(Constants.USER_LIST);


        incoming = new JTextArea(15, 50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);

        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

       JTextArea userList = new JTextArea(15, 10);
        userList.setLineWrap(true);
        userList.setWrapStyleWord(true);
        userList.setEditable(false);
      
        JScrollPane uScroller = new JScrollPane(userList);
        uScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        outgoing = new JTextField(20);

        JButton sendButton = new JButton(Constants.SEND);
        sendButton.addActionListener(new SendButtonListener());

        mainPanel.add(qScroller);
        mainPanel.add(uScroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);

        setUpNetworking();

        username = JOptionPane.showInputDialog(Constants.WELCOME_MESSAGE);

        frame.setTitle(username.toUpperCase());

        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    private void setUpNetworking()
    {

        try
        {
            Socket socket = new Socket(Constants.HOST, Constants.PORT);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(socket.getOutputStream());
            //Todo implement a logger e.g slf4j
            System.out.println("Networking established");

        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener
    {

        public void actionPerformed(ActionEvent ev)
        {
            try
            {
                writer.println(username + " : " + outgoing.getText());
                writer.flush();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }
		//IncomingReader
    public class IncomingReader implements Runnable {

        public void run() {
            String message;

            try {

                while ((message = reader.readLine()) != null) {
                    if (!messageOrList(message)) {
                        incoming.append(message + "\n");
                    } else {
                        userList.setText("");
                        for (int i = 1; i < ps.length; ++i) {

                            userList.append(ps[i] + "\n");
                        }

                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        boolean messageOrList(String ms) {
            ps = ms.split(Constants.REG_EX_ESC_PATTERN);
            return Constants.SHOW_MSG_VAL_CON_VAL.equals(ps[0]);
        }
    }



}
