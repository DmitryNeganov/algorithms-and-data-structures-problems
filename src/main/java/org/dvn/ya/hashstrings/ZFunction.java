package org.dvn.ya.hashstrings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ZFunction {

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

        if (str.length() == 0) {
            System.out.println(0);
            return;
        }


        getHash();

        int[] z = getZFunc(str);

        StringBuilder  stringBuilder = new StringBuilder();
        for (int i : z) {
            stringBuilder.append(i + " ");
        }

        System.out.println(stringBuilder.toString());

//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
//            writer.write(stringBuilder.toString());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    private static int[] getZFunc(String str) {
        int[] result = new int[str.length()];
        result[0] = 0;
        for (int i = 1; i < str.length(); i++) {
            int left = 0;
            int right = str.length() - i;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (isEquals(mid, 0, i)) {
                    result[i] = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return result;
    }

    private static boolean isEquals(int l, int a, int b) {
        long hashA = (hashs[a + l] + hashs[b] * xs[l]) % p;
        long hashB = (hashs[b + l] + hashs[a] * xs[l]) % p;

        return hashA == hashB;
    }

    private static void getHash() {
        hashs = new long[str.length() + 1];
        hashs[0] = 0;
        xs = new long[str.length() + 1];
        xs[0] = 1;
        for (int i = 1; i <= str.length(); i++) {
            char character = str.charAt(i - 1);
            hashs[i] = (hashs[i - 1] * x + character) % p;
            xs[i] = (xs[i - 1] * x) % p;
        }
    }
}
