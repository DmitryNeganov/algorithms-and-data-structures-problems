package org.dvn.ya.paths;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class Dijkstra {

    public static void main(String[] args) {
        int N, start, finish;
        int[][] matrix;
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String firstInputLine = reader.readLine();
            String[] firstLineData = firstInputLine.split(" ");
            N = parseInt(firstLineData[0]);
            start = parseInt(firstLineData[0]);
            finish = parseInt(firstLineData[0]);

            matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] dataLine = reader.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = parseInt(dataLine[j]);
                }
            }

            getShortestPath(matrix, start, finish);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getShortestPath(int[][] matrix, int start, int finish) {
        int size = matrix.length;
        boolean[] visited = new boolean[size];
        int[] pathLengths = new int[size];

        for (int i = 0; i < size; i++) {

        }


        return 0;
    }


}
