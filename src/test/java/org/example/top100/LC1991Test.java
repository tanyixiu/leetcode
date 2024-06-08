package org.example.top100;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LC1991Test {
    @Test
    void case1() {
        LC1991 lc = new LC1991();
        int[] nums = {2, 3, -1, 8, 4};
        int r = lc.findMiddleIndex(nums);
        Assertions.assertEquals(3, r);
    }
}