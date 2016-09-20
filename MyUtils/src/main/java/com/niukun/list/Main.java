package com.niukun.list;

import java.util.Scanner;
/**
 * 实现连续输入数字，统计里面仅含01的数字个数
 * @author Niukun
 *
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Input the num:");
		Scanner scan = new Scanner(System.in);
		int n ;
		while ((n=scan.nextInt())!= 0) {
			System.out.println(CountOfNum(n));
		}
	}

	private static int CountOfNum(long n) {
		int count = 0;
		for (long i = 1; i <= n; i++) {
			long temp = i;
			long res = i;
			while (temp != 0 && (temp % 10 == 0 || temp % 10 == 1)) {
				temp = temp / 10;
			}
			if (temp == 0) {
				count++;
				// System.out.println("res:"+res);
			}
		}
		return count;
	}
}
