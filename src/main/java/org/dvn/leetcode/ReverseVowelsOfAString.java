package org.dvn.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//345
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        List<Character> stack = new LinkedList<>();
        Set<Character> vowels = new TreeSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (vowels.contains(Character.toLowerCase(c))) {
                stack.addLast(c);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (vowels.contains(Character.toLowerCase(c))) {
                stringBuilder.append(stack.getLast());
                stack.removeLast();
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
