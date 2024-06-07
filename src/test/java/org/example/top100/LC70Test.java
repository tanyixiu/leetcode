package org.example.top100;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LC70Test {
    @Test
    void case1() {
        LC70 lc = new LC70();
        int r = lc.climbStairs(3);

        Assertions.assertEquals(3,r);
    }
}