package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    int[] nums = {1,1,2};

    @Test
    public void testNums(){
        int result = Solution.removeDuplicates(nums);
        Assert.assertEquals(2,result);
    }
}
