package com.company;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Numbers_Disappeared_in_an_Array {
    static class Solution {
        public static List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> arr = new ArrayList<Integer>();
            for(int i=0;i<nums.length;i++){
                int j = Math.abs(nums[i])-1;
                if(nums[j]>0) nums[j] = -nums[j];
            }
            for (int i=0;i<nums.length;i++){
                if (nums[i]>0){
                    arr.add(i+1);
                }
            }
            return arr;
        }
    }
    public static void main(String[] args) {
        // write your code here
        int[] arr = new int[] {4,3,2,7,8,2,3,1};
        System.out.println(Find_All_Numbers_Disappeared_in_an_Array.Solution.findDisappearedNumbers(arr));


    }
}
