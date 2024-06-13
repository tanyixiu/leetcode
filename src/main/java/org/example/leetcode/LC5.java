package org.example.leetcode;

public class LC5 {
    public String longestPalindrome(String s) {
        String maxMatchStr = "";
        int distance = s.length();
        for (int i = 0; i < s.length() && maxMatchStr.length() < distance; i++) {
            char x = s.charAt(i);
            int j = s.length() - 1;
            distance = j + 1 - i;
            while (j >= i && isLongerThanMax(maxMatchStr, i, j)) {
                if (x == s.charAt(j) && isPalindrome(s.substring(i, j + 1))) {
                    maxMatchStr = s.substring(i, j + 1);
                    break;
                } else {
                    j--;
                }
            }
        }
        return maxMatchStr;
    }

    private boolean isLongerThanMax(String maxMatchStr, int start, int end) {
        return end + 1 - start > maxMatchStr.length();
    }

    public boolean isPalindrome(String str) {
        for (int i = 0; i < (str.length()) / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
