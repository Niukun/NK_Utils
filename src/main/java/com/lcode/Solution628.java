package com.lcode;


import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 */
public class Solution628 {

    @Test
    public void test() throws IOException {

        BufferedReader bufr = new BufferedReader(new FileReader(new File("D:\\github\\NK_Utils\\src\\main\\resources\\lcode\\628.txt")));

        String line = null;
        String[] numbers;
        int[] nums;
        if ((line = bufr.readLine()) != null) {
            numbers = line.split(",");
            nums = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                nums[i] = Integer.parseInt(numbers[i]);
            }
            System.out.println(nums.length);

            int i = maximumProduct(nums);


            System.out.println(i);
        }


    }

    class Com implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if (Math.abs(o1) < Math.abs(o2)) {
                return 1;
            } else if (Math.abs(o1) > Math.abs(o2)) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public int maximumProduct(int[] nums) {
        Integer[] inte = IntStream.of(nums).boxed().collect(Collectors.toList()).toArray(new Integer[0]);

        Arrays.sort(inte, new Com());

        int finalLength = inte.length > 3 ? inte.length > 8 ? 8 : inte.length : 3;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < finalLength; i++) {
            for (int j = i + 1; j < finalLength; j++) {
                for (int k = j + 1; k < finalLength; k++) {
                    if (inte[i] * inte[j] * inte[k] > result) {
                        result = inte[i] * inte[j] * inte[k];
                    }
                }
            }
        }

        return result;
    }
}
