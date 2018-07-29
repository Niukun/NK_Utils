package com.niukun.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.TextField;

public class FrameTest {
	static Frame f;
	
	static {
		f = new Frame("Test Frame");
	}
	
	public static void main(String[] args) {
		test05();
	}

	private static void test05() {
		Panel p1 = new Panel();
		p1.add(new TextField(50));
		f.add(p1,BorderLayout.NORTH);
		
		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(3,5,4,4));
		String[] name = {"0","1","2","3","4","5","6","7","8","9","+","-","*","/",".","="};
		for(String str : name) {
			p2.add(new Button(str));
		}
		f.add(p2);
		
		f.pack();
		f.setVisible(true);
	}
	
	private static void test04() {
		f.setLayout(new BorderLayout(30,5));
		f.add(new Button("SOUTH"), BorderLayout.SOUTH);
		f.add(new Button("NORTH"), BorderLayout.NORTH);
		Panel p = new Panel();
		p.add(new TextField(20));
		p.add(new Button("Button"));
		f.add(p);
		f.add(new Button("EAST"), BorderLayout.EAST);
		
		f.pack();
		f.setVisible(true);
	}
	
	private static void test03() {
		f.setLayout(new BorderLayout(30,5));
		f.add(new Button("SOUTH"), BorderLayout.SOUTH);
		f.add(new Button("NORTH"), BorderLayout.NORTH);
		f.add(new Button("CENTER"));
		f.add(new Button("WEST"), BorderLayout.WEST);
		f.add(new Button("EAST"), BorderLayout.EAST);
		
		f.pack();
		f.setVisible(true);
	}
	
	private static void test02() {
		f.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		
		for(int i =0;i<20;i++) {
			f.add(new Button("Button" + i));
		}
		f.pack();
		f.setVisible(true);
	}
	
	private static void test01() {
		ScrollPane p = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
		p.add(new TextField(20));
		p.add(new Button("Click me"));
		f.add(p);
		
		f.setBounds(30, 30, 250, 120);
		f.setVisible(true);
	}
	
}
