package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void name() {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int maxForm = new Solution().findMaxForm(strs, 5, 3);

        Assertions.assertEquals(4, maxForm);
    }
}