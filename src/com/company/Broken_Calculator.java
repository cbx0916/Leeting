package com.company;

public class Broken_Calculator {
    public static int brokenCalc(int startValue, int target) {
        int ans = 0;
        while (target > startValue){
            ans++;
            if (target % 2 == 1){
                target++;
            }else {
                target /= 2;
            }
        }
        return ans + startValue - target;
    }

    public static void main(String[] args) {
        System.out.println(3>>1);
        System.out.println(3/2);
        System.out.println(brokenCalc(5,8));
    }
}
