package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Two_City_Scheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] - o1[1]) - (o2[0] - o2[1]);
            }
        });
        int sum = 0;
        for (int i = 0; i < costs.length; ++i) {
            if (i < costs.length >> 1)
                sum += costs[i][0];
            else
                sum += costs[i][1];

        }
        return sum;
    }

    public int twoCitySchedCostDP(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= costs.length; i++) {
            dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
        }
        for (int j = 1; j <= costs.length; j++) {
            dp[j][1] = dp[j - 1][1] + costs[j - 1][1];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0],
                        dp[i][j - 1] + costs[i + j - 1][1]);
            }
        }
        return dp[n][n];
    }



}
