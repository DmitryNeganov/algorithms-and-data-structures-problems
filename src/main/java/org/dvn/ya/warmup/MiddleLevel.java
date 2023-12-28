package org.dvn.ya.warmup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MiddleLevel {

    public static void main(String[] args) {
        int n;
        int[] a;
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String firstInputLine = reader.readLine();
            n = Integer.parseInt(firstInputLine);

            a = new int[n];
            String secondInputLine = reader.readLine();
            String[] dataSecondLine = secondInputLine.split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(dataSecondLine[i]);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int[] resultArray = findMiddleLevel(a);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            for (int i = 0; i < n ; i++) {
                writer.write(resultArray[i] + " ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static int[] findMiddleLevel(int[] a) {
        int[] result = new int[a.length];
        int sum = 0;
        for (int i = 0; i < a.length; i++) {

        }


        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        for (int j = 0; j < a.length; j++) {
            result[j] = sum - a[j] * a.length;
        }
        return result;
    }
}
