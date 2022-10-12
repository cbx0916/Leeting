package com.company;

public class House_Robber {
    public int rob(int[] nums) {
        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        if (nums.length==2) return Math.max(nums[0],nums[1]);



        int loacl = nums[0];
        int global = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp = global;
            global = Math.max(loacl+nums[i],global);
            loacl = tmp;
        }
        return global;

        //DP
//        int[] local = new int[nums.length];
//        int[] global = new int[nums.length];
//        local[0] = nums[0];
//        local[1] = nums[1];
//        for (int i=2;i<nums.length;i++){
//            local[i] = local[i-2] + nums[i];
//
//            global[i] = Math.max(local[i-1],local[i]);
//        }
//        return global[nums.length-1];
    }
}
