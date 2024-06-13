package org.example.leetcode;

import java.util.stream.Stream;

public class LC14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        if (minLength == 0) {
            return "";
        }


        int low = 0;
        int high = minLength;

        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            String subStr = strs[0].substring(0, mid);
            if (Stream.of(strs).allMatch(s -> s.substring(0, mid).equals(subStr))) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }
}
