package com.company;

public class Longest_Palindromic_Substring {

    static  class Solution {
        public static String longestPalindrome(String s) {
            if(s.isEmpty()){
                return null;
            }
            if(s.length()==1){
                return s;
            }

            String longest = s.substring(0,1);
            for(int i=0; i<s.length(); i++){
                String tmp = getLong(s,i,i);
                if(tmp.length() > longest.length()){
                    longest = tmp;
                }
                tmp = getLong(s,i,i+1);
                if(tmp.length() > longest.length()){
                    longest = tmp;
                }
            }
            return longest;
        }
        public static String getLong(String s,int begin,int end){

            while(begin>=0 && end<=s.length()-1 && s.charAt(begin)==s.charAt(end)){
                begin--;
                end++;
            }

            return s.substring(begin+1,end);
        }
    }

    public static void main(String[] args) {
        // write your code here
        System.out.println(Solution.longestPalindrome("babad"));


    }
}
