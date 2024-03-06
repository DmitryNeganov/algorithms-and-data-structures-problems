package org.dvn.leetcode.easy.hashmap_set;

import java.util.HashMap;
import java.util.Map;

//383
public class RansomNote {


    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> mapa = new HashMap<>();

        for (char c: magazine.toCharArray()) {
            if (mapa.containsKey(c)) {
                mapa.put(c, mapa.get(c) + 1);
            } else {
                mapa.put(c, 1);
            }
        }

        for (char c: ransomNote.toCharArray()) {
            if (mapa.containsKey(c) && mapa.get(c) > 0) {
                mapa.put(c, mapa.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
