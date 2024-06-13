package org.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LC5Test {
    @Test
    void case1() {
        LC5 lc5 = new LC5();
        Assertions.assertTrue(lc5.isPalindrome("a"));
        Assertions.assertTrue(lc5.isPalindrome("aba"));
        Assertions.assertTrue(lc5.isPalindrome("cddc"));
        Assertions.assertTrue(lc5.isPalindrome(""));
        Assertions.assertFalse(lc5.isPalindrome("ab"));
        Assertions.assertFalse(lc5.isPalindrome("abcd"));
        Assertions.assertFalse(lc5.isPalindrome("abcde"));
    }

    @Test
    void case2() {
        LC5 lc5 = new LC5();
        String longestPalindrome = lc5.longestPalindrome("ac");
        Assertions.assertEquals("a", longestPalindrome);
    }
}