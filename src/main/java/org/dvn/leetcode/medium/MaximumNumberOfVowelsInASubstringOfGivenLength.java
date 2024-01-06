package org.dvn.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//1456
public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o','u'));
        int currentResult = 0;

        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                currentResult++;
            }
        }
        int max = currentResult;
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i - k))) {
                currentResult--;
            }
            if (vowels.contains(s.charAt(i))) {
                currentResult++;
            }
            if (currentResult == k) return currentResult;
            if (currentResult > max) max = currentResult;
        }

        return max;
    }
}
