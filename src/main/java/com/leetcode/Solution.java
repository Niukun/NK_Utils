package com.leetcode;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.print(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int result = 0;
        for(int i = 1;i<nums.length;i++){
            if(nums[result] != nums[i]){
                nums[++result] = nums[i];
            }
        }
        return result+1;
    }
}
