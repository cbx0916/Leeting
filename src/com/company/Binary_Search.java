package com.company;

public class Binary_Search {
    public static int search(int[] nums, int target) {
        //int n = nums.length/2;
        int l = 0, r = nums.length-1;
        int tmp = 0;
        while (l <= r){
            tmp = l + (r-l)/2;
            if (target == nums[tmp])
                return  tmp;
            if (target < nums[tmp])
                r = tmp - 1;
            else
                l = tmp + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums,target));
    }
}
