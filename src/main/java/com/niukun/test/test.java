package com.niukun.test;

import java.io.Console;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {

		test t = new test();
		for(int i = 1900;i < 2100; i++) {
			t.printNums(i);
		}
	}  
	
	public void printNums(int num) {
		StringBuffer sb = new StringBuffer();
		for (int i = 2; i < num; i++) {
			if(num%i == 0) {
				sb.append(i + " ");
			}
		}
		if(sb.toString().length()>0) {
			System.out.println(num + ":" +sb.toString());
		}
	}
	
	
	
}
