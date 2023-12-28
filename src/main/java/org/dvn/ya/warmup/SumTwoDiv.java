package org.dvn.ya.warmup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumTwoDiv {
    public static void main(String[] args) {
        int a, b, c, d;
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String firstInputLine = reader.readLine();
            String[] dataFirstLine = firstInputLine.split(" ");
            a = Integer.parseInt(dataFirstLine[0]);
            b = Integer.parseInt(dataFirstLine[1]);
            c = Integer.parseInt(dataFirstLine[2]);
            d = Integer.parseInt(dataFirstLine[3]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(getSumOfTwoDiv(a, b, c, d));
    }

    private static String getSumOfTwoDiv(int a, int b, int c, int d) {
        int m, n;
        m = a * d + c * b;
        n = b * d;
        int gcd = getGCD(m, n);

        return m / gcd + " " + n / gcd;
    }

    private static int getGCD(int m, int n) {
        if (m > n) {
            if (n == 0) return m;
            return getGCD(m % n, n);
        } else if (n > m) {
            if (m == 0) return n;
            return getGCD(m, n % m);
        } else {
            return m;
        }
    }
}