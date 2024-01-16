package org.dvn.leetcode.medium.hashmap_set;

import java.util.Arrays;

//1657
public class DetermineIfTwoStringsAreClose {

    public boolean closeStrings(String word1, String word2) {

        int[] freq1 = countFreqs(word1);
        int[] freq2 = countFreqs(word2);

        for (int i = 0; i < 26; i++) {
            if ( ( (freq1[i] > 0)&& freq2[i] == 0) || (freq1[i]==0 && (freq2[i] > 0) ) ) {
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for (int i = 0; i < 26; i++) {
            int current = freq1[i] - freq2[i];
            if (current != 0) {
                return false;
            }
        }
        return true;
    }

    private int[] countFreqs(String word) {
        int[] freq = new int[26];
        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }
        return freq;
    }

}
