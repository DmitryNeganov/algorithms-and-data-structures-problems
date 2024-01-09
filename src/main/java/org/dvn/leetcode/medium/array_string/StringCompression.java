package org.dvn.leetcode.medium.array_string;

import java.util.ArrayList;
import java.util.List;

//443
public class StringCompression {

    public int compress(char[] chars) {
        if (chars.length == 1) return 1;
        List<Character> compressed = new ArrayList<>();
        int counter = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                counter++;
            } else {
                compressed.add(chars[i]);
                compressed.addAll(addCounterDigits(counter));
                counter = 1;
            }
        }
        compressed.add(chars[chars.length - 1]);
        compressed.addAll(addCounterDigits(counter));

        for (int i = 0; i < compressed.size(); i++) {
            chars[i] = compressed.get(i);
        }
        return compressed.size();
    }


    private List<Character> addCounterDigits(int counter) {
        List<Character> counterDigitsList = new ArrayList<>();
        if (counter > 1) {
            for (char c: String.valueOf(counter).toCharArray()) {
                counterDigitsList.add(c);
            }
        }
        return counterDigitsList;
    }
}
