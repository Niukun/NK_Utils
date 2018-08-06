package com.niukun.number;

public class NumberGame {
	public static int staticResult = 0;
	public static void main(String[] args) {
		countCertainNumberInRange(9,0,99);
		System.out.println("staticResult:"+staticResult);
	}
	/**
	 * 从一个整数范围里计算得到包含某个数字的数量
	 * @param num 指定数字
	 * @param start 起始范围
	 * @param end 结束范围
	 */
	public static void countCertainNumberInRange(int num, int start, int end) {
		if(num<0||num>9) {
			System.out.println("Please input a num that from 0 to 9...");
			return;
		}
		if(start>end) {
			System.out.println("Range not avliable...");
			return;
		}
		for(int i = start;i<=end;i++) {
			countSingleNumber(num,i);
		}
	}
	private static void countSingleNumber(int num, int singleNumber) {
		while(singleNumber/10!=0||singleNumber%10!=0) {
			if(singleNumber%10 == num) {
				staticResult++;
			}
			singleNumber /= 10;
		}
		
	}
}
