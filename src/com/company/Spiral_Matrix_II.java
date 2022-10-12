package com.company;

public class Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int cnt = 1;

        for (int layer = 0; layer < (n + 1)/2; layer++){
            // left 2 right
            for (int ptr = layer; ptr < n - layer; ptr++)
                res[layer][ptr] = cnt++;
            // top 2 bottom
            for (int ptr = layer + 1; ptr < n - layer; ptr++)
                res[ptr][n - layer - 1] = cnt++;
            // right 2 left
            for (int ptr = layer + 1; ptr < n - layer; ptr++)
                res[n - layer - 1][n - ptr - 1] = cnt++;
            // bottom 2 top
            for (int ptr = layer + 1; ptr < n - layer - 1; ptr++)
                res[n - ptr - 1][layer] = cnt++;

        }
        return res;
    }
}
