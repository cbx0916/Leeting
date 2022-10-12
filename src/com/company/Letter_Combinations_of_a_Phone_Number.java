package com.company;

import java.util.LinkedList;
import java.util.List;

public class Letter_Combinations_of_a_Phone_Number {
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while(ans.peek().length() != digits.length()){
            String remove = ans.remove();

            System.out.println("remove is "+remove);
            System.out.print("index:");
            System.out.println((remove.length()));
            String map = mapping[digits.charAt(remove.length())-'0'];
            System.out.println("map is "+map);
            for(char c:map.toCharArray())   // a b c -> def
                ans.addLast(remove+c);  // ans = "a","b","c" -> b, c, ad, ae, af
            System.out.println("ans.peek:"+ans.peek());
        }
        return ans;
    }

    public static List<String> letterComb(String digits){
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty()) return ans;

        String[] mapping = new String[] {"0", "1","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while (ans.peek().length() != digits.length()){
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length())-'0'];
            for (char c:map.toCharArray())
                ans.add(remove+c);
        }
        return ans;
    }

    public static void main(String[] args) {
        String asd = "23";
        //System.out.println(asd.charAt(-48));
        System.out.println(letterCombinations(asd));
        System.out.println(letterComb(asd));
    }
}
