package test;

import java.net.UnknownHostException;

public class Test {
	public static void main(String[] args) throws UnknownHostException {
		int i =0;
		int x = 3;
		switch(x){
			case 3:++i;
			case 2:++i;
			case 1:++i;
			default:++i;}
		System.out.println(i);
	}
}
