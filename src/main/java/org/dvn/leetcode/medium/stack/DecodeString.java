package org.dvn.leetcode.medium.stack;

import java.util.LinkedList;

//394
public class DecodeString {
    public String decodeString(String s) {
        LinkedList<Integer> nums = new LinkedList<>();
        LinkedList<StringBuilder> stringStack = new LinkedList<>();
        StringBuilder strBuilder = new StringBuilder();

        int n = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                n = n * 10 + Character.getNumericValue(c);
            } else  if (c == '[') {
                nums.add(n == 0 ? 1 : n);
                n = 0;
                stringStack.add(strBuilder);
                strBuilder = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = strBuilder;
                int k = nums.pollLast();
                strBuilder = stringStack.pollLast();
                for (int j = 0; j < k; j++) {
                    strBuilder.append(temp);
                }
            } else {
                strBuilder.append(c);
            }
        }

        return strBuilder.toString();

    }
}
