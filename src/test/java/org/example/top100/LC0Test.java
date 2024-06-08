package org.example.top100;

import org.junit.jupiter.api.Test;

class LC0Test {
    @Test
    void case1() {
        LC0 lc = new LC0();
//        int[][] nums = {{1, 4}, {0, 5}};
        int[][] nums = {{4, 5}, {1, 4}, {0, 1}};
        lc.merge(nums);
    }

    @Test
    void case2() {
        LC0 lc = new LC0();
//        int[] nums = {1, 3, 5, 6};
//        int r = lc.temp(nums, 2);
//        Assertions.assertEquals(1, r);
    }
}