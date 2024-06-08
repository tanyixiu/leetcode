package org.example.top100;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LC35Test {
    @Test
    void case1() {
        LC35 lc = new LC35();
        int[] nums = {1, 3, 5, 6};
        int r = lc.searchInsert(nums, 5);
        Assertions.assertEquals(2, r);
    }

    @Test
    void case2() {
        LC35 lc = new LC35();
        int[] nums = {1, 3, 5, 6};
        int r = lc.searchInsert(nums, 2);
        Assertions.assertEquals(1, r);
    }

    @Test
    void case3() {
        LC35 lc = new LC35();
        int[] nums = {1, 3, 5, 6};
        int r = lc.searchInsert(nums, 7);
        Assertions.assertEquals(4, r);
    }
}