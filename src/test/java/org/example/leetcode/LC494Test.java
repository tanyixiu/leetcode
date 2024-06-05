package org.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LC494Test {

    @Test
    void case1() {

        int[] nums = {1, 1, 1, 1, 1};
        Assertions.assertEquals(5, (new LC494()).findTargetSumWays(nums, 3));
    }
}