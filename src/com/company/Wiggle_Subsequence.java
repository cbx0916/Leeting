package com.company;

public class Wiggle_Subsequence {
    public static int wiggleMaxLength(int[] nums) {
        int count = 1;
        int preDiff = 0;

        for (int i = 0; i < nums.length - 1; i++){
            int curDiff = nums[i+1] - nums[i];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,7,4,9,2,5};//6
        int[] nums2 = new int[]{1,17,5,10,13,15,10,5,16,8};//7
        System.out.println(wiggleMaxLength(nums2));
    }
}
