package org.dvn.leetcode.medium.hashmap_set;

import java.util.HashMap;
import java.util.Map;

//1657
public class DetermineIfTwoStringsAreClose {

    public static void main(String[] args) {
        String str1 = "cabbba";
        String str2 = "abbccc";

        System.out.println(new DetermineIfTwoStringsAreClose().closeStrings(str1, str2));
    }


    public boolean closeStrings(String word1, String word2) {

        if (word1.length() != word2.length()) return false;

        Map<Character, Integer> mapaWord1 = putCharsIntoMap(word1);
        Map<Character, Integer> mapaWord2 = putCharsIntoMap(word2);

        for (char c: mapaWord1.keySet()) {
            if (!mapaWord2.containsKey(c)) {
                return false;
            }
            if (!mapaWord2.containsValue(mapaWord1.get(c))) {
                return false;
            }
        }

        return true;
    }

    private Map<Character, Integer> putCharsIntoMap(String word) {
        Map<Character, Integer> mapa = new HashMap<>();

        for (int i = 0; i <= word.length() - 1; i++) {
            char c = word.charAt(i);
            if (mapa.containsKey(c)) {
                mapa.put(c, mapa.get(c) + 1);
            } else {
                mapa.put(c, 1);
            }
        }
        return mapa;
    }
}
