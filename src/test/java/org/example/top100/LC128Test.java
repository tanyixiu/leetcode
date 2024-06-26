package org.example.top100;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LC128Test {
    @Test
    void case1() {
        LC128 lc = new LC128();
        int[] nums = {100, 4, 200, 1, 3, 2};
        int max = lc.longestConsecutive(nums);
        Assertions.assertEquals(4, max);
    }

    @Test
    void case2() {
        LC128 lc = new LC128();
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int max = lc.longestConsecutive(nums);
        Assertions.assertEquals(9, max);
    }

    @Test
    void case3() {
        LC128 lc = new LC128();
        int[] nums = {1, 2, 0, 1};
        int max = lc.longestConsecutive(nums);
        Assertions.assertEquals(3, max);
    }

    @Test
    void case4() {
        LC128 lc = new LC128();
        int[] nums = {4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3};
        int max = lc.longestConsecutive(nums);
        Assertions.assertEquals(5, max);
    }
}