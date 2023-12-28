package org.dvn.ya.hashstrings;

import java.io.BufferedReader;
import java.io.FileReader;

public class StringBase {
    private static int x = 257;
    private static int p = 1000000000 + 7;

    private static String str;
    private static long[] hashs;
    private static long[] xs;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            str = reader.readLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        hashs = new long[str.length() + 1];
        hashs[0] = 0;
        xs = new long[str.length() + 1];
        xs[0] = 1;
        for (int i = 1; i <= str.length(); i++) {
            char character = str.charAt(i - 1);
            hashs[i] = (hashs[i - 1] * x + character) % p;
            xs[i] = (xs[i - 1] * x) % p;
        }

        System.out.println(getMinimumSubStr(str));
    }

    private static int getMinimumSubStr(String str) {
        if (str.isBlank()) return 0;

        int length = 1;
        int start = 0;
        int end = 1;

        while (!isEquals(length, start, end)) {
            length++;
            end++;
            if ((end + length) > str.length()) return str.length();
        }


        return length;
    }

    private static boolean isEquals(int l, int a, int b) {
        long hashA = (hashs[a + l] + hashs[b] * xs[l]) % p;
        long hashB = (hashs[b + l] + hashs[a] * xs[l]) % p;

        return hashA == hashB;
    }
}
