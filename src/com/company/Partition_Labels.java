package com.company;

import java.util.ArrayList;
import java.util.List;

public class Partition_Labels {
    public static List<Integer> partitionLabels(String s) {
        // get the last seen index for each letter 'a' - 'z'
        int[] last = new int[26];
        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a']=i;
        }

        int boundary = 0, cnt = 0;
        List<Integer> ans = new ArrayList();
        List<Integer> res = new ArrayList<>();
        for (int i=0;i<s.length();i++){
            // update boundary and cnt along the way
            char curChar = s.charAt(i);
            boundary = Math.max(boundary,last[curChar-'a']);
            cnt++;
            //if we reach the boundary, we collect result and reset count to 0
            if (i==boundary){
                res.add(cnt);
                cnt=0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
}
