package com.leetcode.sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Integer[] nums = {2,3,5,1,6,9,8,7,4};
        System.out.println(Arrays.toString(nums));
        sort(nums);
        System.out.println(Arrays.toString(nums));

    }

    private static void sort(Comparable[] a) {

        int lo = 0;
        int hi = a.length -1;
        sort(a,lo,hi);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if(lo>=hi){
            return;
        }
        int partication = getPartication(a, lo, hi);

        sort(a,lo,partication-1);
        sort(a,partication+1, hi);


    }

    private static int getPartication(Comparable[] a, int lo, int hi) {
        Comparable key = a[lo];
        int left = lo;
        int right = hi+1;
        while(true){
            while(less(a[++left],key)){
                if(left == hi){
                    break;
                }
            }
            while(less(key,a[--right])){
                if(right == lo){
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
        System.out.println(left + "---" + right);
        return right;

    }


    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
