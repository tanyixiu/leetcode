package org.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LC14Test {
    @Test
    void case1() {
        LC14 lc = new LC14();
        String[] strs = {"flower", "flow", "flight"};
        String commonPrefix = lc.longestCommonPrefix(strs);
        Assertions.assertEquals("fl", commonPrefix);
    }

    @Test
    void case2() {
        LC14 lc = new LC14();
        String[] strs = {"dog", "racecar", "car"};
        String commonPrefix = lc.longestCommonPrefix(strs);
        Assertions.assertEquals("", commonPrefix);
    }

    @Test
    void case3() {
        LC14 lc = new LC14();
        String[] strs = {"ab", "a"};
        String commonPrefix = lc.longestCommonPrefix(strs);
        Assertions.assertEquals("a", commonPrefix);
    }
}