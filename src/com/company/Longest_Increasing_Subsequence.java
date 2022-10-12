package com.company;

public class Longest_Increasing_Subsequence {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for(int x:nums){
            int l = 0, r = size;
            while(l != r){
                int mid = l + (r - l) / 2;
                if(tails[mid] < x) l = mid + 1;
                else r = mid;
            }
            tails[l] = x;
            if (l == size) ++size;
        }
        return size;
    }

    public static void main(String[] args) {

    }
}
