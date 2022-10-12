package com.company;

import java.util.*;

public class Path_With_Minimum_Effort {

    private static int[] dist = {0, 1, 0, -1, 0};
    public int minimumEffortPath(int[][] heights){
        int left = 0, right = Integer.MAX_VALUE;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (isOK(heights, mid)){
                right = mid;
            }else {
                left = mid + 1;
            }

        }
        return left;
    }
    public static boolean isOK(int[][] heights, int mid){
        int m = heights.length, n = heights[0].length;
        //int[][] visited = new int[m][n];
        //visited[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[2]);
        Set<Integer> seen = new HashSet<>();
        seen.add(0);

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            if (x == m - 1 && y == n - 1) return true;
            for (int k = 0; k < 4; ++k){
                int r = x + dist[k], c = y + dist[k+1];
                if (r >= 0 && r < m && c >= 0 && c < n && mid >= Math.abs(heights[r][c] - heights[x][y]) && seen.add(r * n + c))
                    queue.offer(new int[]{r,c});
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};

    }
}




















