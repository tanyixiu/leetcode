package org.example.top100;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LC1Test {

    @Test
    void case1() {
        LC1 lc = new LC1();
        int[] nums = {2, 7, 11, 15};
        int[] sum = lc.twoSum(nums, 9);
        Assertions.assertEquals(0, sum[0]);
        Assertions.assertEquals(1, sum[1]);
    }

    @Test
    void case2() {
        LC1 lc = new LC1();
        int[] nums = {3,2,4};
        int[] sum = lc.twoSum(nums, 6);
        Assertions.assertEquals(1, sum[0]);
        Assertions.assertEquals(2, sum[1]);
    }
}