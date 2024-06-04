package org.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LC416Test {
    @Test
    void case1() {
        int[] nums = {1, 5, 11, 5};
        Assertions.assertTrue(new LC416().canPartition(nums));
    }

    @Test
    void case2() {
        int[] nums = {1, 2, 3, 5};
        Assertions.assertFalse(new LC416().canPartition(nums));
    }

    @Test
    void case3() {
        int[] nums = {2, 2, 1, 1};
        Assertions.assertTrue(new LC416().canPartition(nums));
    }
}