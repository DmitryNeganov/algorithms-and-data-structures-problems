package org.dvn.leetcode.easy.hashmap_set;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//1207
public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurencesValue = new TreeMap<>();

        for (int i: arr) {
            if (occurencesValue.containsKey(i)) {
                occurencesValue.put(i, occurencesValue.get(i) + 1);
            } else {
                occurencesValue.put(i, 1);
            }
        }
        Set<Integer> occurences = new HashSet<>();
        for (int o: occurencesValue.keySet()) {
            if (occurences.contains(occurencesValue.get(o))) {
                return false;
            }
            occurences.add(occurencesValue.get(o));
        }

        return true;
    }
}
