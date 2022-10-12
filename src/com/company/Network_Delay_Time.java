package com.company;

import sun.font.CreatedFontTracker;

import java.util.*;

public class Network_Delay_Time {
    public static int netWorkDelayTime(int[][] times,int N, int K){
        Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
        for (int[] time : times){
            map.putIfAbsent(time[0],new HashMap<>());
            map.get(time[0]).put(time[1],time[2]);
        }

        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        pq.add(new int[]{0,K});

        boolean[] visited = new boolean[N+1];
        int res = 0;
        while (!pq.isEmpty()){
            int[] cur = pq.remove();
            int curNode = cur[1];
            int curDist = cur[0];
            if (visited[curNode]) continue;
            visited[curNode] = true;
            res = curDist;
            N--;
            if (map.containsKey(curNode)){
                for (int next:map.get(curNode).keySet()){
                    System.out.println("next: "+next);
                    pq.add(new int[]{curDist + map.get(curNode).get(next),next});
                    System.out.println("map.get(curNode).get(next) : "+map.get(curNode).get(next));
                }
            }
        }
    return N==0 ? res : -1;
    }

    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;
        netWorkDelayTime(times,n,k);
    }

}
