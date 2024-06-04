package org.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LC474Test {
    @Test
    void case1() {
        String[] form = {"10", "0001", "111001", "1", "0"};
        Assertions.assertEquals(4, new LC474().findMaxForm(form, 5, 3));
    }
}