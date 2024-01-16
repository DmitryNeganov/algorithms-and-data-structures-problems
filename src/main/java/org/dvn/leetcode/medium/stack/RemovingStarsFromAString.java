package org.dvn.leetcode.medium.stack;

import java.util.LinkedList;

//2390
public class RemovingStarsFromAString {

    public String removeStars(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                stack.pollLast();
            } else {
                stack.add(s.charAt(i));
            }
        }

        StringBuilder builder = new StringBuilder();
        stack.forEach(e -> builder.append(e));

        return builder.toString();
    }
}
