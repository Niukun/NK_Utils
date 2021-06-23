package com.leetcode;

import org.junit.Test;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        int[] nums = {1, 1, 2};
//        Arrays.sort(nums);
        Map<Integer,Integer> map = new TreeMap();
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        List<Integer> list = new ArrayList();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if(map.get(next) == next){
                list.add(next);
            }
        }
        Collections.sort(list);



        Object o = map.get("1");
        System.out.println(o);

//        System.out.print(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[result] != nums[i]) {
                nums[++result] = nums[i];
            }
        }
        return result + 1;
    }

    @Test
    public void testcheckStraightLine(){
//[[-3,-2],[-1,-2],[2,-2],[-2,-2],[0,-2]]
        int[][] test = {{1,2},{1,3},{1,4},{6,5}};
        boolean b = checkStraightLine(test);

        System.out.println(b);
    }


    public boolean checkStraightLine(int[][] coordinates) {
        //y = ax+b
        //y = ax+b
        double a = 0 ,b;
        if((coordinates[0][0] - coordinates[1][0]) ==0){
            for(int i = 2;i<coordinates.length;i++ ){
                if(coordinates[i][0] !=coordinates[0][0]){
                    return false;
                }

            }
            return true;
        }else{
            a = (coordinates[0][1] - coordinates[1][1])*1.0/(coordinates[0][0] - coordinates[1][0]);
        }

        b = coordinates[0][1] - a*coordinates[0][0];

        if(a == 0){
            for(int i = 2;i<coordinates.length;i++ ){
                if(coordinates[i][1] != coordinates[0][1]){
                    return false;
                }
            }
            return true;
        }
        for(int i = 2;i<coordinates.length;i++ ){
            if(coordinates[i][1] != a*coordinates[i][0] + b){
                return false;
            }
        }
        return true;
    }

    public int findLucky(int[] arr) {
        Map<Integer,Integer> map = new TreeMap();
        for(int i =0;i<arr.length;i++){
            if(map.get(arr[i])==null){
                map.put(arr[i],1);
            }else{
                map.put(arr[i],map.get(arr[i])+1);
            }
        }

        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        List<Integer> list = new ArrayList();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if(map.get(next) == next){
                list.add(next);
            }
        }
        Collections.sort(list);

        return list.size() > 0?list.get(list.size()-1):-1;
    }

    @Test
    public void test01(){
        int[] arr = {2,2,2,3,4};
        System.out.println(findLucky(arr));
    }

}
