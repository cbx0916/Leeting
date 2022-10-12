package com.company;

public class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int global = nums[0];
        int local = nums[0];
        for(int i=1;i<nums.length;i++){
            local = Math.max(nums[i],local+nums[i]);
            global = Math.max(local,global);
        }
        return global;
    }
    public static int maxSubArray2(int[] nums) {
        int local = nums[0];
        int global = nums[0];
        for(int i=1;i<nums.length;i++){
            System.out.println("loacl="+local+" global="+global+" nums[i]="+nums[i]);
            if(local > 0){
                local = local + nums[i];
            }else{
                local = nums[i];
            }
            global = Math.max(local,global);
            System.out.println("loacl="+local+" global="+global);
        }
        return global;
    }
    public static int maxSubArrayTest(int[] nums){
        if (nums.length < 2) return nums[0];
        int local = nums[0];
        int global = nums[0];

        for (int i = 1; i < nums.length; i++){
            if (local > 0)
                local = local + nums[i];
            else
                local = nums[i];
            global = Math.max(global,local);
        }
        return global;
    }

    public static int maxSub(int[] nums){
        int sum = 0;
        int res = Integer.MIN_VALUE;
        if (nums.length < 2) return nums[0];
        for (int i : nums){
            sum += i;
            if (sum >= res)
                res = sum;
            if (sum <= 0)
                sum = 0;
        }

        return res;
    }
    public static int maxSubTX(int[] nums){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (sum > max) max = sum;
            if (sum <= 0) sum = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2(a));
        System.out.println(maxSubArrayTest(a));
        System.out.println(maxSub(a));
    }
}

