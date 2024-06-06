package org.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LC879Test {
    @Test
    void case1() {
        int[] group = {2, 2};
        int[] profit = {2, 3};
        int result = new LC879().profitableSchemes(5, 3, group, profit);
        Assertions.assertEquals(2, result);
    }

    @Test
    void case2() {
        int[] group = {2, 3, 5};
        int[] profit = {6, 7, 8};
        int result = new LC879().profitableSchemes(10, 5, group, profit);
        Assertions.assertEquals(7, result);
    }
}