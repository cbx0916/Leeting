package com.company;

public class Search_Insert_Position {
    public static int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid = right/2;
        while(left < right){

            if(target == nums[mid]){
                return mid;
            }else if(target < nums[mid]){
                right = mid - 1;
                mid = (left + right)/2;
            }else {
                left = mid + 1;
                mid = (left + right)/2;
            }

        }
        if(target > nums[mid]) return mid+1;
        return mid;
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,6};
        System.out.println(searchInsert(a,5));
    }

}

