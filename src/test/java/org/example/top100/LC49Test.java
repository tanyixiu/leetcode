package org.example.top100;

import org.junit.jupiter.api.Test;

class LC49Test {
    @Test
    void case1() {
        LC49 lc = new LC49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        lc.groupAnagrams(strs);
    }
}