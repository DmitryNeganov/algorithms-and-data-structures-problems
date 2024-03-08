package org.dvn.leetcode.medium.sliding_window;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//137
public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> repeteadSet = new HashSet<>();

        int left = 0;
        int right = 0 + 10;

        while (right < s.length()) {
            String currentDna = s.substring(left, right);
            if (set.contains(currentDna)) {
                repeteadSet.add(currentDna);
            } else {
                set.add(currentDna);
            }

            left++;
            right++;
        }

        return new ArrayList<String>(repeteadSet);
    }
}
