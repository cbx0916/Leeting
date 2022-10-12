package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_II {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 1) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,used,list,res);
        return res;
    }
    private static void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if (list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (used[i]) continue;
            if (i > 0 && nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i] = true;
            System.out.println("i: "+i);
            System.out.println("used:"+Arrays.toString(used));
            list.add(nums[i]);
            System.out.println("list: "+list);
            dfs(nums,used,list,res);

            System.out.println("i:"+i);
            used[i] = false;
            System.out.println("used:"+Arrays.toString(used));
            System.out.println("list.size:"+list.size());
            list.remove(list.size() - 1);
            System.out.println("list: "+list);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] nums2 = {1,1,2};
        permuteUnique(nums);

    }


}



















