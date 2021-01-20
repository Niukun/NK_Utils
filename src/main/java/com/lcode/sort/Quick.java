package com.lcode.sort;

import java.util.Arrays;

public class Quick {

	public static void main(String[] args) {
		Integer[] nums = {2,3,5,1,6,9,8,7,4};
		System.out.println(Arrays.toString(nums));
		sort(nums);
		System.out.println(Arrays.toString(nums));

	}

	//对数组内的元素进行排序
	private static void sort(Comparable[] a) {
		int lo = 0;
		int hi = a.length-1;
		sort(a, lo, hi);
	}

	//对数字a中从索引lo到索引hi之间的元素进行排序
	private static void sort(Comparable[]a, int lo, int hi) {
		//安全性校验
		if(lo >= hi){
			return;
		}

		//需要对数据中lo到hi之间的数据进行分组，左子组，右子组,partication是分解值变化后的位置
		int partication = getPartication(a, lo, hi);

		//让左子组有序
		sort(a,lo,partication-1);

		//让右子组有序
		sort(a,partication +1, hi);

	}
	
	private static int getPartication(Comparable[]a, int lo, int hi) {
		//确定分解值
		Comparable key = a[lo];
		int left = lo;
		int right = hi+1;
		while(true){
			while(less(key,a[--right])){
				if(right == lo){
					break;
				}
			}


			while(less(a[++left],key)){
				if(left == hi){
					break;
				}
			}

			if(left >= right){
				break;
			}else{
				exch(a,left,right);
			}
		}
		exch(a,lo,right);

		return right;

	}
	
	private static boolean less(Comparable c1, Comparable c2) {
		return c1.compareTo(c2) < 0;
		
	}
	
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
	
	
	
	
	
	

}
