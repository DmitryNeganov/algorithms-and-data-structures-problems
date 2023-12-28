package org.dvn.leetcode.easy;

//1071
public class GreatestCommonDivisorOfStrings {

    public static void main(String[] args) {
        GreatestCommonDivisorOfStrings gcd = new GreatestCommonDivisorOfStrings();
        String str1 = "ABCABC";
        String str2 = "ABC";

        System.out.println(gcd.gcdOfStrings(str1, str2));
    }

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcd = getGcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private int getGcd(int a, int b) {
        return b == 0 ? a : getGcd(b, a % b);
    }
}
