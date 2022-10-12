package com.company;

import java.util.Arrays;
import java.util.Map;

public class Jump_Game_II {
    public static int jump(int[] nums) {
        if (nums[0] == 0)
            return 0;
        if (nums.length == 1) return 0;
        int step = 0;
        int curDis = 0;
        int nxtDis = 0;
        for (int i = 0; i < nums.length - 1; i++){
            nxtDis = Math.max(nums[i] + i, nxtDis);
            if (i == curDis){
                step++;
                System.out.println("i:"+i+"  cur:"+curDis+"  nxt:"+nxtDis);
                curDis = nxtDis;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,0,1,4};
        int[] nums2 = new int[]{1,2,1,1,1};
        System.out.println(jump(nums2));
        System.out.println();
    }
}
