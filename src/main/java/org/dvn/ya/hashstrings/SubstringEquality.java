package org.dvn.ya.hashstrings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SubstringEquality {
    private static int x = 257;
    private static int p = 1000000000 + 7;

    private static String str;
    private static long[] hashs;
    private static long[] xs;

    public static void main(String[] args) {
        int q;
        int[] l, a, b;
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {

            str = reader.readLine();

            String secondInputLine = reader.readLine();
            q = Integer.parseInt(secondInputLine);

            l = new int[q];
            a = new int[q];
            b = new int[q];

            for (int i = 0; i < q; i++) {
                String currentInputLine = reader.readLine();
                String[] data = currentInputLine.split(" ");
                l[i] = Integer.parseInt(data[0]);
                a[i] = Integer.parseInt(data[1]);
                b[i] = Integer.parseInt(data[2]);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
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

        for (int i = 0; i < q; i++) {
            System.out.println(isEquals(l[i], a[i], b[i]) ? "yes" : "no");
        }

    }

    private static boolean isEquals(int l, int a, int b) {
        long hashA = (hashs[a + l] + hashs[b] * xs[l]) % p;
        long hashB = (hashs[b + l] + hashs[a] * xs[l]) % p;

        return hashA == hashB;
    }
}


//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
//            for (int i = 0; i < n; i++) {
//                writer.write(resultArray[i] + " ");
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }