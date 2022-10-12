package com.company;

public class Single_Element_in_a_Sorted_Array {
    public static int singleNonDuplicate(int[] nums) {
        int z=nums[0];
        for(int i=1;i<nums.length;i++){
            z = z^nums[i];
        }
        return z;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }
}
