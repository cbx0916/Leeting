package com.company;

public class Find_the_Duplicate_Number {
    public static int findDuplicate(int[] nums) {
        int x = 0;
        for (int i = 1; i <= nums.length-1; i++) {
            x = (x ^ i);
        }
        for (int i = 0; i < nums.length; i++) {
            x = x ^ nums[i];
        }
        //return x;

        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            System.out.println(cur);
            if (nums[cur] < 0) {
                duplicate = cur;
                break;
            }
            nums[cur] *= -1;
        }

        // Restore numbers
        for (int i = 0; i < nums.length; i++)
            nums[i] = Math.abs(nums[i]);

        return duplicate;

    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
}
