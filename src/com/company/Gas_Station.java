package com.company;

import java.util.ArrayList;
import java.util.List;

public class Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        int curSum = 0;
        int start = 0;
//        List<Integer> rest = new ArrayList<>();
        int[] rest = new int[n+1];
        for (int i=0; i<n; i++){
            rest[i] = gas[i] - cost[i];
            curSum += rest[i];
            sum += rest[i];
            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }
        if (sum < 0)    return -1;
        return start;
    }
}
