package org.dvn.leetcode.easy;

//392
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int sCounter = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(sCounter) == t.charAt(i)) {
                sCounter++;
                if (sCounter == (s.length())) {
                    return true;
                }
            }
        }
        return false;
    }
}
