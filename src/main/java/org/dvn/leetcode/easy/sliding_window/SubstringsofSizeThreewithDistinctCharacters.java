package org.dvn.leetcode.easy.sliding_window;

//1876
public class SubstringsofSizeThreewithDistinctCharacters {

    public int countGoodSubstrings(String s) {
        int left = 0;
        int right = 0 + 2;

        int counter = 0;

        while (right < s.length()) {
            if (s.charAt(left) != s.charAt(left + 1)
                    && s.charAt(left + 1) != s.charAt(right)
                    && s.charAt(right) != s.charAt(left)) {
                counter++;
            }
            left++;
            right++;
        }

        return counter;
    }
}
