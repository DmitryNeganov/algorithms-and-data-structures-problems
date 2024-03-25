package org.dvn.leetcode.medium.hashmap_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//763. Partition Labels
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> mapaLast = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mapaLast.containsKey(c)) {
                mapaLast.remove(c);
            }
            mapaLast.put(c, i);
        }

        int left = 0, right = mapaLast.get(s.charAt(0));

        for (int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);
            int currentLast = mapaLast.get(current);
            if (right < currentLast) {
                right = currentLast;
            }
            if (right == i) {
                result.add(right - left + 1);
                left = i + 1;
            }


        }
        return result;
    }
}
