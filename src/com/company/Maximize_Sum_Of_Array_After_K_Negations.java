package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Maximize_Sum_Of_Array_After_K_Negations {
    public static int largestSumAfterKNegations(int[] nums, int k) {
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }

        }
        if (k % 2 == 1){
            nums[nums.length - 1] = -nums[nums.length - 1];
        }

        System.out.println(Arrays.toString(nums));

        int sum = 0;
        for (int i:nums)
            sum += i;

        return sum;
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr,0,arr.length-1);
    }
    public static void quickSort(int[] arr, int l, int r){
        if (l < r) {
            swap(arr,l + (int)Math.random() * (r - l + 1),r);
            int[] tmp = partition(arr, l, r);
            quickSort(arr,l,tmp[0] - 1);
            quickSort(arr,tmp[1] + 1, r);
        }
    }
    public static int[] partition(int[] arr, int l, int r){
        int less = l-1; //小于等于区域的右边界
        int more = r;   //大于区域的做边界

        while (l < more){ //若小于，做三件事情 1.和小于区右边界下一个数做交换swap 2.小于区右扩less++ 3.下一个数l++
            if (Math.abs(arr[l]) < Math.abs(arr[r]))
                swap(arr, l, --more);

            else if (Math.abs(arr[l]) > Math.abs(arr[r])) //若大于，两件事 1.和大于区前一个数交换swap 2.大于区左扩more-- 3.l原地不变
                swap(arr,l++,++less);
            else                       //若等于，下一个数l++
                l++;
        }
        swap(arr,more,r);   //r位置上作为比较基准，介于less和more之间，放在more之前
        return new int[] {less + 1,more};
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4,2,3};     //5
        int k = 1;
        int[] nums2 = new int[] {3,-1,0,2}; //6
        int k2 = 3;
        int[] nums3 = new int[] {2,-3,-1,5,-4};
        int k3 = 2;
        System.out.println(largestSumAfterKNegations(nums3,k3));
    }
}
