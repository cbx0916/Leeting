package com.company;

public class String_to_Integer {
    static class Solution {
        public static int myAtoi(String s) {
            int res = 0;
            int i = 0;
            while (s.charAt(i)==' '){
                i++;
            }
            if (s.charAt(i)=='-'){
                res = char2int(s,i+1);
                System.out.println(res);
                res = res>=2147483647 ? -2147483648:res*(-1);
            }else {
                res = char2int(s,i);
                res = res>2147483647 ? 2147483647:res;
            }


            return res;
        }
        public static int char2int(String s, int i){
            int res = 0;
            while (i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                res = res*10 + s.charAt(i)-48;
                if(res>=(2147483647-7)/10){
                    System.out.println("---"+res);
                    return 2147483647;
                }
                i++;
            }
            return res;
        }
    }
    public static void main(String[] args) {
        // write your code here
        System.out.println(String_to_Integer.Solution.myAtoi("-2147483649"));


    }
}
