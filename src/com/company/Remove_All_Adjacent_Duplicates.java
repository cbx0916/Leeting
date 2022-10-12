package com.company;

public class Remove_All_Adjacent_Duplicates {
    public static String removeDuplicates(String s, int k) {
        int i = 0, n = s.length();
        int[] cnt = new int[n];
        char[] stack = s.toCharArray();
        for (int j = 0; j < n; ++i, ++j){
            stack[i] = stack[j];
            if(i > 0 && stack[i - 1] == stack[j])
                cnt[i] = cnt[i - 1] + 1;
            else
                cnt[i] = 1;
            if(cnt[i] == k) i -= k;
        }
        return new String(stack,0,i);
    }

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(removeDuplicates(s,k));
    }

}
