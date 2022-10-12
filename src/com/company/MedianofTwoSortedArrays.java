package com.company;


public class MedianofTwoSortedArrays {

    static class Solution {
        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length){
                return findMedianSortedArrays(nums2,nums1);
            }
            double ans=0;
            int low = 0;
            int high = nums1.length;
            int k = (nums1.length + nums2.length + 1)>>1 ;
            int midA = 0;
            int midB = 0;

            while (low <= high){
                //..........mums1[midA-1],mums1[midA]...........
                //..........mums2[midB-1],mums2[midB]...........
                midA = low + (high-low)/2;
                midB = k - midA;
                if(midA>0 && nums1[midA-1]>nums2[midB]){
                    high = midA-1;
                }else if(midA!= nums1.length && nums1[midA]<nums2[midB-1]){
                    low = midA+1;
                }
                else {
                    break;
                }

            }
            int midl,midr = 0;
            if(midA==0) {
                midl = nums2[midB - 1];
            }else if(midB==0){
                midl = nums1[midA - 1];
            }else{
                midl = Math.max(nums1[midA-1],nums2[midB-1]);
            }

            if(((nums1.length + nums2.length) & 1) == 1){
                return (double)midl;
            }
            if (midA == nums1.length){
                midr = nums2[midB];
            }else if(midB == nums2.length){
                midr = nums1[midA];
            }else{
                midr = Math.min(nums1[midA],nums2[midB]);
            }
            return (double)(midl+midr)/2.0;
        }

    }

    public static void main(String[] args) {
	// write your code here
        int[] a1 = {1,2};
        int[] a2 = {3,4};


        System.out.println(Solution.findMedianSortedArrays(a1,a2));
    }
}
