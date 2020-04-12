package com.leetcode;

import java.util.*;

public class UnionList {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1,5};
        long start = System.currentTimeMillis();
//        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(45));


    }

    public static boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    public static int countPrimes(int n) {
        // 计数变量
        int count = 0;
        // 创建一个布尔数组长度和N相同，默认值为false
        boolean[] signs = new boolean[n];
        for (int i = 2; i < n; i++) {
            // 当为false是进入
            if (!signs[i]) {
                count++;
                // 每次循环加i，就能找到i的所有倍数。
                for (int j = i + i; j < n; j += i) {
                    // 非质数的数其为下标对应的值为真。
                    signs[j] = true;
                }
            }
        }
        System.out.println(count);
        return count;
    }

    public static boolean isPrimes(int num){
        for(int i = 2; i<Math.sqrt(num)+1;i++){
            if(num%i == 0){
                return false;
            }
        }

        return true;
    }

}
