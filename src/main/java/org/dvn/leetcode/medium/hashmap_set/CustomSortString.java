package org.dvn.leetcode.medium.hashmap_set;

import java.util.HashMap;
import java.util.Map;

//791. Custom Sort String
public class CustomSortString {

    public String customSortString(String order, String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c: s.toCharArray()) {
            if (freqMap.containsKey(c)) {
                freqMap.put(c, freqMap.get(c) + 1);
            } else {
                freqMap.put(c, 1);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c: order.toCharArray()) {
            if (freqMap.containsKey(c)) {
                int n = freqMap.get(c);
                freqMap.remove(c);
                for (int i = 0; i < n; i++) {
                    result.append(c);
                }
            }
        }

        for (char c: freqMap.keySet()) {
            int n = freqMap.get(c);
            for (int i = 0; i < n; i++) {
                result.append(c);
            }
        }


        return result.toString();
    }
}
