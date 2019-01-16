package com.niukun.list;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
	private final int TIMES = 5000;
	public SetDemo() {
	}

	public static void main(String[] args) {
		SetDemo sd = new SetDemo();

		int sum = 0;
		for(int i = 0;i < sd.TIMES; i++){
			sum += sd.giveSet5000Numbers();
		}
		System.out.println("Average times:\t" + sum/sd.TIMES);
	}

	/**
	 * 方法测试往一个set里面扔5000个不同的数组需要多少次
	 */
	public int giveSet5000Numbers(){
		Set<Integer> Randlist = new HashSet<Integer>();
		int times = 0;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			if (Randlist.size() < 5000) {
				int count = (int) (Math.random() * 67000);
				Randlist.add(Integer.valueOf(count));
				times++;
			} else {
				break;
			}
		}
		/**
		 * 两个结果不一样是因为用的是set，不是list
		 */
//		System.out.println("Randlist size:\t" + Randlist.size());
//		System.out.println("Running times:\t" + times);
		return times;
	}
}
