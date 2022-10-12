package com.company;

import org.junit.Test;
import sun.security.krb5.internal.PAData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Increasing_Subsequences {

    static class Solution1 {
        static List<List<Integer>> res = new ArrayList<>();
        static List<Integer> path = new ArrayList<>();



        public static List<List<Integer>> findSubsequences() {
            int[] nums2 = new int[]{4,4,3,2,1};
            int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,1,1,1,1,1};
            bktr(nums,0);
            //Arrays.toString(res.toArray());
            return res;

        }

        public static void bktr(int[] nums, int st){
            if(path.size() > 1)
                res.add(new ArrayList(path));
            //if(st >= nums.length )
            //    return;
            int[] uset = new int[201];
            for(int i = st; i < nums.length; i++){
                if((!path.isEmpty() && nums[i] < path.get(path.size()-1)) || uset[100+nums[i]] == 1)
                    continue;
                System.out.println(path);
                path.add(nums[i]);
                uset[100+nums[i]] = 1;
                bktr(nums,i+1);
                path.remove(path.size() - 1);


            }
        }
        public boolean isGreater(int[] nums,int st, int end){
            if(nums[st] > nums[end])
                return true;
            return false;
        }
    }

    static class Solution2 {
        static List<List<Integer>> res = new ArrayList<>();
        static List<Integer> path = new ArrayList<>();

        public static List<List<Integer>> findSubsequences(int[] nums) {
            bktr(nums,0);
            return res;
        }
        public static void bktr(int[] nums, int st){
            if(path.size() > 1) res.add(new ArrayList(path));
            int[] uset = new int[201];
            for (int i = st; i < nums.length; i++){
                if (((!path.isEmpty() && nums[i] >= path.get(path.size()-1)) && uset[nums[i] + 100] == 0 )|| path.isEmpty()){
                    System.out.println(path);
                    uset[nums[i]+100] = 1;
                    path.add(nums[i]);
                    bktr(nums,i+1);
                    path.remove(path.size() - 1);
                }
            }
        }
        public static boolean isGreater(int[] nums, int st, int end){
            if (nums[st] <= nums[end])
                return true;
            return false;
        }
    }

    @Test
    public void test() {

        int[] nums = new int[]{4,4,3,2,1};
        int[] nums2 = new int[]{1,2,3,4,5,6,7,8,9,10,1,1,1,1,1};
        System.out.println(Solution2.findSubsequences(nums2));
        System.out.println("-----------test----------");
        System.out.println(Solution1.findSubsequences());

    }


}
