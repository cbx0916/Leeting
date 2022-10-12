package com.company;

import java.util.Arrays;

public class Game_of_Life {
    static int die = 2;
    static int live = 3;
    public static void gameOfLife(int[][] board) {
        int x = board.length;
        int y = board[0].length;

        for (int i=0; i < x; i++){
            for (int j = 0; j < y; j++){
                int neighbor = getNeighbors(i,j,board);
                if (board[i][j] == 0){
                    if (neighbor == live)
                        board[i][j] = 2;
                }
                else if (board[i][j] == 1){
                    if (neighbor == 2 || neighbor == 3)
                        board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                board[i][j] >>= 1;

    }
    public static int getNeighbors(int m, int n, int[][] board){
        int count = 0;
        for (int i = m - 1; i <= m + 1; i++)
            for (int j = n - 1; j <= n + 1; j++)
                if (i>=0 && j>=0 && i<board.length && j<board[0].length)
                    count += board[i][j] & 1;
          count -= board[m][n] & 1;
          return count;
    }

    public static void main(String[] args) {
        int[][] Input= {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        int [][] Output = {{0,0,0},{1,0,1},{0,1,1},{0,1,0}};
        gameOfLife(Input);
        System.out.println(Arrays.toString(Input));

    }
}
