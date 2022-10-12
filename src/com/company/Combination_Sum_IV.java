package com.company;

public class Combination_Sum_IV {

    public static int combinationSum4(int[] nums, int target) {
        if (target == 0)  return 1;

        int count = 0;
        for (int i = 0; i < nums.length; i++)
            if (target >= nums[i])
                count += combinationSum4(nums,target - nums[i]);

        return count;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3}; //7
        int target = 4;
        System.out.println(combinationSum4(nums,target));
    }
}
