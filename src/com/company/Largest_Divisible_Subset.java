package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Largest_Divisible_Subset {
    static class Solution {
        public static List<Integer> largestDivisibleSubset(int[] nums) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            if(nums.length == 1){
                list.add(nums[0]);
                return list;
            }
            int i =0;int j = 0;
            Set<Integer> ls = new HashSet<Integer>(nums[i]);
            for (;j<nums.length;j++){
                if(nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0){
                    ls.add(nums[j]);
                }
            }
            return (List<Integer>)ls;
        }
        public static void main(String[] args) {
            // write your code here
            int[] nums = {1,2,4};
            System.out.println(Largest_Divisible_Subset.Solution.largestDivisibleSubset(nums));


        }
    }
}
