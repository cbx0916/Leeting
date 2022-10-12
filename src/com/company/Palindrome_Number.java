package com.company;

public class Palindrome_Number {
    static class Solution {
        public static boolean isPalindrome(int x) {
            int sum = 0;
            int temp=x;
            if(x<11){
                return false;
            }else{
                while (temp!=0) {
                    int t = temp % 10;
                    sum = sum * 10 + t;
                    temp = temp/10;
                }
                if (sum==x)
                    return true;
                else {
                    return false;
                }
            }

        }
        public static void main(String[] args) {
            int[] a = {3,4,2};
            System.out.println(isPalindrome(101));

        }
    }

}
