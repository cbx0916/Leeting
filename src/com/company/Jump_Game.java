package com.company;

import java.util.Map;

public class Jump_Game {
    public static boolean canJump(int[] nums) {
        if(nums.length==1){return true;}
        int maxval = 0;
        for(int i=0;i<nums.length;i++){

            if (i>maxval){
                return false;
            }
            maxval = Math.max(i + nums[i],maxval);

            System.out.println(i+"-----"+maxval);
        }
        return true;
    }

    public static boolean canJump2(int[] nums){
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            if (i > max)
                return false;
            if (max < i + nums[i]) max = nums[i] + i;
        }
        return max >= nums.length ? true : false;
    }

    public static void main(String[] args) {
        int[] a = {2,3,1,1,4};
        int[] b = {3,2,1,0,4};
        System.out.println(canJump(a));
        System.out.println(canJump2(b));
    }
}
