package org.dvn.ya.warmup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static void main(String[] args) {
        String str1, str2;
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            str1 = reader.readLine();
            str2 = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        boolean isAnagram = isAnagram(str1, str2);

        System.out.println(isAnagram ? "YES" : "NO");
    }

    private static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        Map<Character, Integer> mapa = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char charI = str1.charAt(i);
            if (mapa.containsKey(charI)) {
                mapa.put(charI, mapa.get(charI) + 1);
            } else {
                mapa.put(charI, 1);
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            char charI = str2.charAt(i);
            if (mapa.containsKey(charI)) {
                int quantity = mapa.get(charI);
                if ((quantity - 1) == 0) {
                    mapa.remove(charI);
                } else {
                    mapa.put(charI, quantity - 1);
                }
            } else {
                return false;
            }
        }

        return mapa.isEmpty();
    }
}
