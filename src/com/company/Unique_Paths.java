package com.company;

public class Unique_Paths {
    static class Solution {
        public static int uniquePaths(int m, int n) {

            int[][] dp = new int[n][m];
            int[] row,col;
            for(int i=0;i<m;i++){
                dp[0][i]=1;
            }
            for (int i=0;i<n;i++){
                dp[i][0]=1;
            }
            for(int i=1;i<n;i++){
                for (int j=1;j<m;j++){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
            return dp[n-1][m-1];
        }
    }
    public static void main(String[] args) {
        // write your code here
        System.out.println(Solution.uniquePaths(3,7));


    }
}
